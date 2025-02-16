package vn.ute.baitaptuan3.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.ute.baitaptuan3.dto.ApiMessageDto;
import vn.ute.baitaptuan3.dto.CategoryDto;
import vn.ute.baitaptuan3.form.CategoryForm;
import vn.ute.baitaptuan3.service.CategoryService;
import vn.ute.baitaptuan3.utils.ApiResponseUtils;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @PostMapping("/create")
  public ResponseEntity<ApiMessageDto<CategoryDto>> createCategory(@Valid @RequestBody CategoryForm request){
    ApiMessageDto<CategoryDto> response = ApiResponseUtils.responses("Thêm sản phẩm thành công",
        categoryService.createCategory(request));
    return ResponseEntity.ok(response);
  }

  @GetMapping("/list")
  public ResponseEntity<ApiMessageDto<List<CategoryDto>>> getListCategory(CategoryForm request){
    ApiMessageDto<List<CategoryDto>> response = ApiResponseUtils.responses("Danh sách danh mục",
        categoryService.getListCategory(request));
    return ResponseEntity.ok(response);
  }
}
