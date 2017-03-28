package com.minorius.server;

import com.minorius.entity.Category;
import com.minorius.entity.Product;
import com.minorius.service.CategoryService;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by minorius on 21.03.2017.
 */
public class Sender {

    private static ArrayList<CategorySerializable> categorySerializableArrayList = new ArrayList<>();

    public static void sendData(Socket socket, CategoryService categoryService){

        ArrayList<Category> categoryArrayList = categoryService.getAllCategory();

        for (Category category : categoryArrayList){
            getBundle(category);
        }

        try{
            ObjectOutputStream p = new ObjectOutputStream(socket.getOutputStream());
            p.writeObject(categorySerializableArrayList);
            p.flush();
            p.close();
            System.out.println("Data sent");
            socket.close();

            categorySerializableArrayList.clear();
            categoryArrayList.clear();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static CategorySerializable getBundle(Category loadedCategory){

        CategorySerializable categorySerializable = new CategorySerializable();

        categorySerializable.setId(loadedCategory.getId());
        categorySerializable.setName(loadedCategory.getName());
        categorySerializable.setVersion(loadedCategory.getVersion());

        List<Product> productListFromDb = loadedCategory.getProductList();
        List<ProductSerializable> listOfSerializableProduct = null;

        if (productListFromDb.size() > 0){

            listOfSerializableProduct = new ArrayList<>();

            for (Product productFromDb : productListFromDb){
                ProductSerializable productSerializable = new ProductSerializable();

                productSerializable.setId(productFromDb.getId());
                productSerializable.setType(productFromDb.getType());
                productSerializable.setTitle(productFromDb.getTitle());
                productSerializable.setPrice(productFromDb.getPrice());
                productSerializable.setOrder_count(productFromDb.getOrder_count());
                productSerializable.setOrder_needed(productFromDb.getOrder_needed());
                productSerializable.setImage(productFromDb.getImage());
                productSerializable.setDescription_short(productFromDb.getDescription_short());
                productSerializable.setDescription_full(productFromDb.getDescription_full());
                productSerializable.setRating(productFromDb.getRating());
                productSerializable.setIs_actual(productFromDb.isIs_actual());
                listOfSerializableProduct.add(productSerializable);
            }
        }

        if (listOfSerializableProduct != null){
            categorySerializable.setProductList(listOfSerializableProduct);
        }
        categorySerializableArrayList.add(categorySerializable);
        return categorySerializable;
    }
}
