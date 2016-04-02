package com.eron.hairdresser.customer.permDye;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.PermDye_Activity_ListView_Adapter;
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

public class PermDye_Activity extends AppCompatActivity {
    public final static String Tag = "PermDye_Activity";

    @Bind(R.id.activity_perm_dye_HeadTitle)
    HeadTitle activityPermDyeHeadTitle;
    @Bind(R.id.activity_perm_dye_ListView)
    ListView activityPermDyeListView;
    @Bind(R.id.activity_perm_dye_Filtrate)
    TextView activityPermDyeFiltrate;

    private PermDye_Activity_ListView_Adapter listView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perm_dye);
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
        listView_adapter = new PermDye_Activity_ListView_Adapter(this, modelList);
        Content();
    }

    private void Content() {
        activityPermDyeHeadTitle.setRightOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.goToContext(PermDye_Activity.this, NewRecord_Activity.class, TagName.newRecordTag, Tag);
            }
        });
        activityPermDyeListView.setAdapter(listView_adapter);
    }

    @OnItemClick(R.id.activity_perm_dye_ListView)
    public void onItemClick(int position) {
        IntentUtil.goToContext(this, Details_Activity.class, TagName.DetailsTag, Tag);
    }

    @OnClick(R.id.activity_perm_dye_Filtrate)
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
        windowListView.showPopupWindow(activityPermDyeFiltrate);
    }
}
