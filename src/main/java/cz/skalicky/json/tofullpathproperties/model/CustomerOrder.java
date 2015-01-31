package cz.skalicky.json.tofullpathproperties.model;

import java.math.BigDecimal;

import cz.skalicky.json.tofullpathproperties.German;

public class CustomerOrder {

    @German("id")
    private Integer id;

    @German("preis")
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
