package com.bawei.gou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.gou.jiagou.AddCartBean;
import com.bawei.gou.jiagou.AddCartModelCallBack;
import com.bawei.gou.jiagou.AddCartPresenter;
import com.bawei.gou.jiagou.AddCartViewCallBack;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Adminjs on 2017/12/20.
 */

public class PinActivity extends Activity implements AddCartModelCallBack, AddCartViewCallBack {
    @BindView(R.id.image)
    Banner uimage;
    @BindView(R.id.name)
    TextView uname;
    @BindView(R.id.uprice)
    TextView uprice;
    @BindView(R.id.jia)
    Button jia;
    @BindView(R.id.gou)
    Button gou;
    private String image1;
    private AddCartPresenter addCartPresenter;
    private String pid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        ButterKnife.bind(this);

        Bundle buddle = getIntent().getExtras();
        pid1 = buddle.getString("pid");
        image1 = buddle.getString("image");
        String name1 = buddle.getString("name");
        String price1 = buddle.getString("price");

        final String[] split = this.image1.split("\\|");

        uimage.setImageLoader(new GlideImageLoader());
        List<String> bannerList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            bannerList.add(split[i]);
        }
        uimage.setImages(bannerList);
        uimage.start();
        uname.setText(name1);
        uprice.setText("￥"+ price1);

        addCartPresenter = new AddCartPresenter(this);

        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCartPresenter.getData(pid1);


            }
        });
    }

    @Override
    public void success(AddCartBean addCartBean) {
        Toast.makeText(this,""+addCartBean.getMsg(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(PinActivity.this, GouActivity.class);
        startActivity(intent);
    }

    @Override
    public void failure() {
        Toast.makeText(this,""+"加入失败",Toast.LENGTH_LONG).show();

    }

}
