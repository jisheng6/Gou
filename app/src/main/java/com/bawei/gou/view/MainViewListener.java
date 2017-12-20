package com.bawei.gou.view;

import com.bawei.gou.bean.ShopBean;
/**
 * Created by Adminjs on 2017/12/19.
 */

public interface MainViewListener {
    public void success(ShopBean bean);
    public void failure(Exception e);
}
