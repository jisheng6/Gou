package com.bawei.gou;

/**
 * Created by Adminjs on 2017/12/20.
 */

public class MainPresenter {
    private MaView view;
    private MainModelImpl model;
    public MainPresenter(MaView view) {
        this.view = view;
        this.model = new MainModelImpl();
    }

    public void get(){
        model.getData(new MainModelImpl.ModelCallBack() {
            @Override
            public void success(ShopBean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
    public void detach(){
        view = null;
    }
}
