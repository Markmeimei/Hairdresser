package com.eron.hairdresser.hairdresser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.eron.hairdresser.views.progressbar.CBProgressBar;
import com.lin.framwork.views.PopupWindow_Control.Adapter_PopupWindowListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static butterknife.ButterKnife.bind;

/**
 * Author：Mark
 * Date：2016/3/28 0001
 * Tell：15006330640
 * <p/>
 * 业绩查询
 */
public class Check_Performance extends Activity {
    @Bind(R.id.ll_check_achievement)
    LinearLayout llCheckAchievement;
    @Bind(R.id.tv_achievement_quantity)
    TextView tvAchievementQuantity;
    @Bind(R.id.ll_achievement_quantity)
    LinearLayout llAchievementQuantity;
    @Bind(R.id.pr_quantity_perm)
    CBProgressBar prQuantityPerm;
    @Bind(R.id.tv_achievement_quantity2)
    TextView tvAchievementQuantity2;
    @Bind(R.id.ll_achievement_quantity2)
    LinearLayout llAchievementQuantity2;
    @Bind(R.id.pr_quantity_color)
    CBProgressBar prQuantityColor;
    @Bind(R.id.tv_achievement_quantity3)
    TextView tvAchievementQuantity3;
    @Bind(R.id.ll_achievement_quantity3)
    LinearLayout llAchievementQuantity3;
    @Bind(R.id.pr_quantity_nursing)
    CBProgressBar prQuantityNursing;
    @Bind(R.id.tv_achievement_total)
    TextView tvAchievementTotal;
    @Bind(R.id.activity_new_user_HeadTitle)
    HeadTitle activityNewUserHeadTitle;
    @Bind(R.id.activity_check_achievement_Spinner)
    Spinner activityCheckAchievementSpinner;

    private Adapter_PopupWindowListView Spinner_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_check_achievement);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        List<String> list = new ArrayList<>();
        list.add("按周");
        list.add("按月");
        list.add("按季");
        Spinner_adapter = new Adapter_PopupWindowListView(this, list);
        activityCheckAchievementSpinner.setAdapter(Spinner_adapter);
        activityCheckAchievementSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        prQuantityPerm.updateProgress(65);
                        prQuantityColor.updateProgress(80);
                        prQuantityNursing.updateProgress(30);
                        break;
                    case 1:
                        prQuantityPerm.updateProgress(20);
                        prQuantityColor.updateProgress(40);
                        prQuantityNursing.updateProgress(15);
                        break;
                    case 2:
                        prQuantityPerm.updateProgress(10);
                        prQuantityColor.updateProgress(20);
                        prQuantityNursing.updateProgress(7);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_achievement_quantity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_achievement_quantity:
                break;
        }
    }
}
