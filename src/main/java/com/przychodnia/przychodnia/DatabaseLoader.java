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

        this.saveAll(patient, kartoteka, wizyta1, wizyta2);

        ArrayList<Wizyta> wizytaArrayList= new ArrayList<Wizyta>() {{
            add(wizyta1);
            add(wizyta2);
        }};

        kartoteka.setWizytaList(wizytaArrayList);

        wizyta1.setKartoteka(kartoteka);
        wizyta2.setKartoteka(kartoteka);

        this.saveAll(patient, kartoteka, wizyta1, wizyta2);

        patient.setKartoteka(kartoteka);
        kartoteka.setPatient(patient);

        this.saveAll(patient, kartoteka, wizyta1, wizyta2);
    }

    private void saveAll(Patient patient, Kartoteka kartoteka, Wizyta wizyta1, Wizyta wizyta2){
        patientRepository.save(patient);
        kartotekaRepository.save(kartoteka);
        wizytaRepository.save(wizyta1);
        wizytaRepository.save(wizyta2);
    }

    private void createReceptionist() {
        Receptionist receptionist = new Receptionist("receptionist","receptionist");
        receptionistRepository.save(receptionist);
    }

    private List<Doctor> createDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        Doctor doctor = new Doctor("doktor","doktor");
        Doctor doctor2 = new Doctor("doktor2","doktor2");

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);

        doctors.add(doctor);
        doctors.add(doctor2);
        return doctors;
    }
}
