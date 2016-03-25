package com.eron.hairdresser.hairdresser.setting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Setting_Activity_ListView_Adapter;
import com.eron.hairdresser.views.Views;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class Setting_Activity extends AppCompatActivity {

    @Bind(R.id.activity_setting_ListView)
    ListView activitySettingListView;
    @Bind(R.id.activity_setting_Exit)
    Button activitySettingExit;

    private Setting_Activity_ListView_Adapter listView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        List<String> strings = new ArrayList<>();
        strings.add("更改密码");
        strings.add("清除缓存");
        strings.add("建议与反馈");
        strings.add("关于应用");
        listView_adapter = new Setting_Activity_ListView_Adapter(this, strings);
        Content();
    }

    private void Content() {
        activitySettingListView.setAdapter(listView_adapter);
    }

    @OnClick(R.id.activity_setting_Exit)
    public void onClick() {

    }

    @OnItemClick(R.id.activity_setting_ListView)
    public void onItemClick(int position) {
        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
