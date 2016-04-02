package com.eron.hairdresser.customer.nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Nutrition_Activity_ListView_Adapter;
import com.eron.hairdresser.common.TagName;
import com.eron.hairdresser.customer.Details_Activity;
import com.eron.hairdresser.customer.newUser.NewRecord_Activity;
import com.eron.hairdresser.model.Customer_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.PopupWindow_Control.PopupWindowListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class Nutrition_Activity extends AppCompatActivity {
    public final static String Tag = "Nutrition_Activity";

    @Bind(R.id.activity_nutrition_HeadTitle)
    HeadTitle activityNutritionHeadTitle;
    @Bind(R.id.activity_nutrition_ListView)
    ListView activityNutritionListView;
    @Bind(R.id.activity_nutrition_Filtrate)
    TextView activityNutritionFiltrate;

    private Nutrition_Activity_ListView_Adapter listView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        List<Customer_Model> modelList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Customer_Model model = new Customer_Model();
            if (i % 4 == 0) {
                model.setName("小明");
                model.setCardNumber("111111");
                model.setCardVariety(1);
            } else {
                model.setName("小红");
                model.setCardNumber("222222");
                model.setCardVariety(2);
            }
            modelList.add(model);
        }
        listView_adapter = new Nutrition_Activity_ListView_Adapter(this, modelList);
        Content();
    }

    private void Content() {
        activityNutritionHeadTitle.setRightOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.goToContext(Nutrition_Activity.this, NewRecord_Activity.class, TagName.newRecordTag, Tag);
            }
        });
        activityNutritionListView.setAdapter(listView_adapter);
    }

    @OnItemClick(R.id.activity_nutrition_ListView)
    public void onItemClick(int position) {
        IntentUtil.goToContext(this, Details_Activity.class, TagName.DetailsTag, Tag);
    }

    @OnClick(R.id.activity_nutrition_Filtrate)
    public void onClick() {

        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        PopupWindowListView windowListView = new PopupWindowListView(this, strings);
        windowListView.showPopupWindow(activityNutritionFiltrate);
    }
}
