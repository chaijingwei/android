package com.yemamacake.cn.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.yemamacake.cn.R;
import com.yemamacake.cn.adapter.Myadapter;
import com.yemamacake.cn.entity.Product;
import com.yemamacake.cn.fragment.SetDetailFragment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends Activity {
    private OnChangeListener onchangedListener;
    private List <Product> productList;
    private List <String> productCategory=new ArrayList <>();
    private ListView titleList;
    private Myadapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_category);
        initData();//初始化数据
        init();
        SetDetailFragment fragment = new SetDetailFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.category_detail,fragment);
        transaction.commit();
        titleList.setOnItemClickListener((parent, view, position, id) -> {
            adapter.setSelectedPosition(position);
            adapter.notifyDataSetInvalidated();
            if (onchangedListener != null) {
                onchangedListener.changeText(productList.get(position));
            }
        });

    }

    private void initData() {
        productList= new ArrayList<>();//在此进行新建
        productCategory.add("美味面包");
        productCategory.add("酥松蛋糕");
        productCategory.add("甜品慕斯");
        productCategory.add("生日蛋糕");
        Product product = new Product();
        product.setProductIntroduce("选用高筋面粉、优质牛奶制作，不加一滴水");
        product.setImageUrlId(R.drawable.img_4);
        product.setProductName("手工奶香吐司");
        product.setProductPrice(new BigDecimal("9.9"));//需将9.9进行bigdecimal类型转化
        Product product1 = new Product();
        product1.setProductIntroduce("选用低筋面粉、新鲜草莓制作，满满果粒get!");
        product1.setImageUrlId(R.drawable.img_5);
        product1.setProductName("草莓戚风");
        product1.setProductPrice(new BigDecimal("15.9"));
        Product product2 = new Product();
        product2.setProductIntroduce("动物奶油、新鲜芒果，诚意满满");
        product2.setImageUrlId(R.drawable.img_6);
        product2.setProductName("芒果盒子");
        product2.setProductPrice(new BigDecimal("10.9"));
        Product product3=new Product();
        product3.setProductIntroduce("我们承诺，纯动物奶油、新鲜水果，只为您带来最好的体验");
        product3.setProductPrice(new BigDecimal(99));
        product3.setProductName("八寸水果生日蛋糕");
        product3.setImageUrlId(R.drawable.cake);
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);




    }

    private void init()
    {
        titleList = findViewById(R.id.category_title_list);
        adapter=new Myadapter(productCategory,CategoryActivity.this);
        titleList.setAdapter(adapter);
    }

    public void setOnChangeListener(OnChangeListener onChangeListener) {
        this.onchangedListener = onChangeListener;
    }

    public interface OnChangeListener {
        void changeText(Product product);
    }

}
