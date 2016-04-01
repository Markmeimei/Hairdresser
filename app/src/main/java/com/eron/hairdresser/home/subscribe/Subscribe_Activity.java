package com.eron.hairdresser.home.subscribe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Subscribe_Activity_ViewPager_Adapter;
import com.eron.hairdresser.views.headTitle.HeadTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Subscribe_Activity extends AppCompatActivity {

    @Bind(R.id.activity_subscribe_HeadTitle)
    HeadTitle activitySubscribeHeadTitle;
    @Bind(R.id.activity_subscribe_RadioButton01)
    RadioButton activitySubscribeRadioButton01;
    @Bind(R.id.activity_subscribe_RadioButton02)
    RadioButton activitySubscribeRadioButton02;
    @Bind(R.id.activity_subscribe_RadioButton03)
    RadioButton activitySubscribeRadioButton03;
    @Bind(R.id.activity_subscribe_RadioButton04)
    RadioButton activitySubscribeRadioButton04;
    @Bind(R.id.activity_subscribe_RadioButton05)
    RadioButton activitySubscribeRadioButton05;
    @Bind(R.id.activity_subscribe_RadioGroup)
    RadioGroup activitySubscribeRadioGroup;
    @Bind(R.id.activity_subscribe_ViewPager)
    ViewPager activitySubscribeViewPager;

    private Subscribe_Activity_ViewPager_Adapter viewPager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Subscribe_Fragment());
        fragments.add(new Subscribe_Fragment());
        fragments.add(new Subscribe_Fragment());
        fragments.add(new Subscribe_Fragment());
        fragments.add(new Subscribe_Fragment());
        viewPager_adapter = new Subscribe_Activity_ViewPager_Adapter(getSupportFragmentManager(), fragments);
        Content();
    }

    private void Content() {
        activitySubscribeViewPager.setAdapter(viewPager_adapter);
        activitySubscribeViewPager.setCurrentItem(0);
        activitySubscribeRadioButton01.setTextColor(getResources().getColor(R.color.color_theme));
        activitySubscribeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    activitySubscribeRadioButton01.setChecked(true);
                    activitySubscribeRadioButton01.setTextColor(getResources().getColor(R.color.color_theme));
                    activitySubscribeRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 1) {
                    activitySubscribeRadioButton02.setChecked(true);
                    activitySubscribeRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton02.setTextColor(getResources().getColor(R.color.color_theme));
                    activitySubscribeRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 2) {
                    activitySubscribeRadioButton03.setChecked(true);
                    activitySubscribeRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton03.setTextColor(getResources().getColor(R.color.color_theme));
                    activitySubscribeRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 3) {
                    activitySubscribeRadioButton04.setChecked(true);
                    activitySubscribeRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton04.setTextColor(getResources().getColor(R.color.color_theme));
                    activitySubscribeRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 4) {
                    activitySubscribeRadioButton05.setChecked(true);
                    activitySubscribeRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activitySubscribeRadioButton05.setTextColor(getResources().getColor(R.color.color_theme));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.activity_subscribe_RadioButton01, R.id.activity_subscribe_RadioButton02, R.id.activity_subscribe_RadioButton03, R.id.activity_subscribe_RadioButton04, R.id.activity_subscribe_RadioButton05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_subscribe_RadioButton01:
                activitySubscribeViewPager.setCurrentItem(0);
                break;
            case R.id.activity_subscribe_RadioButton02:
                activitySubscribeViewPager.setCurrentItem(1);
                break;
            case R.id.activity_subscribe_RadioButton03:
                activitySubscribeViewPager.setCurrentItem(2);
                break;
            case R.id.activity_subscribe_RadioButton04:
                activitySubscribeViewPager.setCurrentItem(3);
                break;
            case R.id.activity_subscribe_RadioButton05:
                activitySubscribeViewPager.setCurrentItem(4);
                break;
        }
    }
}
