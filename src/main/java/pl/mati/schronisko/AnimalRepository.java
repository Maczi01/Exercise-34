package pl.mati.schronisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class AnimalRepository {

    List<Animal> animalsList = new ArrayList<>();
    private int id;

//    Category pies = new Category("pies");

    public AnimalRepository() {
//        animalsList.add(new Animal("Burek", "blablabla", "pies", "https://media.istockphoto.com/photos/badger-dog-picture-id147694372?k=6&m=147694372&s=612x612&w=0&h=6BCop_325VfqkHJAmwt_7Gw8_kjzoKM3IC_ZZQ4QsQI="));
//        animalsList.add(new Animal("Borys", "blablabla", "pies", "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwio57nN747hAhUGw8QBHWXQC2UQjRx6BAgBEAU&url=https%3A%2F%2Fwww.dogster.com%2Fdog-health-care%2Fdog-bite-treatments-for-different-dog-bite-situations&psig=AOvVaw242Bh5coKmUPYNM0a3Si2Z&ust=1553107672820624"));
//        animalsList.add(new Animal("Atos", "hau hau", "pies", "https://image.ceneostatic.pl/data/products/28780779/i-collecta-zwierzeta-dzikie-wilk-szary-wyjacy-88341.jpg"));
//        animalsList.add(new Animal("Kira", "miaua", "kot", "https://upload.wikimedia.org/wikipedia/commons/9/9c/Rohrkatze-6218.jpg"));
//        animalsList.add(new Animal("Bonifacy", "miau", "kot", "http://www.drapiezniki.pl/Photos/zbik.jpg"));
    }

    public void adding(Animal animal) {
//        int index  =
        animal.setId(id);
        animalsList.add(animal);
        id++;
    }

    public List<Animal> findAll() {
        return animalsList;
    }

    public Animal findByName(String name) {
        for (Animal animal : animalsList) {
            if (name.equals(animal.getName()))
                return animal;
        }
        return null;
    }

    public List<Animal> findByCategory(String category) {
        List<Animal> animalListByCategory = new ArrayList<>();
        for (Animal animal : animalsList) {
            if (category.equals("")) {
                return animalsList;
            }
            if (category.equals(animal.getCategory()))
                animalListByCategory.add(animal);
        }
        return animalListByCategory;
    }

    public List<Animal> getAnimalsList() {
        return animalsList;
    }

//    public List<Animal> getAnimalByCategory(List<Animal> list, String  nameOfCategory) {
//        List<Animal> animalListByCategory = new ArrayList<>();
//        for (Animal a : list) {
//            if (a.getCategory().equals(nameOfCategory)) {
//                animalListByCategory.add(a);
//            }
//        }
//        return animalListByCategory;
//    }

    public String createShortDescription(String description) {
        String substring;
        if (description.length() < 100) {
            return description;
        } else
            substring = description.substring(0, 100);
        return substring;
    }

    public void update(Animal animal) {
        int index = animal.getId();
        for (int i = 0; i < animalsList.size(); i++) {
            if (animalsList.get(i).getId() == index) {
                animalsList.set(index, animal);
                break;
            }
        }
    }

//    public List<Animal> findByCategory(Category category) {
//        Category category1;
//        return animalsList.stream()
//                .filter(animal -> category1.getName().equals(animal.getCategory().getName()))
//                .collect(toList());
//    }


}
