package pl.mati.schronisko;

public class Animal {

    private String name;
    private String description;
    private String category;
    private String imgUrl;
    private int id;

    public Animal() {
    }

    public Animal(String name, String description, String category, String imgUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imgUrl = imgUrl;
//        this.id = id;
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

    public String getShortDescription() {
        if (description.length() < 100) {
            return description;
        } else
            return description.substring(0, 100);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
