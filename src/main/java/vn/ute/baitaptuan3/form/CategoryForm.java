package vn.ute.baitaptuan3.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm {
  @NotEmpty(message = "Tên của danh mục không thể trống")
  private String categoryName;

  @NotEmpty(message = "Hình ảnh không thể để trống")
  private String categoryIcon;
}
