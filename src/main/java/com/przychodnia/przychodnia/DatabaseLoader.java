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

        createPatientAndKartoteka("Pawel","Krzycz","12345678910", doctors.get(0));
        createPatientAndKartoteka("Angela","Waleczna","52623461454", doctors.get(0));
        createPatientAndKartoteka("Kamil","Stoch","42526262789", doctors.get(1));
    }

    private void createNews() {
        News news1 = new News("Badania","Badania dla uczniow szkol srednich\n" +
                "W celu wykonania badan dla uczniow szkol srednich w Przychodniach Medycyny Pracy CM MEDYK obowiazuje wczesniejsza rejestracja elektroniczna z co najmniej 5-dniowym wyprzedzeniem.");
        News news2 = new News("Zamkniecie placowki","informujemy, ze z dniem 1 kwietnia placowka Centrum Medycznego Medyk, znajdujaca sie przy ul. Baczynskiego 20A w Jasle zostaje zamknieta. Przepraszamy za wszelkie utrudnienia");
        News news3 = new News("Labolatorium","W tym tygodniu skrocone godziny pracy Laboratorium\n" +
                "Uprzejmie informujemy, ze laboratorium Centrum Medycznego Medyk przy ul. Szopena 1 w tym tygodniu czynne bedzie do godziny 16:00 ");
        ArrayList<News> news= new ArrayList<News>() {{
            add(news1);
            add(news2);
            add(news3);
        }};

        newsRepository.saveAll(news);
    }

    private void createPatientAndKartoteka(String firstName,String lastName, String pesel, Doctor doctor) {
        Patient patient = new Patient(firstName,lastName, doctor);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPesel(pesel);

        Kartoteka kartoteka = new Kartoteka();

        Wizyta wizyta1 = new Wizyta(LocalDateTime.now().plusDays(1),doctor);
        Wizyta wizyta2 = new Wizyta(LocalDateTime.now().plusDays(2),doctor);
        Wizyta wizyta3 = new Wizyta(LocalDateTime.now().minusDays(3),doctor);

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

        Receptionist receptionist = new Receptionist("Adam","Malysz");
        receptionist.setFirstName("Adam");
        receptionist.setLastName("Malysz");
        receptionist.setPesel("14567");

        Receptionist receptionist2 = new Receptionist("Agnieszka","Papuszka");
        receptionist2.setFirstName("Agnieszka");
        receptionist2.setLastName("Papuszka");
        receptionist2.setPesel("1456713124");

        Receptionist receptionist3 = new Receptionist("receptionist","receptionist");

        receptionist3.setFirstName("Krystyna");
        receptionist3.setLastName("Czubówna");
        receptionist3.setPesel("97123012345");


        receptionistRepository.save(receptionist);
        receptionistRepository.save(receptionist2);
    }

    private List<Doctor> createDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        Doctor doctor = new Doctor("Dariusz","Dzieciol");
        Doctor doctor2 = new Doctor("Krzysztof","Krztusiec");


        doctor.setFirstName("Dariusz");
        doctor.setLastName("Dzieciol");
        doctor.setPesel("83021807693");
        doctor.setSaturday(false);

        doctor2.setFirstName("Krzysztof");
        doctor2.setLastName("Krztusiec");
        doctor2.setPesel("83021807693");

        doctor.setFirstName("Krzysztof");
        doctor.setLastName("Pieta");
        doctor.setPesel("83021807693");


        doctor2.setFirstName("Andrzej");
        doctor2.setLastName("Malinowski");
        doctor2.setPesel("83021807693");

        doctor2.setFirstName("Adrian");
        doctor2.setLastName("Walet");
        doctor2.setPesel("83021807693");

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);

        doctors.add(doctor);
        doctors.add(doctor2);
        return doctors;
    }
}
