package com.slientwhale.www.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.slientwhale.www.example.base.BaseActivity;
import com.slientwhale.www.example.ui.ViewDemo01_paint_Activity;
import com.slientwhale.www.example.ui.adapter.DemoListAdapter;
import com.slientwhale.www.example.widget.BaseRecycleView;
import com.slientwhale.www.example.widget.listener.BaseRecycleListener;

import java.util.Arrays;

public class DemoListActivity extends BaseActivity implements BaseRecycleListener{

    private BaseRecycleView<String> recycleView;
    private DemoListAdapter<String> adapter;
    private String[] item;
    private Class[] classs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new DemoListAdapter<>(this.getBaseContext());
        recycleView.setAdapter(adapter);
        initData();
    }

    //创建项目
    private void initData() {
        item = new String[]{"Paint 的用法"};
        classs = new Class[]{ViewDemo01_paint_Activity.class};
        recycleView.addItems(Arrays.asList(item));
    }

    @Override
    public View addContainer() {
        recycleView = new BaseRecycleView(this.getBaseContext());
        return recycleView;
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
