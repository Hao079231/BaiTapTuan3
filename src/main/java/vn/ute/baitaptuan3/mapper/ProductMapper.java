package vn.ute.baitaptuan3.mapper;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import vn.ute.baitaptuan3.dto.ProductDto;
import vn.ute.baitaptuan3.form.ProductForm;
import vn.ute.baitaptuan3.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mappings({
      @Mapping(source = "productName", target = "name"),
      @Mapping(source = "productQuantity", target = "quantity"),
      @Mapping(source = "productIcon", target = "icon"),
      @Mapping(source = "categoryId", target = "category.id")
  })
  Product convertToProduct(ProductForm request);

  @Mappings({
      @Mapping(source = "name", target = "productName"),
      @Mapping(source = "quantity", target = "productQuantity"),
      @Mapping(source = "icon", target = "productIcon"),
      @Mapping(source = "category.id", target = "categoryId")
  })
  @Named("mapProductDto")
  ProductDto convertToProductResponse(Product product);

  @IterableMapping(qualifiedByName = "mapProductDto")
  List<ProductDto> convertToListProductResponse(List<Product> products);

  @Mappings({
      @Mapping(source = "productName", target = "name"),
      @Mapping(source = "productQuantity", target = "quantity"),
      @Mapping(source = "productIcon", target = "icon"),
      @Mapping(source = "categoryId", target = "category.id")
  })
  Product updateProduct(ProductForm request);
}

