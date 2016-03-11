package com.example.linbin_91.recyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class StraggerGirdActivityActivity extends ActionBarActivity {

    private List<String> mDatas;
    private StraggerAdapter adapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initView();

        adapter = new StraggerAdapter(this,mDatas);
        mRecyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new StraggerAdapter.OnClickListener() {
            @Override
            public void onClickListener(View view, int pos) {

                Toast.makeText(StraggerGirdActivityActivity.this, "click :" + pos, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickListener(View view, int pos) {
                adapter.notifyItemRemoved(pos);
                Toast.makeText(StraggerGirdActivityActivity.this, " long click :" + pos, Toast.LENGTH_LONG).show();
            }
        });

        //添加样式
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //mRecyclerView.setLayoutManager(linearLayoutManager);

        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加风格线
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    private void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
    }

    private void initDatas() {

        mDatas = new ArrayList<String>();

        for (int i = 'A'; i <= 'z'; i++){
            mDatas.add("" + (char)i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_add:
                adapter.addData(1);
                break;
            case R.id.action_delete:
                adapter.removeData(1);
                break;
            case R.id.action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                break;
            case R.id.action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_hor_gridview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                break;
            default:
                break;

        }
        return  super.onOptionsItemSelected(item);
    }


}
