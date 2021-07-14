package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartingWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);


    List<Product> getByProductNameOrCategory(String productName, int categoryId);

    @Query("Select new kodlama.io.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p ")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

    @Query("From Product where id=:productId")
    Product getByProductId(int productId);

}
