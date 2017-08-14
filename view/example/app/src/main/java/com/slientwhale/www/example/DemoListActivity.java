package com.slientwhale.www.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.slientwhale.www.example.base.BaseActivity;
import com.slientwhale.www.example.ui.ViewDemo01_paint_Activity;
import com.slientwhale.www.example.widget.BaseRecycleView;
import com.slientwhale.www.example.widget.listener.BaseRecycleListener;

import java.util.ArrayList;
import java.util.List;

public class DemoListActivity extends BaseActivity implements BaseRecycleListener{

    private BaseRecycleView recycleView;
    private ListAdapter<String> adapter;
    private List<String> item;
    private Class[] classs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }

    private void initView() {
        recycleView = (BaseRecycleView) this.findViewById(R.id.recycle);
        adapter = new ListAdapter<String>(this.getBaseContext());
        adapter.addItems(item);
        recycleView.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        recycleView.setAdapter(adapter);
        adapter.setItemClickListener(this);
    }

    //创建项目
    private void initData() {
        item = new ArrayList<String>();
        item.add("Paint的用法");
        classs = new Class[]{ViewDemo01_paint_Activity.class};
    }

    @Override
    public View addContainer() {
        View layout = LayoutInflater.from(this.getBaseContext()).inflate(R.layout.layout_recycle,null);
        return layout;
    }


    @Override
    public void onItemClick(int position, Object data) {
        Intent intent = new Intent(this.getBaseContext(),classs[position]);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(int position, Object data) {

    }
}
