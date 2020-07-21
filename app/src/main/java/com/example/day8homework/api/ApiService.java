package com.example.day8homework.api;

import com.example.day8homework.bean.InfoBean;
import com.example.day8homework.bean.TeachersBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //
    String baseUrlTeacher = "https://api.yunxuekeji.cn/yunxue_app_api/";

    @GET("content/getData/30/66597/1/10")
    Observable<TeachersBean> getData();

    @GET("teacher/getTeacherPower/{id}")
    Observable<InfoBean> getInfoData(@Path("id") int id);
}
