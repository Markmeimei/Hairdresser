package com.eron.hairdresser.customer.newUser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.NewPerm_Fragment_ViewPager_Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPerm_Fragment extends Fragment {
    @Bind(R.id.fragment_new_perm_Perm)
    TextView fragmentNewPermPerm;
    @Bind(R.id.fragment_new_perm_ProjectName)
    TextView fragmentNewPermProjectName;
    @Bind(R.id.fragment_new_perm_Money)
    EditText fragmentNewPermMoney;
    @Bind(R.id.fragment_new_perm_StartTime)
    TextView fragmentNewPermStartTime;
    @Bind(R.id.fragment_new_perm_FinishTime)
    EditText fragmentNewPermFinishTime;
    @Bind(R.id.fragment_new_perm_RadioButton01)
    RadioButton fragmentNewPermRadioButton01;
    @Bind(R.id.fragment_new_perm_RadioButton02)
    RadioButton fragmentNewPermRadioButton02;
    @Bind(R.id.fragment_new_perm_RadioGroup)
    RadioGroup fragmentNewPermRadioGroup;
    @Bind(R.id.fragment_new_perm_ViewPager)
    ViewPager fragmentNewPermViewPager;

    private View view;
    private NewPerm_Fragment_ViewPager_Adapter viewPager_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new_perm, container, false);
            ButterKnife.bind(this, view);
            Init();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    private void Init() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new NewPerm_ViewPager_Fragment01());
        fragmentList.add(new NewPerm_ViewPager_Fragment02());
        viewPager_adapter = new NewPerm_Fragment_ViewPager_Adapter(getFragmentManager(), fragmentList);
        Content();
    }

    private void Content() {
        fragmentNewPermViewPager.setAdapter(viewPager_adapter);
        fragmentNewPermViewPager.setCurrentItem(0);
        fragmentNewPermRadioButton01.setTextColor(getResources().getColor(R.color.white));
        fragmentNewPermViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    fragmentNewPermRadioButton01.setChecked(true);
                    fragmentNewPermRadioButton01.setTextColor(getResources().getColor(R.color.white));
                    fragmentNewPermRadioButton02.setTextColor(getResources().getColor(R.color.color_theme));
                }
                if (position == 1) {
                    fragmentNewPermRadioButton02.setChecked(true);
                    fragmentNewPermRadioButton01.setTextColor(getResources().getColor(R.color.color_theme));
                    fragmentNewPermRadioButton02.setTextColor(getResources().getColor(R.color.white));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.fragment_new_perm_RadioButton01, R.id.fragment_new_perm_RadioButton02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_new_perm_RadioButton01:
                fragmentNewPermViewPager.setCurrentItem(0);
                break;
            case R.id.fragment_new_perm_RadioButton02:
                fragmentNewPermViewPager.setCurrentItem(1);
                break;
        }
    }
}
