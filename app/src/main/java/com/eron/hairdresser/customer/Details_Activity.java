package com.eron.hairdresser.customer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Details_Activity_ListView_Adapter;
import com.eron.hairdresser.model.Customer_Model;
import com.eron.hairdresser.model.PersonalRecord_Model;
import com.eron.hairdresser.views.Views;
import com.eron.hairdresser.views.headTitle.HeadTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class Details_Activity extends AppCompatActivity {

    @Bind(R.id.activity_details_HeadTitle)
    HeadTitle activityDetailsHeadTitle;
    @Bind(R.id.fragment_customer_ListView)
    ListView fragmentCustomerListView;

    private Details_Activity_ListView_Adapter listView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        List<Customer_Model> modelList = new ArrayList<>();
        Customer_Model model = new Customer_Model();
        model.setName("林炜智");
        model.setCardNumber("1111111111");
        model.setCardVariety(1);
        model.setBirthday("2016.3.16");
        model.setGender("男");
        model.setHairLength("短");
        List<PersonalRecord_Model> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            PersonalRecord_Model model1 = new PersonalRecord_Model();
            model1.setDate("2016.3.16");
            model1.setProject("烫发");
            model1.setHairstylistName("林炜智");
            model1.setProduct("欧莱雅");
            model1.setSatisfaction("优");
            model1.setProduct("高");
            model1.setType("热");
            model1.setShow(false);
            list.add(model1);
        }
        model.setList(list);
        modelList.add(model);
        listView_adapter = new Details_Activity_ListView_Adapter(this, modelList.get(0).getList());
        fragmentCustomerListView.addHeaderView(Views.getDetailsFirst(this, modelList));
        Content();
    }

    private void Content() {
        fragmentCustomerListView.setAdapter(listView_adapter);
    }

    @OnItemClick(R.id.fragment_customer_ListView)
    public void onItemClick() {
    }
}
