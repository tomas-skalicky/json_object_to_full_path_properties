package cz.skalicky.json.tofullpathproperties.model;

public enum AreaCodeEnum {

    // @formatter:off
    CZECH_REPUBLIC  (1, "+490"),
    GERMANY         (2, "+49"),
    SLOVAKEI        (3, "+491");
    // @formatter:on

    private final int id;
    private final String areaCode;

    private AreaCodeEnum(final int id, final String areaCode) {
        this.id = id;
        this.areaCode = areaCode;
    }

    public int getId() {
        return id;
    }

    public String getAreaCode() {
        return areaCode;
    }

}
