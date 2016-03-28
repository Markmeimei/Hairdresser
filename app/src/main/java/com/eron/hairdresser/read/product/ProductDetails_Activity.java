package com.eron.hairdresser.read.product;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Product_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.utils.SpannableStringUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductDetails_Activity extends AppCompatActivity {


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

    private Product_Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        model = new Product_Model();
        model.setName("产品名称");
        model.setType("热烫");
        model.setPrice("￥10086");
        model.setEffect("这里是功效");
        model.setIngredient("这里是成分");
        Content();
    }

    private void Content() {
        String Type = "类型    " + model.getType();
        String Price = "价格    " + model.getPrice();
        activityProductDetailsName.setText(model.getName());
        activityProductDetailsType.setText(SpannableStringUtil.getForegroundColor(Type, getResources().getColor(R.color.text_color1), 4, Type.length()));
        activityProductDetailsPrice.setText(SpannableStringUtil.getForegroundColor(Price, getResources().getColor(R.color.color_theme), 4, Price.length()));
        activityProductDetailsEffect.setText(model.getEffect());
        activityProductDetailsIngredient.setText(model.getIngredient());
    }
}
