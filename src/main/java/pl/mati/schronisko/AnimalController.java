package pl.mati.schronisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnimalController {

    private AnimalRepository animalRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository, CategoryRepository categoryRepository) {
        this.animalRepository = animalRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<Animal> animalRepositoryAll = animalRepository.findAll();
        model.addAttribute("animalsList", animalRepositoryAll);
        List<String> categoriesRepositoryAll = categoryRepository.findAll();
        model.addAttribute("categoryRepository", categoriesRepositoryAll);
        return "stronaGlowna";
    }

    @GetMapping("/szczegoly")
    public String details(@RequestParam String name, Model model) {
        Animal animalRepositoryByName = animalRepository.findByName(name);
        List<Animal> animalRepositoryAll = animalRepository.findAll();
        List<String> categoriesRepositoryAll = categoryRepository.findAll();
        model.addAttribute("categoryRepository", categoriesRepositoryAll);
        model.addAttribute("animalsList", animalRepositoryAll);
        model.addAttribute("nameAnimal", animalRepositoryByName);
        return "szczegoly";
    }


    @GetMapping("/zwierzaki")
    public String byCategry(@RequestParam String categoryName, Model model) {
        List<Animal> animalRepositoryByCategory = animalRepository.findByCategory(categoryName);
        model.addAttribute("animalsByCategory", animalRepositoryByCategory);
        List<String> categoriesRepositoryAll = categoryRepository.findAll();
        model.addAttribute("categoryRepository", categoriesRepositoryAll);
        return "zwierzakiPoKategorii";
    }


    @GetMapping("/dodaj")
    public String showForm(Model model) {
        model.addAttribute("animal", new Animal());
        List<String> categoriesRepositoryAll = categoryRepository.findAll();
        model.addAttribute("categoryList", categoriesRepositoryAll);
        return "dodajZwierzaka";
    }


    @PostMapping("/dodajZwierzaka")
    public String saveAnimal(Animal animal) {
        animalRepository.adding(animal);
        return "zwierzakDodany";
    }

//    edycja

    @GetMapping("/edytuj")
    public String getAnimal(Model model, String name) {
        Animal animal = animalRepository.findByName(name);
        List<String> categoriesRepositoryAll = categoryRepository.findAll();
        model.addAttribute("categoryList", categoriesRepositoryAll);
        model.addAttribute("animal", animal);
        return "edytujZwierzaka";
    }

    @PostMapping("/edytujZwierzaka")
    public String editZwierzak(Animal animal) {
        animalRepository.update(animal);
        return "zwierzakZaktualizowany";
    }




}
