package com.minorius;

import com.minorius.entity.Category;
import com.minorius.entity.Product;
import com.minorius.server.PortListener;
import com.minorius.service.CategoryService;
import com.minorius.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GhHibernateApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GhHibernateApplication.class, args);
		CategoryService categoryService = context.getBean(CategoryService.class);
		ProductService productService = context.getBean(ProductService.class);

		//------ String type
		//------ String title
		//------ int price
		//------ int order_count
		//------ int order_needed
		//------ String image
		//------ String description_short
		//------ String description_full
		//------ byte rating
		//------ boolean is_actual

		//------ add category && product
//		List<Product> productList = new ArrayList<>();
//		productList.add(new Product("Sedan", "Reno", 210000, 10, 8,"path to img","description_short", "description_full", (byte)32, true));
//		Category category = new Category("NewCar" , 1 , productList);
//		categoryService.saveCategory(category);




		//------ add product by category
//		Product product = new Product();
//		product.setType("new type");
//		productService.addProductByCategory(product, "Table");




		//------ get all category
//		ArrayList<Category> loadedCategory = categoryService.getAllCategory();
//		for (Category category : loadedCategory){
//			System.out.println(category.getName());
//		}



		//----- get category by id
//		System.out.println(categoryService.getCategoryById(1).getName());




		//----- get all data by category
//		List dataListByCategory = productService.getAllProductByCategory("Car");
//
//		for (Object o : dataListByCategory){
//			Category category = (Category) o;
//
//			System.out.println(category.getId());
//			System.out.println(category.getName());
//			System.out.println(category.getProductList());
//			System.out.println(category.getVersion());
//		}

		PortListener.portListenerOn(categoryService);

	}
}
