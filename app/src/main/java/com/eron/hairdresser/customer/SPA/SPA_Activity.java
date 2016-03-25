package com.eron.hairdresser.customer.SPA;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.PermDye_Activity_ListView_Adapter;
import com.eron.hairdresser.adapter.SPA_Activity_ListView_Adapter;
import com.eron.hairdresser.common.IntentTag;
import com.eron.hairdresser.customer.Details_Activity;
import com.eron.hairdresser.customer.newUser.NewRecord_Activity;
import com.eron.hairdresser.model.Customer_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class SPA_Activity extends AppCompatActivity {

    @Bind(R.id.activity_spa_HeadTitle)
    HeadTitle activitySpaHeadTitle;
    @Bind(R.id.activity_spa_ListView)
    ListView activitySpaListView;

    private SPA_Activity_ListView_Adapter listView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa);
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
        listView_adapter = new SPA_Activity_ListView_Adapter(this, modelList);
        Content();
    }

    private void Content() {
        activitySpaHeadTitle.setRightOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.goToContext(SPA_Activity.this, NewRecord_Activity.class, IntentTag.newRecordTag, IntentTag.getNewRecordBase(3));
            }
        });
        activitySpaListView.setAdapter(listView_adapter);
    }

    @OnItemClick(R.id.activity_spa_ListView)
    public void onItemClick(int position) {
        IntentUtil.goToContext(this, Details_Activity.class);
    }
}
