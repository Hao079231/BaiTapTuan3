package vn.ute.baitaptuan3.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;
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

  @Past(message = "Ngày sản xuất phải là ngày trong quá khứ")
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate productDateValue;

  @NotNull(message = "Phải tham chiếu đến danh mục tương ứng")
  private Long categoryId;
}
