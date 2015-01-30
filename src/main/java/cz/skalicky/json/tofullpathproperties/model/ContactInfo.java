package cz.skalicky.json.tofullpathproperties.model;

public class ContactInfo {

    private Phone privatePhone;

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
