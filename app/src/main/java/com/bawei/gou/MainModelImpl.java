package com.bawei.gou;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/20.
 */
//http://120.27.23.105/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1

public class MainModelImpl {
    public void getData(final ModelCallBack callBack){
       /* Map<String,String> map = new HashMap<>();
        map.put("keywords","%E7%AC%94%E8%AE%B0%E6%9C%AC");
        map.put("page","1");*/
        MyApp.inters.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean bean) throws Exception {
                       callBack.success(bean);
                    }
                });
    }

    public interface ModelCallBack {
        public void success(ShopBean bean);
    }
}
