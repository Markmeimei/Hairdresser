package com.eron.hairdresser.hairdresser.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Setting_Activity_ListView_Adapter;
import com.lin.framwork.utils.UpdateUtil.VersionUpdateUtil;

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
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initConstants();
        Init();
    }

    private void initConstants() {
        context = Setting_Activity.this;
    }

    private void Init() {
        List<String> strings = new ArrayList<>();
        strings.add("更改密码");
        strings.add("清除缓存");
        strings.add("建议与反馈");
        strings.add("检查更新");
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
        switch (position) {
            case 0:
                startActivity(new Intent(context, ModifyPWDActivity.class));
                break;
            case 1:
//                startActivity(new Intent(context,));
                break;
            case 2:
                startActivity(new Intent(context, FeedbackActivity.class));
                break;
            case 3:
                new VersionUpdateUtil(this);
                break;
            case 4:
                startActivity(new Intent(context, AboutActivity.class));
                break;
        }
    }
}
