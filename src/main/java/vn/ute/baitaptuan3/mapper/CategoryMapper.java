package vn.ute.baitaptuan3.mapper;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import vn.ute.baitaptuan3.dto.CategoryDto;
import vn.ute.baitaptuan3.form.CategoryForm;
import vn.ute.baitaptuan3.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mappings({
      @Mapping(source = "categoryName", target = "name"),
      @Mapping(source = "categoryIcon", target = "icon")
  })
  Category convertToCategory(CategoryForm request);

  @Mappings({
      @Mapping(source = "name", target = "categoryName"),
      @Mapping(source = "icon", target = "categoryIcon")
  })
  @Named("mapCategoryDto")
  CategoryDto convertToCategoryResponse(Category category);

  @IterableMapping(qualifiedByName = "mapCategoryDto")
  List<CategoryDto> convertToListCategoryResponse(List<Category> categories);

  @Mappings({
      @Mapping(source = "categoryName", target = "name"),
      @Mapping(source = "categoryIcon", target = "icon")
  })
  Category updateCategory(CategoryForm request);
}
