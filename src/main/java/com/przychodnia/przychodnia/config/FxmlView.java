package com.przychodnia.przychodnia.config;

import java.util.ResourceBundle;

public enum FxmlView {

    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/Login.fxml";
        }
    },
    DOCTOR {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("doctor.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/Doctor.fxml";
        }
    },
    PATIENT {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("patient.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/Patient.fxml";
        }
    },
    RECEPTIONIST {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/Receptionist.fxml";
        }
    },
    USER_DATA {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("userdata.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/userData.fxml";
        }
    },
    PATIENT_LIST {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("patient.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/patientList.fxml";
        }
    },
    PATIENT_LIST_WITH_ADD_PATIENT {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/patientListWithAddPatient.fxml";
        }
    },
    WIZYTY {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("doctor.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/visits.fxml";
        }
    },
    RECEPTY {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("doctor.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/presciptions.fxml";
        }
    },
    DODAJ_RECEPTE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("doctor.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/addPresciption.fxml";
        }
    },
    LISTA_DOKTOROW {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/DoctorList.fxml";
        }
    },
    LISTA_RECEPSJONISTOW{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/ReceptionistList.fxml";
        }
    },
    LISTA_WIZYT_PANEL_RECEPSJONISTY{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/visitsReceptionistPanel.fxml";
        }
    },
    DODAJ_LEKARZA {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/AddDoctor.fxml";
        }
    },
    DODAJ_PACJENTA {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/AddPatient.fxml";
        }
    },
    DODAJ_RECEPSJONISTE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/AddReceptionist.fxml";
        }
    },
    DODAJ_WIZYTE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("receptionist.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/AddVisit.fxml";
        }
    }
    ,
    TREATMENT_HISTORY {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("patient.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/treatmentHistory.fxml";
        }
    },
    WIZYTY_PANEL_PACJENTA {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("patient.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/visitsPatientPanel.fxml";
        }
    },
    RECEPTY_PANEL_PACJENTA {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("patient.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/presciptionPatientPanel.fxml";
        }
    },
    REJESTRACJA {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/views/Registration.fxml";
        }
    }
    ;


    public abstract String getTitle();
    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}
