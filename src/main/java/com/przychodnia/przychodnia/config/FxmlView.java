package com.przychodnia.przychodnia.config;

public enum FxmlView {

    LOGIN {
        @Override
        public String getTitle() {
            return "logowanie";
        }

        @Override
        public String getFxmlFile() {
            return "/views/Login.fxml";
        }
    };


    public abstract String getTitle();
    public abstract String getFxmlFile();
}
