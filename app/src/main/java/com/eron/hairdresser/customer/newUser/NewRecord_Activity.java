package com.eron.hairdresser.customer.newUser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.eron.hairdresser.R;
import com.eron.hairdresser.common.TagName;
import com.eron.hairdresser.customer.SPA.SPA_Activity;
import com.eron.hairdresser.customer.hairdressing.Hairdressing_Activity;
import com.eron.hairdresser.customer.nutrition.Nutrition_Activity;
import com.eron.hairdresser.customer.permDye.PermDye_Activity;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewRecord_Activity extends FragmentActivity {

    @Bind(R.id.activity_new_user_HeadTitle)
    HeadTitle activityNewUserHeadTitle;
    @Bind(R.id.activity_new_user_LinearLayout01)
    LinearLayout activityNewUserLinearLayout01;
    @Bind(R.id.activity_new_user_LinearLayout02)
    LinearLayout activityNewUserLinearLayout02;
    @Bind(R.id.activity_new_user_LinearLayout03)
    LinearLayout activityNewUserLinearLayout03;

    private Intent intent;
    private String intentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        intent = getIntent();
        Content();
    }

    private void Content() {
        intentTag = intent.getStringExtra(TagName.newRecordTag);
        if (intentTag.equals(PermDye_Activity.Tag))
            getSupportFragmentManager().beginTransaction()
                    .add(activityNewUserLinearLayout01.getId(), new NewUser_Fragment())
                    .add(activityNewUserLinearLayout02.getId(), new NewPerm_Fragment())
                    .add(activityNewUserLinearLayout03.getId(), new NewDye_Fragment()).commit();
        else if (intentTag.equals(Nutrition_Activity.Tag))
            getSupportFragmentManager().beginTransaction()
                    .add(activityNewUserLinearLayout01.getId(), new NewUser_Fragment())
                    .add(activityNewUserLinearLayout02.getId(), new NewNutrition_Fragment()).commit();
        else if (intentTag.equals(SPA_Activity.Tag))
            getSupportFragmentManager().beginTransaction()
                    .add(activityNewUserLinearLayout01.getId(), new NewUser_Fragment())
                    .add(activityNewUserLinearLayout02.getId(), new NewScalp_Fragment()).commit();
        else if (intentTag.equals(Hairdressing_Activity.Tag))
            Toast_Common.DefaultToast(this, "暂无");
    }
}
