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
    };




    public abstract String getTitle();
    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}
