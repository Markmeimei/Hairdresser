package com.eron.hairdresser.home.expire;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Expire_Activity_ListView_Adapter;
import com.eron.hairdresser.model.Expire_Model;
import com.lin.framwork.application.ApplicationTools;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class Expire_Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    public final static String Tag = "Expire_Fragment";

    @Bind(R.id.fragment_expire_ListView)
    ListView fragmentExpireListView;
    @Bind(R.id.fragment_expire_SwipeRefreshLayout)
    SwipeRefreshLayout fragmentExpireSwipeRefreshLayout;

    private View view;
    private Expire_Activity_ListView_Adapter listView_adapter;
    private List<Expire_Model> modelList = new ArrayList<>();


    private Handler handler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_expire, container, false);
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
        listView_adapter = new Expire_Activity_ListView_Adapter(getActivity(), modelList);
        Content();
    }

    private void Content() {
        fragmentExpireListView.setAdapter(listView_adapter);
        fragmentExpireSwipeRefreshLayout.setColorSchemeResources(R.color.adapter_birthday_activity_listview_checkbox01,
                R.color.adapter_birthday_activity_listview_checkbox02, R.color.adapter_birthday_activity_listview_checkbox03);
        fragmentExpireSwipeRefreshLayout.setOnRefreshListener(this);
        getData();
    }

    private void getData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", ApplicationTools.getUser().getObject().getId());
        new VolleyUtil<>().post(ConfigUrl.Expire_FragmentUrl, Expire_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                modelList.addAll(list);
                listView_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(VolleyError error) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_expire_ListView)
    public void onItemClick(int position) {
        showDialog(position);
    }

    private void showDialog(final int position) {
        String[] AlertDialogItems = new String[]{"打电话", "发短信"};
        new AlertDialog.Builder(getActivity()).setTitle("请选择").setItems(AlertDialogItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast_Common.DefaultToast(getActivity(), "打电话" + position);
                        break;
                    case 1:
                        Toast_Common.DefaultToast(getActivity(), "发短信" + position);
                        break;
                }
            }
        }).show();
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                modelList.clear();
                getData();
                fragmentExpireSwipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}
