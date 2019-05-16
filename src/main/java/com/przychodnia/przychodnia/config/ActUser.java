package com.przychodnia.przychodnia.config;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Entity.Receptionist;

public class ActUser {


    private static Doctor doctor;

    private static Patient patient;

    private static Receptionist receptionist;

    private static String userRole;


    public static Doctor getDoctor() {
        return doctor;
    }

    public static void setDoctor(Doctor doctor) {
        ActUser.doctor = doctor;
    }

    public static Patient getPatient() {
        return patient;
    }

    public static void setPatient(Patient patient) {
        ActUser.patient = patient;
    }

    public static Receptionist getReceptionist() {
        return receptionist;
    }

    public static void setReceptionist(Receptionist receptionist) {
        ActUser.receptionist = receptionist;
    }

    public static String getUserRole() {
        return userRole;
    }

    public static void setUserRole(String userRole) {
        ActUser.userRole = userRole;
    }
}


