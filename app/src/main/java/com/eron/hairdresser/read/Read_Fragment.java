package com.eron.hairdresser.read;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Read_Fragment_GridView_Adapter_Centre;
import com.eron.hairdresser.adapter.Read_Fragment_GridView_Adapter_Down;
import com.eron.hairdresser.adapter.Read_Fragment_GridView_Adapter_Up;
import com.eron.hairdresser.common.TagName;
import com.eron.hairdresser.read.companyProfile.CompanyProfile_Activity;
import com.eron.hairdresser.read.hairStyleImg.HairStyleImg_Activity;
import com.eron.hairdresser.read.product.Product_Activity;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * 阅读界面
 */
public class Read_Fragment extends Fragment {
    public final static String Tag = "Read_Fragment";

    @Bind(R.id.fragment_read_up)
    GridView fragmentReadUp;
    @Bind(R.id.fragment_read_centre)
    GridView fragmentReadCentre;
    @Bind(R.id.fragment_read_down)
    GridView fragmentReadDown;

    private View view;
    private Read_Fragment_GridView_Adapter_Up adapter_up;
    private Read_Fragment_GridView_Adapter_Centre adapter_centre;
    private Read_Fragment_GridView_Adapter_Down adapter_down;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_read, container, false);
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
        List<String> stringList_up = new ArrayList<>();
        stringList_up.add("公司简介");
        stringList_up.add("升迁制度");
        stringList_up.add("规章制度");
        List<String> stringList_down = new ArrayList<>();
        stringList_down.add("原创图片");
        stringList_down.add("选载图片");
        stringList_down.add("推广图片");
        adapter_up = new Read_Fragment_GridView_Adapter_Up(getActivity(), stringList_up);
        adapter_centre = new Read_Fragment_GridView_Adapter_Centre(getActivity());
        adapter_down = new Read_Fragment_GridView_Adapter_Down(getActivity(), stringList_down);
        Content();
    }

    private void Content() {
        fragmentReadUp.setAdapter(adapter_up);
        fragmentReadCentre.setAdapter(adapter_centre);
        fragmentReadDown.setAdapter(adapter_down);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_read_up)
    public void onItemClick_up(int position) {
        switch (position) {
            case 0:
                IntentUtil.goToContext(getActivity(), CompanyProfile_Activity.class, TagName.ReadTag, "2"); //公司简介
                break;
            case 1:
                IntentUtil.goToContext(getActivity(), CompanyProfile_Activity.class, TagName.ReadTag, "3"); //迁升制度
                break;
            case 2:
                IntentUtil.goToContext(getActivity(), CompanyProfile_Activity.class, TagName.ReadTag, "4"); //规章制度
                break;
        }
    }

    @OnItemClick(R.id.fragment_read_centre)
    public void onItemClick_centre(int position) {
        switch (position) {
            case 0:
                IntentUtil.goToContext(getActivity(), Product_Activity.class, TagName.ReadTag, "1"); //烫发产品
                break;
            case 1:
                IntentUtil.goToContext(getActivity(), Product_Activity.class, TagName.ReadTag, "2"); //染发产品
                break;
            case 2:
                IntentUtil.goToContext(getActivity(), Product_Activity.class, TagName.ReadTag, "3"); //护发产品
                break;
        }
    }

    @OnItemClick(R.id.fragment_read_down)
    public void onItemClick_down(int position) {
        IntentUtil.goToContext(getActivity(), HairStyleImg_Activity.class);
    }
}
