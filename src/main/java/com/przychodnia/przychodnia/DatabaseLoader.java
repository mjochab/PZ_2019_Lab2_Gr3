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

    @Autowired
    private NewsRepository newsRepository;


    @Override
    public void run(String... args) throws Exception {
        createNews();
        List<Doctor> doctors = createDoctors();
        createReceptionist();
        createPatientAndKartoteka("jkowalski32", doctors.get(0));
        createPatientAndKartoteka("anowak", doctors.get(0));
        createPatientAndKartoteka("kkrol", doctors.get(1));
    }

    private void createNews() {
        News news1 = new News("tytul"," velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia de");
        News news2 = new News("DARMOWE WYJAZDY DO SENATORIUM"," in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa ");
        News news3 = new News("DARMOWE BADANIE","a pariatur. Excepteur sint occaecat cupidatat non pr");
        ArrayList<News> news= new ArrayList<News>() {{
            add(news1);
            add(news2);
            add(news3);
        }};

        newsRepository.saveAll(news);
    }

    private void createPatientAndKartoteka(String username, Doctor doctor) {
        Patient patient = new Patient(username,username);
        patient.setFirstName(username);
        patient.setLastName(username);
        patient.setPesel(username);

        Kartoteka kartoteka = new Kartoteka();

        Wizyta wizyta1 = new Wizyta(LocalDateTime.now(),doctor);
        Wizyta wizyta2 = new Wizyta(LocalDateTime.now().plusDays(1),doctor);
        Wizyta wizyta3 = new Wizyta(LocalDateTime.now().minusDays(1),doctor);

        Presciption presciption = new Presciption(LocalDateTime.now(),doctor);
        Presciption presciption1 = new Presciption(LocalDateTime.now().plusDays(1),doctor);

        presciption.setDescription("zapalenie płuc");
        presciption1.setDescription("grypa");

        ArrayList<Wizyta> wizytaArrayList= new ArrayList<Wizyta>() {{
            add(wizyta1);
            add(wizyta2);
            add(wizyta3);
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
        wizyta3.setKartoteka(kartoteka);

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
        receptionist.setFirstName("Krystyna");
        receptionist.setLastName("Czubówna");
        receptionist.setPesel("97123012345");
        receptionistRepository.save(receptionist);
    }

    private List<Doctor> createDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        Doctor doctor = new Doctor("doktor","doktor");
        Doctor doctor2 = new Doctor("doktor2","doktor2");

        doctor.setFirstName("Krzysztof");
        doctor.setLastName("Zimek");
        doctor.setPesel("88021807693");

        doctor2.setFirstName("Andrzej");
        doctor2.setLastName("MAlinowski");
        doctor2.setPesel("83021807693");

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);

        doctors.add(doctor);
        doctors.add(doctor2);
        return doctors;
    }
}
