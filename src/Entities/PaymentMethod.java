package Entities;

import java.util.List;

public class PaymentMethod extends Base {

    private long id;
    private String paymentType1;


    public PaymentMethod() {
        this.id = id;
        this.paymentType1 = paymentType1;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPaymentType1(String paymentType1) {
        this.paymentType1 = paymentType1;
    }

    public String getPaymentType1() {
        return paymentType1;
    }

}
