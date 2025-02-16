package vn.ute.baitaptuan3.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.ute.baitaptuan3.dto.ProductDto;
import vn.ute.baitaptuan3.exception.DuplicateEntityException;
import vn.ute.baitaptuan3.exception.ResourceNotFound;
import vn.ute.baitaptuan3.form.ProductForm;
import vn.ute.baitaptuan3.mapper.ProductMapper;
import vn.ute.baitaptuan3.model.Category;
import vn.ute.baitaptuan3.model.Product;
import vn.ute.baitaptuan3.repository.CategoryRepository;
import vn.ute.baitaptuan3.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductMapper productMapper;

  @Autowired
  private CategoryRepository categoryRepository;

  // Thêm sản phẩm vào database
  public ProductDto createProduct(ProductForm request) {
    if (productRepository.findByName(request.getProductName()).isPresent()) {
      throw new DuplicateEntityException("Sản phẩm đã tồn tại");
    }

    // Kiểm tra sự tồn tại của Category trước khi thêm Product
    Category category = categoryRepository.findById(request.getCategoryId())
        .orElseThrow(() -> new ResourceNotFound("Danh mục không tồn tại"));

    Product product = productMapper.convertToProduct(request);
    product.setIcon(request.getProductIcon() != null ? request.getProductIcon() : "Image Empty");
    product.setCategory(category);

    return productMapper.convertToProductResponse(productRepository.save(product));
  }

  // Hiển thị sản phẩm theo từng danh mục
  public List<ProductDto> getProductByCategoryId(Long categoryId) {
    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFound("Danh mục không tồn tại"));

    List<Product> products = productRepository.findByCategoryId(categoryId);
    if (products.isEmpty()) {
      throw new ResourceNotFound("Không tìm thấy sản phẩm thuộc danh mục đã chọn");
    }
    return productMapper.convertToListProductResponse(products);
  }

  // Hiển thị danh sách sản phẩm có số lượng nhiều nhất
  public List<ProductDto> getProductsWithHighestQuantity(){
    List<Product> products = productRepository.findAll(
        PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "quantity"))).getContent();
    return productMapper.convertToListProductResponse(products);
  }

  // Hiển thị tất cả sản phẩm mới được sản xuất nhỏ hơn hoặc bằng 7 ngày
  public List<ProductDto> getRecentProducts(){
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, -7);
    Date sevenDaysAgo = calendar.getTime();

    List<Product> products = productRepository.findByProductDateAfter(sevenDaysAgo);
    return productMapper.convertToListProductResponse(products);
  }
}
