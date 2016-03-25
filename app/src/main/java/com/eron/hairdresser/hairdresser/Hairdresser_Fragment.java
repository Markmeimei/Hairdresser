package com.eron.hairdresser.hairdresser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Hairdresser_Fragment_ListView_Adapter;
import com.eron.hairdresser.hairdresser.setting.Setting_Activity;
import com.eron.hairdresser.views.Views;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 *
 */
public class Hairdresser_Fragment extends Fragment {

    @Bind(R.id.fragment_hairdresser_ListView)
    ListView fragmentHairdresserListView;
    @Bind(R.id.fragment_hairdresser_HeadTitle)
    HeadTitle fragmentHairdresserHeadTitle;

    private View view;
    private Hairdresser_Fragment_ListView_Adapter listView_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_hairdresser, container, false);
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
        List<String> strings = new ArrayList<>();
        strings.add("业绩查询");
        strings.add("业绩规划");
        strings.add("数据分析");
        listView_adapter = new Hairdresser_Fragment_ListView_Adapter(getActivity(), strings);
        Content();
    }

    private void Content() {
        fragmentHairdresserListView.addHeaderView(Views.getHairdresserFirst(getActivity(), "我的流水单"));
        fragmentHairdresserHeadTitle.setRightOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.goToContext(getActivity(), Setting_Activity.class);
            }
        });
        fragmentHairdresserListView.setAdapter(listView_adapter);
    }

    @OnItemClick(R.id.fragment_hairdresser_ListView)
    public void onItemClick(int position) {
        Toast_Common.CenterToast(getActivity(), position + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
