package com.przychodnia.przychodnia.PersonTableView;

import javafx.beans.property.SimpleStringProperty;

public class PersonTableView {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty pesel;

    public PersonTableView(String fName, String lName, String pesel) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.pesel = new SimpleStringProperty(pesel);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public String getPesel() {
        return pesel.get();
    }

    public void setPesel(String fName) {
        pesel.set(fName);
    }
}

