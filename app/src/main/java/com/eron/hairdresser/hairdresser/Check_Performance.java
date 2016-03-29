package com.eron.hairdresser.hairdresser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.views.progressbar.CBProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static butterknife.ButterKnife.bind;

/**
 * Author：Mark
 * Date：2016/3/28 0001
 * Tell：15006330640
 *
 *  业绩查询
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_check_achievement);
        bind(this);
        initConstants();
        initViews();
    }

    private void initViews() {

    }

    private void initConstants() {

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
