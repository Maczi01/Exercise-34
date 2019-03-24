package pl.mati.schronisko;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    List<String> categoriesList = new ArrayList<>();

    public CategoryRepository() {
        categoriesList.add("pies");
        categoriesList.add("kot");
        categoriesList.add("dzik");
    }

    public List<String>findAll(){
        return categoriesList;
    }

}
