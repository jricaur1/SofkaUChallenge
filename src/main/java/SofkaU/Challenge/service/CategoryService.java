package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listAllCategory();
    public Category getCategory(Long id);

    public Category createCategory(Category category);
}
