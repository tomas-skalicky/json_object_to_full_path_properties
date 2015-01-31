package cz.skalicky.json.tofullpathproperties.model;

import cz.skalicky.json.tofullpathproperties.German;

public class Person {

    @German("vorname")
    private String firstName;

    @German("nachname")
    private String lastName;

    @German("kontaktInformationen")
    private ContactInfo contactInfo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

}
