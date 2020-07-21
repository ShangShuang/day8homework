package com.example.day8homework;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day8homework.acivity.TeacherActivity;
import com.example.day8homework.adapter.TeacherAdapter;
import com.example.day8homework.base.BaseActivity;
import com.example.day8homework.bean.TeachersBean;
import com.example.day8homework.presenter.TeacherPresenter;
import com.example.day8homework.view.TeacherView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<TeacherPresenter> implements TeacherView {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<TeachersBean.BodyBean.ResultBean> datas;
    private TeacherAdapter adapter;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }*/

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        presenter = new TeacherPresenter();
    }

    @Override
    protected void initView() {
        toolBar.setTitle("");
        setSupportActionBar(toolBar);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        datas = new ArrayList<>();

        //创建适配器
        adapter = new TeacherAdapter(this, datas);
        rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(new TeacherAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, TeacherActivity.class);
                intent.putExtra("bean", datas.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(TeachersBean teachersBean) {
        datas.addAll(teachersBean.getBody().getResult());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
