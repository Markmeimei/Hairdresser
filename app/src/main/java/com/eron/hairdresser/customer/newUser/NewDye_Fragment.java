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

public class NewDye_Fragment extends Fragment {
    @Bind(R.id.fragment_new_dye_Dye)
    TextView fragmentNewDyeDye;
    @Bind(R.id.fragment_new_dye_ProjectName)
    TextView fragmentNewDyeProjectName;
    @Bind(R.id.fragment_new_dye_Money)
    EditText fragmentNewDyeMoney;
    @Bind(R.id.fragment_new_dye_StartTime)
    TextView fragmentNewDyeStartTime;
    @Bind(R.id.fragment_new_dye_FinishTime)
    TextView fragmentNewDyeFinishTime;
    @Bind(R.id.fragment_new_dye_WhiteHairScale)
    TextView fragmentNewDyeWhiteHairScale;
    @Bind(R.id.fragment_new_dye_Bleach)
    TextView fragmentNewDyeBleach;
    @Bind(R.id.fragment_new_dye_HairColor)
    TextView fragmentNewDyeHairColor;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new_dye, container, false);
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
