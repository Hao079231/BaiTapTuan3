package vn.ute.baitaptuan3.dto;

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
  private Long categoryId;
}
