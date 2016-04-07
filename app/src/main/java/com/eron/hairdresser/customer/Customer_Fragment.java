package com.eron.hairdresser.customer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Customer_Fragment_GridView_Adapter;
import com.eron.hairdresser.customer.SPA.SPA_Activity;
import com.eron.hairdresser.customer.hairdressing.Hairdressing_Activity;
import com.eron.hairdresser.customer.newUser.NewUser_Activity;
import com.eron.hairdresser.customer.nutrition.Nutrition_Activity;
import com.eron.hairdresser.customer.permDye.PermDye_Activity;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * 顾客界面
 */
public class Customer_Fragment extends Fragment {

    @Bind(R.id.fragment_customer_HeadTitle)
    HeadTitle fragmentCustomerHeadTitle;
    @Bind(R.id.fragment_customer_GridView)
    GridView fragmentCustomerGridView;

    private View view;
    private Customer_Fragment_GridView_Adapter girdView_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_customer, container, false);
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
        girdView_adapter = new Customer_Fragment_GridView_Adapter(getActivity());
        Content();
    }

    private void Content() {
        fragmentCustomerHeadTitle.setRightOnclick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.goToContext(getActivity(), NewUser_Activity.class);
            }
        });
        fragmentCustomerGridView.setAdapter(girdView_adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_customer_GridView)
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                IntentUtil.goToContext(getActivity(), PermDye_Activity.class);
                break;
            case 1:
                IntentUtil.goToContext(getActivity(), Nutrition_Activity.class);
                break;
            case 2:
                IntentUtil.goToContext(getActivity(), SPA_Activity.class);
                break;
            case 3:
//                IntentUtil.goToContext(getActivity(), Hairdressing_Activity.class);
                break;
        }
    }
}
