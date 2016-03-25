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

public class NewNutrition_Fragment extends Fragment {

    @Bind(R.id.fragment_new_nutrition_Nutrition)
    TextView fragmentNewNutritionNutrition;
    @Bind(R.id.fragment_new_nutrition_ThisTime)
    TextView fragmentNewNutritionThisTime;
    @Bind(R.id.fragment_new_nutrition_Diagnosis)
    EditText fragmentNewNutritionDiagnosis;
    @Bind(R.id.fragment_new_nutrition_Stylist)
    TextView fragmentNewNutritionStylist;
    @Bind(R.id.fragment_new_nutrition_Product)
    TextView fragmentNewNutritionProduct;
    @Bind(R.id.fragment_new_nutrition_NextTime)
    TextView fragmentNewNutritionNextTime;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new_nutrition, container, false);
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
