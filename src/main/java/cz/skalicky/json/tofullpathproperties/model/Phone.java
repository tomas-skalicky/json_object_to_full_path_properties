package cz.skalicky.json.tofullpathproperties.model;

public class Phone {

    private String localNumber;

    private AreaCodeEnum areaCode;

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public AreaCodeEnum getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(AreaCodeEnum areaCode) {
        this.areaCode = areaCode;
    }

}
