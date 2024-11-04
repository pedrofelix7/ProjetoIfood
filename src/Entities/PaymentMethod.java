package Entities;

public class PaymentMethod {

    private Long idPaymentMethod;
    private String paymentType;

    public PaymentMethod(Long idPaymentMethod, String paymentType) {
        this.idPaymentMethod = idPaymentMethod;
        this.paymentType = paymentType;
    }

    public Long getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(Long idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
