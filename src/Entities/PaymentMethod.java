package Entities;

public class PaymentMethod extends Base {

    private String paymentType1;
    private String paymentType2;
    private String paymentType3;
    private String paymentType4;

    public PaymentMethod(String paymentType1, String paymentType2, String paymentType3, String paymentType4) {
        this.paymentType1 = paymentType1;
        this.paymentType2 = paymentType2;
        this.paymentType3 = paymentType3;
        this.paymentType4 = paymentType4;
    }


    public void setPaymentType1(String paymentType1) {
        this.paymentType1 = paymentType1;
    }

    public void setPaymentType2(String paymentType2) {
        this.paymentType2 = paymentType2;
    }

    public void setPaymentType3(String paymentType3) {
        this.paymentType3 = paymentType3;
    }

    public void setPaymentType4(String paymentType4) {
        this.paymentType4 = paymentType4;
    }

    public String getPaymentType1() {
        return paymentType1;
    }

    public String getPaymentType2() {
        return paymentType2;
    }

    public String getPaymentType3() {
        return paymentType3;
    }

    public String getPaymentType4() {
        return paymentType4;
    }
}
