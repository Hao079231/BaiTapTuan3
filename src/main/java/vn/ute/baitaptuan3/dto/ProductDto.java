package vn.ute.baitaptuan3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
  private String productName;
  private Integer productQuantity;
  private String productIcon;
  @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
  private Date productDateValue;
  private Long categoryId;
}
