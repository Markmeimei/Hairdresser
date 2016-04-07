package com.eron.hairdresser.customer.permDye;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.PermDye_Activity_ListView_Adapter;
import com.eron.hairdresser.common.TagName;
import com.eron.hairdresser.customer.Details_Activity;
import com.eron.hairdresser.customer.newUser.NewRecord_Activity;
import com.eron.hairdresser.model.Customer_Model;
import com.eron.hairdresser.model.PermDye_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.google.gson.Gson;
import com.lin.framwork.application.ApplicationTools;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.PopupWindow_Control.PopupWindowListView;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String, String> map;
    private List<PermDye_Model.ObjectBean> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perm_dye);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        map = new HashMap<>();
        modelList = new ArrayList<>();
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
        getData();
    }

    private void getData() {
        map.put("uid", ApplicationTools.getUser().getObject().getId());
        map.put("cat", "1");
        new VolleyUtil<>().post(ConfigUrl.Customer_FragmentUrl, PermDye_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                PermDye_Model model = new Gson().fromJson(result,PermDye_Model.class);
                modelList.addAll(model.getObject());
                listView_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(PermDye_Activity.this, "网络请求失败，请检查网络");
            }
        });
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
        PopupWindowListView windowListView = new PopupWindowListView(this, strings, strings, strings);
        windowListView.showPopupWindow(activityPermDyeFiltrate);
    }
}
