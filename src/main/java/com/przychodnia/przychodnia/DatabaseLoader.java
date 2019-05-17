package com.przychodnia.przychodnia;

import com.przychodnia.przychodnia.Entity.*;
import com.przychodnia.przychodnia.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ReceptionistRepository receptionistRepository;

    @Autowired
    KartotekaRepository kartotekaRepository;

    @Autowired
    WizytaRepository wizytaRepository;

    @Autowired
    private PresciptionsRepository presciptionRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Doctor> doctors = createDoctors();
        createReceptionist();
        createPatientAndKartoteka("test1", doctors.get(0));
        createPatientAndKartoteka("test2", doctors.get(0));
        createPatientAndKartoteka("test3", doctors.get(1));
    }

    private void createPatientAndKartoteka(String username, Doctor doctor) {
        Patient patient = new Patient(username,username);
        patient.setFirstName(username);
        patient.setLastName(username);
        patient.setPesel(username);

        Kartoteka kartoteka = new Kartoteka();

        Wizyta wizyta1 = new Wizyta(LocalDateTime.now(),doctor);
        Wizyta wizyta2 = new Wizyta(LocalDateTime.now().plusDays(1),doctor);

        Presciption presciption = new Presciption(LocalDateTime.now(),doctor);
        Presciption presciption1 = new Presciption(LocalDateTime.now().plusDays(1),doctor);

        ArrayList<Wizyta> wizytaArrayList= new ArrayList<Wizyta>() {{
            add(wizyta1);
            add(wizyta2);
        }};

        ArrayList<Presciption> presciprionArrayList= new ArrayList<Presciption>() {{
            add(presciption);
            add(presciption1);
        }};

        this.saveAll(patient, kartoteka, wizytaArrayList ,presciprionArrayList);

        kartoteka.setWizytaList(wizytaArrayList);
        kartoteka.setPresciptions(presciprionArrayList);

        wizyta1.setKartoteka(kartoteka);
        wizyta2.setKartoteka(kartoteka);

        presciption.setKartoteka(kartoteka);
        presciption1.setKartoteka(kartoteka);

        this.saveAll(patient, kartoteka, wizytaArrayList, presciprionArrayList);

        patient.setKartoteka(kartoteka);
        kartoteka.setPatient(patient);

        this.saveAll(patient, kartoteka, wizytaArrayList, presciprionArrayList);
    }

    private void saveAll(Patient patient, Kartoteka kartoteka, List<Wizyta> wizyty, List<Presciption> presciptions){
        patientRepository.save(patient);
        kartotekaRepository.save(kartoteka);
        wizytaRepository.saveAll(wizyty);
        presciptionRepository.saveAll(presciptions);
    }

    private void createReceptionist() {
        Receptionist receptionist = new Receptionist("receptionist","receptionist");
        receptionistRepository.save(receptionist);
    }

    private List<Doctor> createDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        Doctor doctor = new Doctor("doktor","doktor");
        Doctor doctor2 = new Doctor("doktor2","doktor2");

        doctor.setFirstName("Krzysztof");
        doctor.setLastName("Pieta");
        doctor.setPesel("1234");

        doctor2.setFirstName("Nie ma");
        doctor2.setLastName("klienta");
        doctor2.setPesel("6789");

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);

        doctors.add(doctor);
        doctors.add(doctor2);
        return doctors;
    }
}
