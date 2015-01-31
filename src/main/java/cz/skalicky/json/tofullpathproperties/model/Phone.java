package cz.skalicky.json.tofullpathproperties.model;

import cz.skalicky.json.tofullpathproperties.German;

public class Phone {

    @German("lokaleNummer")
    private String localNumber;

    @German("vorwahl")
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
