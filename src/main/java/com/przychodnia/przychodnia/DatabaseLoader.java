package com.przychodnia.przychodnia;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Kartoteka;
import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Entity.Receptionist;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
import com.przychodnia.przychodnia.Repository.KartotekaRepository;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.Repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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


    @Override
    public void run(String... args) throws Exception {
        createDoctors();
        createReceptionist();
        createPatientAndKartoteka();
    }

    private void createPatientAndKartoteka() {
        Patient patient = new Patient("patient","patient");
        Kartoteka kartoteka = new Kartoteka();

        patientRepository.save(patient);
        kartotekaRepository.save(kartoteka);

        patient.setKartoteka(kartoteka);
        kartoteka.setPatient(patient);

        patientRepository.save(patient);
        kartotekaRepository.save(kartoteka);


    }

    private void createReceptionist() {
        Receptionist receptionist = new Receptionist("receptionist","receptionist");
        receptionistRepository.save(receptionist);
    }

    private void createDoctors() {
        Doctor doctor = new Doctor("doktor","doktor");
        doctorRepository.save(doctor);
    }
}
