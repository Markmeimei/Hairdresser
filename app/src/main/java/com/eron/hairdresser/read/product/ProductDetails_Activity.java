package com.eron.hairdresser.read.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.eron.hairdresser.R;
import com.eron.hairdresser.model.ProductDetails_Model;
import com.eron.hairdresser.model.Product_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.google.gson.Gson;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.SpannableStringUtil;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductDetails_Activity extends AppCompatActivity {
    public final static String Tag = "ProductDetails_Activity";

    @Bind(R.id.activity_product_details_HeadTitle)
    HeadTitle activityProductDetailsHeadTitle;
    @Bind(R.id.activity_product_details_ImageView)
    ImageView activityProductDetailsImageView;
    @Bind(R.id.activity_product_details_Name)
    TextView activityProductDetailsName;
    @Bind(R.id.activity_product_details_Type)
    TextView activityProductDetailsType;
    @Bind(R.id.activity_product_details_Price)
    TextView activityProductDetailsPrice;
    @Bind(R.id.activity_product_details_Effect)
    TextView activityProductDetailsEffect;
    @Bind(R.id.activity_product_details_Ingredient)
    TextView activityProductDetailsIngredient;

    private ProductDetails_Model model;
    private Map<String, String> map;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        intent = getIntent();
        map = new HashMap<>();
        model = new ProductDetails_Model();
        Content();
    }

    private void Content() {
        getData();
    }

    private void getData() {
        map.put("id", intent.getStringExtra(Product_Activity.Tag));
        new VolleyUtil<>().post(ConfigUrl.ProductDetails_ActivityUrl, ProductDetails_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                model = new Gson().fromJson(result, ProductDetails_Model.class);
                String Type = "类型    " + model.getObject().getTitle();
                String Price = "价格    " + model.getObject().getAddtime();
                Glide.with(ProductDetails_Activity.this)
                        .load(model.getObject().getPicture())
                        .placeholder(R.mipmap.img_default_loading)
                        .error(R.mipmap.img_default_error)
                        .crossFade()
                        .into(activityProductDetailsImageView);
                activityProductDetailsName.setText(model.getObject().getTitle());
                activityProductDetailsType.setText(SpannableStringUtil.getForegroundColor(Type, getResources().getColor(R.color.text_color1), 4, Type.length()));
                activityProductDetailsPrice.setText(SpannableStringUtil.getForegroundColor(Price, getResources().getColor(R.color.color_theme), 4, Price.length()));
                activityProductDetailsEffect.setText(model.getObject().getTitle());
                activityProductDetailsIngredient.setText(model.getObject().getTitle());
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(ProductDetails_Activity.this, "网络请求失败，请检查网络");
            }
        });
    }
}
