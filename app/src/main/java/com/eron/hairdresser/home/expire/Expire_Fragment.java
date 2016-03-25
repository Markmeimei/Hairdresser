package com.eron.hairdresser.home.expire;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class Expire_Fragment extends Fragment {

    @Bind(R.id.fragment_expire_ListView)
    ListView fragmentExpireListView;

    private View view;
    private Expire_Activity_ListView_Adapter listView_adapter;

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
        List<Expire_Model> modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Expire_Model expire = new Expire_Model();
            expire.setName(i + "");
            expire.setPhone(i * i * i * i + "");
            expire.setCardNumber("12374567");
            expire.setType("烫发");
            modelList.add(expire);
        }
        listView_adapter = new Expire_Activity_ListView_Adapter(getActivity(), modelList);
        Content();
    }

    private void Content() {
        fragmentExpireListView.setAdapter(listView_adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_expire_ListView)
    public void onItemClick(int position) {
        Toast_Common.DefaultToast(getActivity(), position + "");
    }
}
