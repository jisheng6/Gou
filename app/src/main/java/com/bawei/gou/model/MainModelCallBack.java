package com.bawei.gou.model;


import com.bawei.gou.bean.ShopBean;

/**
 * Created by Adminjs on 2017/12/19.
 */

public interface MainModelCallBack {

    public void success(ShopBean bean);
    public void failure(Exception e);
}
