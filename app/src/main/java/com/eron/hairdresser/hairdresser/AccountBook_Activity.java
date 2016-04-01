package com.eron.hairdresser.hairdresser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Expire_Activity_ViewPager_Adapter;
import com.eron.hairdresser.home.expire.Expire_Fragment;
import com.eron.hairdresser.views.headTitle.HeadTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountBook_Activity extends AppCompatActivity {

    @Bind(R.id.activity_account_book_HeadTitle)
    HeadTitle activityAccountBookHeadTitle;
    @Bind(R.id.activity_account_book_RadioButton01)
    RadioButton activityAccountBookRadioButton01;
    @Bind(R.id.activity_account_book_RadioButton02)
    RadioButton activityAccountBookRadioButton02;
    @Bind(R.id.activity_account_book_RadioButton03)
    RadioButton activityAccountBookRadioButton03;
    @Bind(R.id.activity_account_book_RadioButton04)
    RadioButton activityAccountBookRadioButton04;
    @Bind(R.id.activity_account_book_RadioButton05)
    RadioButton activityAccountBookRadioButton05;
    @Bind(R.id.activity_account_book_RadioGroup)
    RadioGroup activityAccountBookRadioGroup;
    @Bind(R.id.activity_account_book_ViewPager)
    ViewPager activityAccountBookViewPager;

    private Expire_Activity_ViewPager_Adapter viewPager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_book);
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
        activityAccountBookViewPager.setAdapter(viewPager_adapter);
        activityAccountBookViewPager.setCurrentItem(0);
        activityAccountBookRadioButton01.setTextColor(getResources().getColor(R.color.color_theme));
        activityAccountBookViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    activityAccountBookRadioButton01.setChecked(true);
                    activityAccountBookRadioButton01.setTextColor(getResources().getColor(R.color.color_theme));
                    activityAccountBookRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 1) {
                    activityAccountBookRadioButton02.setChecked(true);
                    activityAccountBookRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton02.setTextColor(getResources().getColor(R.color.color_theme));
                    activityAccountBookRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 2) {
                    activityAccountBookRadioButton03.setChecked(true);
                    activityAccountBookRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton03.setTextColor(getResources().getColor(R.color.color_theme));
                    activityAccountBookRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 3) {
                    activityAccountBookRadioButton04.setChecked(true);
                    activityAccountBookRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton04.setTextColor(getResources().getColor(R.color.color_theme));
                    activityAccountBookRadioButton05.setTextColor(getResources().getColor(R.color.text_color));
                }
                if (position == 4) {
                    activityAccountBookRadioButton05.setChecked(true);
                    activityAccountBookRadioButton01.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton02.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton03.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton04.setTextColor(getResources().getColor(R.color.text_color));
                    activityAccountBookRadioButton05.setTextColor(getResources().getColor(R.color.color_theme));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.activity_account_book_RadioButton01, R.id.activity_account_book_RadioButton02, R.id.activity_account_book_RadioButton03, R.id.activity_account_book_RadioButton04, R.id.activity_account_book_RadioButton05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_account_book_RadioButton01:
                activityAccountBookViewPager.setCurrentItem(0);
                break;
            case R.id.activity_account_book_RadioButton02:
                activityAccountBookViewPager.setCurrentItem(1);
                break;
            case R.id.activity_account_book_RadioButton03:
                activityAccountBookViewPager.setCurrentItem(2);
                break;
            case R.id.activity_account_book_RadioButton04:
                activityAccountBookViewPager.setCurrentItem(3);
                break;
            case R.id.activity_account_book_RadioButton05:
                activityAccountBookViewPager.setCurrentItem(4);
                break;
        }
    }
}
