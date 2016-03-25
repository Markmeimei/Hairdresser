package com.eron.hairdresser.customer.newUser;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.eron.hairdresser.R;
import com.eron.hairdresser.views.headTitle.HeadTitle;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewUser_Activity extends FragmentActivity {

    @Bind(R.id.activity_new_user_HeadTitle)
    HeadTitle activityNewUserHeadTitle;
    @Bind(R.id.activity_new_user_User)
    LinearLayout activityNewUserUser;
    @Bind(R.id.activity_new_user_Staff)
    LinearLayout activityNewUserStaff;
    @Bind(R.id.activity_new_user_Perm)
    LinearLayout activityNewUserPerm;
    @Bind(R.id.activity_new_user_Dye)
    LinearLayout activityNewUserDye;
    @Bind(R.id.activity_new_user_Scalp)
    LinearLayout activityNewUserScalp;
    @Bind(R.id.activity_new_user_Nutrition)
    LinearLayout activityNewUserNutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        Content();
    }

    private void Content() {
        getSupportFragmentManager().beginTransaction()
                .add(activityNewUserUser.getId(), new NewUser_Fragment())
                .add(activityNewUserStaff.getId(), new NewStaff_Fragment())
                .add(activityNewUserPerm.getId(), new NewPerm_Fragment())
                .add(activityNewUserDye.getId(), new NewDye_Fragment())
                .add(activityNewUserScalp.getId(), new NewScalp_Fragment())
                .add(activityNewUserNutrition.getId(), new NewNutrition_Fragment()).commit();
    }
}
