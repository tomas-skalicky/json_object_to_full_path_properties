package cz.skalicky.json.tofullpathproperties.model;

import java.math.BigDecimal;

public class CustomerOrder {

    private Integer id;

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
