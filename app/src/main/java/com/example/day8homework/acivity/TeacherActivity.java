package com.example.day8homework.acivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.day8homework.R;
import com.example.day8homework.adapter.TvfAdapter;
import com.example.day8homework.api.ApiService;
import com.example.day8homework.bean.InfoBean;
import com.example.day8homework.bean.TeachersBean;
import com.example.day8homework.fragment.ClassFragment;
import com.example.day8homework.fragment.ContentFragment;
import com.example.day8homework.fragment.ZhuanTiFragment;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeacherActivity extends AppCompatActivity {

    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_TeacherName)
    TextView tvTeacherName;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_sure)
    Button btnSure;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private TeachersBean.BodyBean.ResultBean bean;
    private ArrayList<String> title;
    private ArrayList<Fragment> fragments;
    private TvfAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        ButterKnife.bind(this);

        initView();
        initData();

    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrlTeacher)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<InfoBean> observable = apiService.getInfoData(bean.getID());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InfoBean infoBean) {
                        List<InfoBean.BodyBean.ResultBean> result = infoBean.getBody().getResult();

                        if (result.size() == 2) {
                            fragments.add(new ContentFragment());
                            fragments.add(new ClassFragment());

                            title.add(infoBean.getBody().getResult().get(0).getDescription());
                            title.add(infoBean.getBody().getResult().get(1).getDescription());

                            adapter = new TvfAdapter(getSupportFragmentManager(), title, fragments);
                            adapter.notifyDataSetChanged();
                            vp.setAdapter(adapter);
                            tab.setupWithViewPager(vp);

                        } else {

                            fragments.add(new ContentFragment());
                            fragments.add(new ClassFragment());
                            fragments.add(new ZhuanTiFragment());

                            title.add(infoBean.getBody().getResult().get(0).getDescription());
                            title.add(infoBean.getBody().getResult().get(1).getDescription());
                            title.add(infoBean.getBody().getResult().get(2).getDescription());

                            adapter = new TvfAdapter(getSupportFragmentManager(), title, fragments);
                            adapter.notifyDataSetChanged();
                            vp.setAdapter(adapter);
                            tab.setupWithViewPager(vp);
                        }

                        /*for (int i = 0; i < infoBean.getBody().getResult().size(); i++) {
                            title.add(infoBean.getBody().getResult().get(i).getDescription());
                        }*/


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("tag", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        toolBar.setTitle("");
        setSupportActionBar(toolBar);
        bean = (TeachersBean.BodyBean.ResultBean) getIntent().getSerializableExtra("bean");

        tvTeacherName.setText(bean.getTeacherName());
        tvTitle.setText(bean.getTitle());
        Glide.with(this).load(bean.getTeacherPic()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(ivImg);

        title = new ArrayList<>();
        fragments = new ArrayList<>();


    }
}
