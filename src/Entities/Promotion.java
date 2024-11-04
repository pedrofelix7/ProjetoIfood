package Entities;

import java.util.Date;

public class Promotion {

    private Long idPromotion;
    private String name;
    private String code;
    private String type;
    private double value;
    private Date validity;

    public Promotion(Long idPromotion, String name, String code, String type, double value, Date validity) {
        this.idPromotion = idPromotion;
        this.name = name;
        this.code = code;
        this.type = type;
        this.value = value;
        this.validity = validity;
    }

    public Long getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Long idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }
}
