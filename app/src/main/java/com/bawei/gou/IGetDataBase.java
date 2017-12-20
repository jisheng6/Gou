package com.bawei.gou;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Adminjs on 2017/12/20.
 */

public interface IGetDataBase {
   // http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1
    //http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1
    @GET("/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1")
    Observable<ShopBean> get();
}
