package com.eron.hairdresser.home.subscribe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Expire_Activity_ListView_Adapter;
import com.eron.hairdresser.model.Expire_Model;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class Subscribe_Fragment extends Fragment {

    @Bind(R.id.fragment_subscribe_ListView)
    ListView fragmentSubscribeListView;

    private View view;
    private Expire_Activity_ListView_Adapter listView_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_subscribe, container, false);
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
        List<Expire_Model> modelList = new ArrayList<>();
        listView_adapter = new Expire_Activity_ListView_Adapter(getActivity(), modelList);
        Content();
    }

    private void Content() {
        fragmentSubscribeListView.setAdapter(listView_adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_subscribe_ListView)
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
}
