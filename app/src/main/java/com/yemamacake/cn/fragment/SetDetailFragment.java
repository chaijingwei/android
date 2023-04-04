package com.yemamacake.cn.fragment;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yemamacake.cn.R;
import com.yemamacake.cn.activity.CategoryActivity;

import java.util.Objects;

public class SetDetailFragment extends Fragment {
    private View view;
    private ImageView imageView;
    private TextView nameText, priceText,produceText;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.category_detail_content, container, false);
        if (view != null) {
            init();
        }
        CategoryActivity categoryActivity = (CategoryActivity) getActivity();
        Objects.requireNonNull(categoryActivity).setOnChangeListener(product -> {
            Log.i("sss", "onCreateView: " + product.getProductName());
            imageView.setBackgroundResource(product.getImageUrlId());
            nameText.setText(product.getProductName());
            priceText.setText(product.getProductPrice().toString());
            produceText.setText(product.getProductIntroduce());
        });
        return view;
    }

    /**
     * 内容组件初始化
     */
    private void init() {
        imageView = view.findViewById(R.id.category_product_image);
        nameText = view.findViewById(R.id.category_product_name);
        priceText = view.findViewById(R.id.category_product_price);
         produceText= view.findViewById(R.id.category_product_introduce);
    }

}
