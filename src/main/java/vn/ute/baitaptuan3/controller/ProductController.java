package vn.ute.baitaptuan3.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.ute.baitaptuan3.dto.ApiMessageDto;
import vn.ute.baitaptuan3.dto.ProductDto;
import vn.ute.baitaptuan3.form.ProductForm;
import vn.ute.baitaptuan3.service.ProductService;
import vn.ute.baitaptuan3.utils.ApiResponseUtils;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping("/create")
  public ResponseEntity<ApiMessageDto<ProductDto>> createProduct(@Valid @RequestBody ProductForm request){
    ApiMessageDto<ProductDto> response = ApiResponseUtils.responses("Thêm sản phẩm thành công",
        productService.createProduct(request));
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{categoryId}/list")
  public ResponseEntity<ApiMessageDto<List<ProductDto>>> getListProductByCategory(@PathVariable Long categoryId){
    ApiMessageDto<List<ProductDto>> response = ApiResponseUtils.responses("Danh sách sản phẩm theo từng danh mục",
        productService.getProductByCategoryId(categoryId));
    return ResponseEntity.ok(response);
  }

  @GetMapping("/top-10-by-quantity")
  public ResponseEntity<ApiMessageDto<List<ProductDto>>> getProductsWithHighestQuantity(){
    ApiMessageDto<List<ProductDto>> response = ApiResponseUtils.responses("Danh sách 10 sản phẩm có số lượng bán nhiều nhất",
        productService.getProductsWithHighestQuantity());
    return ResponseEntity.ok(response);
  }

  @GetMapping("/recently-produced")
  public ResponseEntity<ApiMessageDto<List<ProductDto>>> getRecentProducts() {
    ApiMessageDto<List<ProductDto>> response = ApiResponseUtils.responses(
        "Danh sách sản phẩm mới được sản xuất từ 7 ngày trở xuống",
        productService.getRecentProducts());
    return ResponseEntity.ok(response);
  }
}
