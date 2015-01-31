package cz.skalicky.json.tofullpathproperties.model;

import cz.skalicky.json.tofullpathproperties.German;

public class ContactInfo {

    @SuppressWarnings("unused")
    private static final String SHOULD_NOT_BE_PROCESSED = "BANANA";

    @German("privateTelefonNummer")
    private Phone privatePhone;

    @German("geschäftlicheTelefonNummer")
    private Phone businessPhone;

    public Phone getPrivatePhone() {
        return privatePhone;
    }

    public void setPrivatePhone(Phone privatePhone) {
        this.privatePhone = privatePhone;
    }

    public Phone getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(Phone businessPhone) {
        this.businessPhone = businessPhone;
    }

}
