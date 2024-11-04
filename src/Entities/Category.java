package Entities;

public class Category {

    private Long idCategory;
    private String type;
    private String name;
    private String description;

    public Category(Long idCategory, String type, String name, String description) {
        this.idCategory = idCategory;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
