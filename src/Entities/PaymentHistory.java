package Entities;

import java.time.LocalDateTime;

public class PaymentHistory extends Base {

    private LocalDateTime date;
    private PaymentMethod paymentMethod;
    private double value;

    public PaymentHistory(LocalDateTime date, PaymentMethod paymentMethod, double value) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
