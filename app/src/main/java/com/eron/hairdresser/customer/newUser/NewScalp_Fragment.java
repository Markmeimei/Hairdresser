package com.eron.hairdresser.customer.newUser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.eron.hairdresser.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewScalp_Fragment extends Fragment {

    @Bind(R.id.fragment_new_scalp_Scalp)
    TextView fragmentNewScalpScalp;
    @Bind(R.id.fragment_new_scalp_ThisTiem)
    TextView fragmentNewScalpThisTiem;
    @Bind(R.id.fragment_new_scalp_Diagnosis)
    EditText fragmentNewScalpDiagnosis;
    @Bind(R.id.fragment_new_scalp_Stylist)
    EditText fragmentNewScalpStylist;
    @Bind(R.id.fragment_new_scalp_Assistant)
    EditText fragmentNewScalpAssistant;
    @Bind(R.id.fragment_new_scalp_Product)
    EditText fragmentNewScalpProduct;
    @Bind(R.id.fragment_new_scalp_NextTime)
    EditText fragmentNewScalpNextTime;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new_scalp, container, false);
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
