package vn.ute.baitaptuan3.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
  @NotEmpty(message = "Tên sản phẩm không thể trống")
  private String productName;

  @NotNull(message = "Số lượng sản phẩm không thể trống")
  private Integer productQuantity;

  @NotEmpty(message = "Hình ảnh sản phẩm không thể trống")
  private String productIcon;

  @NotNull(message = "Phải tham chiếu đến danh mục tương ứng")
  private Long categoryId;
}
