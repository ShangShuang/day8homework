package com.example.day8homework.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> models = new ArrayList<>();

    //初始化model
    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel model) {
        models.add(model);
    }

    //绑定view
    public void bindView(V view) {
        this.mView = view;
    }

    //销毁
    public void destroy() {
        mView = null;
        for (int i = 0; i < models.size(); i++) {
            BaseModel baseModel = models.get(i);
            baseModel.destroy();
        }

    }
}
