package com.example.day8homework.presenter;

import com.example.day8homework.base.BasePresenter;
import com.example.day8homework.bean.TeachersBean;
import com.example.day8homework.callback.TeacherCallback;
import com.example.day8homework.model.TeacherModel;
import com.example.day8homework.view.TeacherView;

public class TeacherPresenter extends BasePresenter<TeacherView> implements TeacherCallback {
    private TeacherModel teacherModel;

    @Override
    protected void initModel() {
        teacherModel = new TeacherModel();
        addModel(teacherModel);
    }

    public void getData() {
        teacherModel.getData(this);
    }

    @Override
    public void onSuccess(TeachersBean teachersBean) {
        mView.setData(teachersBean);
    }

    @Override
    public void onFail(String error) {
        mView.showToast(error);
    }
}
