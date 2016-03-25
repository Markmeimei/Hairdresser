package com.eron.hairdresser.customer.newUser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eron.hairdresser.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewStaff_Fragment extends Fragment {

    @Bind(R.id.fragment_new_staff_WaiterData)
    TextView fragmentNewStaffWaiterData;
    @Bind(R.id.fragment_new_staff_CompanyName)
    TextView fragmentNewStaffCompanyName;
    @Bind(R.id.fragment_new_staff_Cashier)
    TextView fragmentNewStaffCashier;
    @Bind(R.id.fragment_new_staff_Hairdresser)
    TextView fragmentNewStaffHairdresser;
    @Bind(R.id.fragment_new_staff_Technician)
    TextView fragmentNewStaffTechnician;
    @Bind(R.id.fragment_new_staff_Assistant)
    TextView fragmentNewStaffAssistant;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new_staff, container, false);
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
}
