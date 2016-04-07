package com.eron.hairdresser.hairdresser;

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

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.AccountBook_Fragment_ListView_Adapter;
import com.eron.hairdresser.adapter.Expire_Fragment_ListView_Adapter;
import com.eron.hairdresser.addform.AddForm_Activity;
import com.eron.hairdresser.model.Expire_Model;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by 林炜智 on 2016/3/31.
 */
public class AccountBook_Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    public final static String Tag = "AccountBook_Fragment";

    @Bind(R.id.fragment_account_book_ListView)
    ListView fragmentAccountBookListView;
    @Bind(R.id.fragment_account_book_SwipeRefreshLayout)
    SwipeRefreshLayout fragmentAccountBookSwipeRefreshLayout;

    private View view;
    private AccountBook_Fragment_ListView_Adapter listView_adapter;
    private List<Expire_Model> modelList;
    private Handler handler;
    private Map<String, String> map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_account_book, container, false);
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
        map = new HashMap<>();
        handler = new Handler();
        modelList = new ArrayList<>();
        listView_adapter = new AccountBook_Fragment_ListView_Adapter(getActivity(), modelList);
        Content();
    }

    private void Content() {
        fragmentAccountBookListView.setAdapter(listView_adapter);
        fragmentAccountBookSwipeRefreshLayout.setColorSchemeResources(R.color.adapter_birthday_activity_listview_checkbox01,
                R.color.adapter_birthday_activity_listview_checkbox02, R.color.adapter_birthday_activity_listview_checkbox03);
        fragmentAccountBookSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @OnItemClick(R.id.fragment_account_book_ListView)
    public void onItemClick(int position) {
        IntentUtil.goToContext(getActivity(), AddForm_Activity.class, Tag, Tag);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                modelList.clear();
                fragmentAccountBookSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this); 会导致下拉刷新控件空指针异常
    }
}
