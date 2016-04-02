package com.eron.hairdresser.home.expire;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Expire_Fragment_ListView_Adapter;
import com.eron.hairdresser.model.Birthday_Model;
import com.eron.hairdresser.model.Expire_Model;
import com.google.gson.Gson;
import com.lin.framwork.application.ApplicationTools;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.IntentUtil;
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
    private Expire_Fragment_ListView_Adapter listView_adapter;
    private List<Expire_Model.ObjectBean> modelList;
    private Handler handler;
    private Map<String, String> map;

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
        return view;
    }

    private void Init() {
        map = new HashMap<String, String>();
        handler = new Handler();
        modelList = new ArrayList<>();
        listView_adapter = new Expire_Fragment_ListView_Adapter(getActivity(), modelList);
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
        map.put("uid", ApplicationTools.getUser().getObject().getId());
        new VolleyUtil<>().post(ConfigUrl.Expire_FragmentUrl, Expire_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                Expire_Model model = new Gson().fromJson(result, Expire_Model.class);
                modelList.addAll(model.getObject());
                listView_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(getActivity(), "网络请求失败，请检查网络");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);   会导致下拉刷新控件空指针异常
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
                        IntentUtil.dialPhones(getActivity(), modelList.get(position).getPhone());
                        break;
                    case 1:
                        IntentUtil.sendMessage(getActivity(), modelList.get(position).getPhone(), "");
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
        }, 1000);
    }
}
