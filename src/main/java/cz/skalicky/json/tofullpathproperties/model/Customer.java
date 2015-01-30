package cz.skalicky.json.tofullpathproperties.model;

import java.util.List;

public class Customer extends Person {

    private Integer customerId;

    private List<CustomerOrder> orders;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

}
