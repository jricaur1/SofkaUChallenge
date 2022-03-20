package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.Category;
import SofkaU.Challenge.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    public List<Category> createCategories(){
        List<Category> categories = new ArrayList<>();
        for (int i = 1; i <= 2; i++){
            categories.add(Category.builder()
                    .multiplier(i)
                    .build());
        }
        for (Category category: categories){
            categoryService.createCategory(category);
        }
        return categories;
    }

    public List<Category> getCategories(){
        return categoryService.listAllCategory();
    }
}
