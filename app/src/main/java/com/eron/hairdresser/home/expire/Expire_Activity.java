package com.eron.hairdresser.home.expire;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Expire_Activity_ViewPager_Adapter;
import com.eron.hairdresser.customer.newUser.NewPerm_ViewPager_Fragment01;
import com.eron.hairdresser.customer.newUser.NewPerm_ViewPager_Fragment02;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Expire_Activity extends AppCompatActivity {

    @Bind(R.id.activity_expire_RadioButton01)
    RadioButton activityExpireRadioButton01;
    @Bind(R.id.activity_expire_RadioButton02)
    RadioButton activityExpireRadioButton02;
    @Bind(R.id.activity_expire_RadioButton03)
    RadioButton activityExpireRadioButton03;
    @Bind(R.id.activity_expire_RadioButton04)
    RadioButton activityExpireRadioButton04;
    @Bind(R.id.activity_expire_RadioButton05)
    RadioButton activityExpireRadioButton05;
    @Bind(R.id.activity_expire_RadioGroup)
    RadioGroup activityExpireRadioGroup;
    @Bind(R.id.activity_expire_ViewPager)
    ViewPager activityExpireViewPager;

    private Expire_Activity_ViewPager_Adapter viewPager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expire);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Expire_Fragment());
        fragments.add(new Expire_Fragment());
        fragments.add(new Expire_Fragment());
        fragments.add(new Expire_Fragment());
        fragments.add(new Expire_Fragment());
        viewPager_adapter = new Expire_Activity_ViewPager_Adapter(getSupportFragmentManager(), fragments);
        Content();
    }

    private void Content() {
        activityExpireViewPager.setAdapter(viewPager_adapter);
        activityExpireViewPager.setCurrentItem(0);
        activityExpireRadioButton01.setTextColor(getResources().getColor(R.color.color_theme));
        activityExpireViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    activityExpireRadioButton01.setChecked(true);
                    activityExpireRadioButton01.setTextColor(getResources().getColor(R.color.color_theme));
                    activityExpireRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 1) {
                    activityExpireRadioButton02.setChecked(true);
                    activityExpireRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton02.setTextColor(getResources().getColor(R.color.color_theme));
                    activityExpireRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 2) {
                    activityExpireRadioButton03.setChecked(true);
                    activityExpireRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton03.setTextColor(getResources().getColor(R.color.color_theme));
                    activityExpireRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 3) {
                    activityExpireRadioButton04.setChecked(true);
                    activityExpireRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton04.setTextColor(getResources().getColor(R.color.color_theme));
                    activityExpireRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 4) {
                    activityExpireRadioButton05.setChecked(true);
                    activityExpireRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityExpireRadioButton05.setTextColor(getResources().getColor(R.color.color_theme));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.activity_expire_RadioButton01, R.id.activity_expire_RadioButton02, R.id.activity_expire_RadioButton03, R.id.activity_expire_RadioButton04, R.id.activity_expire_RadioButton05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_expire_RadioButton01:
                activityExpireViewPager.setCurrentItem(0);
                break;
            case R.id.activity_expire_RadioButton02:
                activityExpireViewPager.setCurrentItem(1);
                break;
            case R.id.activity_expire_RadioButton03:
                activityExpireViewPager.setCurrentItem(2);
                break;
            case R.id.activity_expire_RadioButton04:
                activityExpireViewPager.setCurrentItem(3);
                break;
            case R.id.activity_expire_RadioButton05:
                activityExpireViewPager.setCurrentItem(4);
                break;
        }
    }
}
