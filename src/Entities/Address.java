package Entities;

public class Address {

    private String road;
    private String district; //neighborhood(bairro)
    private String city;
    private String state;
    private int number;
    private String complement;
    private String referencePoint;
    private String zipCode;

    public Address(String road, String district, String city, String state, int number, String complement, String referencePoint, String zipCode) {
        this.road = road;
        this.district = district;
        this.city = city;
        this.state = state;
        this.number = number;
        this.complement = complement;
        this.referencePoint = referencePoint;
        this.zipCode = zipCode;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
