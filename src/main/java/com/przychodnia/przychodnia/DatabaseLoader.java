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
<<<<<<< HEAD
        createPatientAndKartoteka("Pawel","Krzycz","12345", doctors.get(0));
        createPatientAndKartoteka("Angela","Waleczna","5262346", doctors.get(0));
        createPatientAndKartoteka("Kamil","Stoch","425262627", doctors.get(1));
=======
        createPatientAndKartoteka("jkowalski32", doctors.get(0));
        createPatientAndKartoteka("anowak", doctors.get(0));
        createPatientAndKartoteka("kkrol", doctors.get(1));
>>>>>>> 3402f6a6234c20c4184c8605986fa99b728879c6
    }

    private void createNews() {
        News news1 = new News("SENATORIUM","zwolnilo sie miejsce w senatorium");
        News news2 = new News("APTEKA","w ciechanowie powstala nowa apteka");
        News news3 = new News("DARMOWE BADANIE","a pariatur. Excepteur sint occaecat cupidatat non pr");
        ArrayList<News> news= new ArrayList<News>() {{
            add(news1);
            add(news2);
            add(news3);
        }};

        newsRepository.saveAll(news);
    }

    private void createPatientAndKartoteka(String firstName,String lastName, String pesel, Doctor doctor) {
        Patient patient = new Patient(firstName,lastName);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPesel(pesel);

        Kartoteka kartoteka = new Kartoteka();

        Wizyta wizyta1 = new Wizyta(LocalDateTime.now().plusDays(1),doctor);
        Wizyta wizyta2 = new Wizyta(LocalDateTime.now().plusDays(2),doctor);
        Wizyta wizyta3 = new Wizyta(LocalDateTime.now().minusDays(3),doctor);

        Presciption presciption = new Presciption(LocalDateTime.now(),doctor);
        Presciption presciption1 = new Presciption(LocalDateTime.now().plusDays(1),doctor);

<<<<<<< HEAD
        presciption.setDescription("rak odbytu");
        presciption1.setDescription("Zażywać witaminę C");
=======
        presciption.setDescription("zapalenie płuc");
        presciption1.setDescription("grypa");
>>>>>>> 3402f6a6234c20c4184c8605986fa99b728879c6

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
<<<<<<< HEAD
        Receptionist receptionist = new Receptionist("Adam","Malysz");
        receptionist.setFirstName("Adam");
        receptionist.setLastName("Malysz");
        receptionist.setPesel("14567");

        Receptionist receptionist2 = new Receptionist("Agnieszka","Papuszka");
        receptionist2.setFirstName("Agnieszka");
        receptionist2.setLastName("Papuszka");
        receptionist2.setPesel("1456713124");

=======
        Receptionist receptionist = new Receptionist("receptionist","receptionist");
        receptionist.setFirstName("Krystyna");
        receptionist.setLastName("Czubówna");
        receptionist.setPesel("97123012345");
>>>>>>> 3402f6a6234c20c4184c8605986fa99b728879c6
        receptionistRepository.save(receptionist);
        receptionistRepository.save(receptionist2);
    }

    private List<Doctor> createDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        Doctor doctor = new Doctor("Dariusz","Dzieciol");
        Doctor doctor2 = new Doctor("Krzysztof","Krztusiec");

<<<<<<< HEAD
        doctor.setFirstName("Dariusz");
        doctor.setLastName("Dzieciol");
        doctor.setPesel("1234");

        doctor2.setFirstName("Krzysztof");
        doctor2.setLastName("Krztusiec");
        doctor2.setPesel("6789");
=======
        doctor.setFirstName("Krzysztof");
        doctor.setLastName("Zimek");
        doctor.setPesel("88021807693");

        doctor2.setFirstName("Andrzej");
        doctor2.setLastName("MAlinowski");
        doctor2.setPesel("83021807693");
>>>>>>> 3402f6a6234c20c4184c8605986fa99b728879c6

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);

        doctors.add(doctor);
        doctors.add(doctor2);
        return doctors;
    }
}
