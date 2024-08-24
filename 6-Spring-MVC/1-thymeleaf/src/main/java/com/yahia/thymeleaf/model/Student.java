package com.yahia.thymeleaf.model;

public class Student {

    private String firstNAme, lastName, country,language;

    public Student() {
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return STR."Student{firstNAme='\{firstNAme}\{'\''}, lastName='\{lastName}\{'\''}, country='\{country}\{'\''}, language='\{language}\{'\''}\{'}'}";
    }
}
