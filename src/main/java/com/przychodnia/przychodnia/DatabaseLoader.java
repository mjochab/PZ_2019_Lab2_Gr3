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
        createPatientAndKartoteka("Kamil","Stoch","42526262789", doctors.get(0));
        createPatientAndKartoteka("Wiktoria","Lukasik","12345678910", doctors.get(0));
        createPatientAndKartoteka("Aleksandra ","Maciejewska","52623461454", doctors.get(0));
        createPatientAndKartoteka("Weronika","Piotrowska","42526262789", doctors.get(0));
        createPatientAndKartoteka("Sebastian","Lesniak","12345678910", doctors.get(0));
        createPatientAndKartoteka("Bartek","Leszczynski","52623461454", doctors.get(0));
        createPatientAndKartoteka("Amelia","Nowakowska","42526262789", doctors.get(0));
        createPatientAndKartoteka("Ewa","Nowakowska","12345678910", doctors.get(0));
        createPatientAndKartoteka("Szymon","Sikora","52623461454", doctors.get(0));
        createPatientAndKartoteka("Malgorzata","Marcinkowska","42526262789", doctors.get(0));

        createPatientAndKartoteka("Helena","Wojciechowska","12345678910", doctors.get(1));
        createPatientAndKartoteka("Karol","Gajda","52623461454", doctors.get(1));
        createPatientAndKartoteka("Alicja","Sawicka","42526262789", doctors.get(1));
        createPatientAndKartoteka("Bartek","Nowicki","12345678910", doctors.get(1));
        createPatientAndKartoteka("Pawel","Lisowski","52623461454", doctors.get(1));
        createPatientAndKartoteka("Jakub","Janik","42526262789", doctors.get(1));

        createPatientAndKartoteka("Mateusz","Stankiewicz","12345678910", doctors.get(2));
        createPatientAndKartoteka("Mateusz","Owczarek","52623461454", doctors.get(2));
        createPatientAndKartoteka("Kamil","Bednarek","42526262789", doctors.get(2));

        createPatientAndKartoteka("Helena","Zawadzka","12345678910", doctors.get(3));
        createPatientAndKartoteka("Michal","Stefaniak","52623461454", doctors.get(3));
        createPatientAndKartoteka("Maciej","Rybak","42526262789", doctors.get(3));

        createPatientAndKartoteka("Piotr","Konieczny","12345678910", doctors.get(4));
        createPatientAndKartoteka("Martyna","Sikora","52623461454", doctors.get(4));
        createPatientAndKartoteka("Pawel","Krawczyk","42526262789", doctors.get(4));

        createPatientAndKartoteka("Cecylia","Wieczorek","12345678910", doctors.get(5));
        createPatientAndKartoteka("Oliwier","Grzelak","52623461454", doctors.get(5));
        createPatientAndKartoteka("Wiktor","Kalinowski","42526262789", doctors.get(5));



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



        presciption.setDescription("zapalenie pluc");
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

        Receptionist receptionist4 = new Receptionist("receptionist","receptionist");
        receptionist4.setFirstName("Kacper");
        receptionist4.setLastName("Nowak");
        receptionist4.setPesel("97123573145");

        Receptionist receptionist5 = new Receptionist("receptionist","receptionist");
        receptionist5.setFirstName("Maja");
        receptionist5.setLastName("Krajewska");
        receptionist5.setPesel("14252012345");

        Receptionist receptionist6 = new Receptionist("receptionist","receptionist");
        receptionist6.setFirstName("Katarzyna");
        receptionist6.setLastName("Marciniak");
        receptionist6.setPesel("97123015835");

        Receptionist receptionist7 = new Receptionist("receptionist","receptionist");
        receptionist7.setFirstName("Maciej");
        receptionist7.setLastName("Wilk");
        receptionist7.setPesel("91368422345");

        Receptionist receptionist8 = new Receptionist("receptionist","receptionist");
        receptionist8.setFirstName("Ignacy");
        receptionist8.setLastName("Piasecki");
        receptionist8.setPesel("97123035731");


        receptionistRepository.save(receptionist);
        receptionistRepository.save(receptionist2);
        receptionistRepository.save(receptionist3);
        receptionistRepository.save(receptionist4);
        receptionistRepository.save(receptionist5);
        receptionistRepository.save(receptionist6);
        receptionistRepository.save(receptionist7);
        receptionistRepository.save(receptionist8);
    }

    private List<Doctor> createDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        Doctor doctor = new Doctor("Dariusz","Dzieciol");
        Doctor doctor2 = new Doctor("Krzysztof","Krztusiec");
        Doctor doctor3 = new Doctor("Wiktoria","Mazur");
        Doctor doctor4 = new Doctor("Zofia","Makowska");
        Doctor doctor5 = new Doctor("Patrycka","Nowak");
        Doctor doctor6 = new Doctor("Andrzej","Nowak");

        doctor.setFirstName("Dariusz");
        doctor.setLastName("Dzieciol");
        doctor.setPesel("83021807693");
        doctor.setSaturday(false);

        doctor2.setFirstName("Krzysztof");
        doctor2.setLastName("Krztusiec");
        doctor2.setPesel("83021807693");

        doctor3.setFirstName("Wiktoria");
        doctor3.setLastName("Mazur");
        doctor3.setPesel("83021807693");

        doctor4.setFirstName("Zofia");
        doctor4.setLastName("Makowska");
        doctor4.setPesel("83021807693");

        doctor5.setFirstName("Patrycka");
        doctor5.setLastName("Nowak");
        doctor5.setPesel("83021807693");

        doctor6.setFirstName("Andrzej");
        doctor6.setLastName("Nowak");
        doctor6.setPesel("83021807693");

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);
        doctorRepository.save(doctor4);
        doctorRepository.save(doctor5);
        doctorRepository.save(doctor6);

        doctors.add(doctor);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
        doctors.add(doctor5);
        doctors.add(doctor6);
        return doctors;
    }
}
