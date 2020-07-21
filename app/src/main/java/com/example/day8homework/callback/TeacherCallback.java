package com.example.day8homework.callback;

import com.example.day8homework.bean.TeachersBean;

public interface TeacherCallback {
    void onSuccess(TeachersBean teachersBean);

    void onFail(String error);
}
