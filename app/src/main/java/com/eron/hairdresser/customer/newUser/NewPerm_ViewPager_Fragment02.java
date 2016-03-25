package com.eron.hairdresser.customer.newUser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.lin.framwork.utils.IntentUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPerm_ViewPager_Fragment02 extends Fragment {

    @Bind(R.id.fragment_new_perm_viewpager02_Remain)
    TextView fragmentNewPermViewpager02Remain;
    @Bind(R.id.fragment_new_perm_viewpager02_Way)
    TextView fragmentNewPermViewpager02Way;
    @Bind(R.id.fragment_new_perm_viewpager02_Normal)
    TextView fragmentNewPermViewpager02Normal;
    @Bind(R.id.fragment_new_perm_viewpager02_ImgLabel01)
    ImageView fragmentNewPermViewpager02ImgLabel01;
    @Bind(R.id.fragment_new_perm_viewpager02_ImgLabel02)
    ImageView fragmentNewPermViewpager02ImgLabel02;
    @Bind(R.id.fragment_new_perm_viewpager02_ImgBackground01)
    ImageView fragmentNewPermViewpager02ImgBackground01;
    @Bind(R.id.fragment_new_perm_viewpager02_ImageView01)
    ImageView fragmentNewPermViewpager02ImageView01;
    @Bind(R.id.fragment_new_perm_viewpager02_ImgBackground02)
    ImageView fragmentNewPermViewpager02ImgBackground02;
    @Bind(R.id.fragment_new_perm_viewpager02_ImageView02)
    ImageView fragmentNewPermViewpager02ImageView02;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new_perm_viewpager02, container, false);
            ButterKnife.bind(this, view);
            Init();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    private void Init() {
        Content();
    }

    private void Content() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.fragment_new_perm_viewpager02_ImageView01, R.id.fragment_new_perm_viewpager02_ImageView02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_new_perm_viewpager02_ImageView01:
                IntentUtil.openCamera(getActivity());
                break;
            case R.id.fragment_new_perm_viewpager02_ImageView02:
                IntentUtil.openCamera(getActivity());
                break;
        }
    }
}
