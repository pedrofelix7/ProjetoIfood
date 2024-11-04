package Entities;

public class FollowUp {

    private Long idFollowUp;
    private String name;
    private String description;
    private double value;

    public FollowUp(Long idFollowUp, String name, String description, double value) {
        this.idFollowUp = idFollowUp;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Long getIdFollowUp() {
        return idFollowUp;
    }

    public void setIdFollowUp(Long idFollowUp) {
        this.idFollowUp = idFollowUp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
