package com.example.day8homework.model;

import com.example.day8homework.api.ApiService;
import com.example.day8homework.base.BaseModel;
import com.example.day8homework.bean.TeachersBean;
import com.example.day8homework.callback.TeacherCallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeacherModel extends BaseModel {
    public void getData(TeacherCallback teacherCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseUrlTeacher)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<TeachersBean> observable = apiService.getData();
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TeachersBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(TeachersBean teachersBean) {
                        teacherCallback.onSuccess(teachersBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        teacherCallback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
