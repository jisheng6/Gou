package com.bawei.gou.presenter;

import com.bawei.gou.bean.ShopBean;
import com.bawei.gou.model.MainModel;
import com.bawei.gou.model.MainModelCallBack;
import com.bawei.gou.view.MainViewListener;

/**
 * Created by Adminjs on 2017/12/19.
 */

public class MainPresente {
    private MainViewListener listener;
    private MainModel mainModel;

    public MainPresente(MainViewListener listener) {
        this.listener = listener;
        this.mainModel = new MainModel();
    }

    public void getData(){
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void success(ShopBean bean) {
                if (listener != null){
                    listener.success(bean);
                }
            }

            @Override
            public void failure(Exception e) {
                if (listener != null){
                    listener.failure(e);
                }
            }
        });
    }
    public void detach(){
        listener = null;
    }
}
