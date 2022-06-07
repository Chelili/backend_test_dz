package com.geekbrains.service;

import com.geekbrains.dto.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProductService {
    @POST("products")
    Call<Product> createProduct(@Body Product product);
    @PUT("products")
    Call<Product> modifyProduct(@Body Product product);
    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") int id);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);
    //@DELETE("products/{id}")
    // Call<ResponseBody> deleteProductPath(@Path("path") String path);
    //  @DELETE("products/{id}")
    //  Call<Delete> deleteProductTest(@Path("id") int id);
    @GET("products")
    Call<Product> getAllProduct();
}
