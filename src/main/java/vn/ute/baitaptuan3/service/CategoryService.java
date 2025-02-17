package vn.ute.baitaptuan3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.ute.baitaptuan3.dto.CategoryDto;
import vn.ute.baitaptuan3.exception.DuplicateEntityException;
import vn.ute.baitaptuan3.form.CategoryForm;
import vn.ute.baitaptuan3.mapper.CategoryMapper;
import vn.ute.baitaptuan3.model.Category;
import vn.ute.baitaptuan3.repository.CategoryRepository;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private CategoryMapper categoryMapper;

  public CategoryDto createCategory(CategoryForm request){
    if (categoryRepository.findByName(request.getCategoryName()).isPresent()) {
      throw new DuplicateEntityException("Tên danh mục đã tồn tại");
    }

    Category category = categoryMapper.convertToCategory(request);
    return categoryMapper.convertToCategoryResponse(categoryRepository.save(category));
  }

  public List<CategoryDto> getListCategory(CategoryForm request) {
    List<Category> categories = categoryRepository.findAll();
    return categoryMapper.convertToListCategoryResponse(categories);
  }
}
