package com.bawei.gou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MaView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private MainPresenter presenter;
    private MyAdapter adapter;
    List<ShopBean.DataBean>list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.get();
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(manager);
        adapter = new MyAdapter(MainActivity.this);
        recycler.setAdapter(adapter);

       adapter.setOnItemClickListener(new OnItemClickListener() {
           @Override
           public void onItemClick(View view, int position) {
//               Intent intent = new Intent(MainActivity.this, PinActivity.class);
//               startActivity(intent);
           }
       });
    }

    @Override
    public void success(ShopBean bean) {
      adapter.addData(bean);
    }

    @Override
    public void failure() {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
