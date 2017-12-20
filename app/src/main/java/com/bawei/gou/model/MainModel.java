package com.bawei.gou.model;

import com.bawei.gou.bean.ShopBean;
import com.bawei.gou.okhttp.AbstractUiCallBack;
import com.bawei.gou.okhttp.OkhttpUtils;

/**
 * Created by Adminjs on 2017/12/19.
 */

public class MainModel {

    public void getData(final MainModelCallBack callBack) {
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=4729", new AbstractUiCallBack<ShopBean>() {


            @Override
            public void success(ShopBean bean) {
                callBack.success(bean);
            }

            @Override
            public void failure(Exception e) {
                callBack.failure(e);
            }
        });
    }

}
