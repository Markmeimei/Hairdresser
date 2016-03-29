package com.eron.hairdresser.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Details_Activity_ListView_Adapter;
import com.eron.hairdresser.adapter.Details_Activity_ListView_Adapter02;
import com.eron.hairdresser.adapter.Details_Activity_ListView_Adapter03;
import com.eron.hairdresser.common.IntentTag;
import com.eron.hairdresser.customer.SPA.SPA_Activity;
import com.eron.hairdresser.customer.nutrition.Nutrition_Activity;
import com.eron.hairdresser.customer.permDye.PermDye_Activity;
import com.eron.hairdresser.model.Customer_Model;
import com.eron.hairdresser.model.Nutrition_Model;
import com.eron.hairdresser.model.PermDye_Model;
import com.eron.hairdresser.model.SPA_Model;
import com.eron.hairdresser.views.Views;
import com.eron.hairdresser.views.headTitle.HeadTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class Details_Activity extends AppCompatActivity {

    @Bind(R.id.activity_details_HeadTitle)
    HeadTitle activityDetailsHeadTitle;
    @Bind(R.id.fragment_customer_ListView)
    ListView fragmentCustomerListView;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        intent = getIntent();

        List<Customer_Model> modelList = new ArrayList<>();
        Customer_Model model = new Customer_Model();
        model.setName("林炜智");
        model.setCardNumber("1111111111");
        model.setCardVariety(1);
        model.setBirthday("2016.3.16");
        model.setGender("男");
        model.setHairLength("短");
        model.setPhone("18888888888");

        if (intent.getStringExtra(IntentTag.DetailsTag).equals(PermDye_Activity.Tag)) {
            List<PermDye_Model> list1 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                PermDye_Model model1 = new PermDye_Model();
                model1.setDate("2016.3.16");
                model1.setProject("烫发");
                model1.setHairstylistName("林炜智");
                model1.setProduct("欧莱雅");
                model1.setSatisfaction("优");
                model1.setProduct("高");
                model1.setType("热");
                model1.setShow(false);
                list1.add(model1);
            }
            model.setPermDye_models(list1);
            modelList.add(model);
            Details_Activity_ListView_Adapter listView_adapter = new Details_Activity_ListView_Adapter(this, modelList.get(0).getPermDye_models());
            fragmentCustomerListView.addHeaderView(Views.getDetailsFirst(this, modelList));
            fragmentCustomerListView.setAdapter(listView_adapter);
        } else if (intent.getStringExtra(IntentTag.DetailsTag).equals(Nutrition_Activity.Tag)) {
            List<Nutrition_Model> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Nutrition_Model model1 = new Nutrition_Model();
                model1.setDate("2016.3.16");
                model1.setProject("营养");
                model1.setProduct("欧莱雅ss");
                model1.setProduct2("欧莱雅ss");
                model1.setFurnishing("dsadsass");
                model1.setStoresUse("dsadsass");
                model1.setDiagnosis("dsadsass");
                model1.setShow(false);
                list.add(model1);
            }
            model.setNutrition_models(list);
            modelList.add(model);
            Details_Activity_ListView_Adapter02 listView_adapter02 = new Details_Activity_ListView_Adapter02(this, modelList.get(0).getNutrition_models());
            fragmentCustomerListView.addHeaderView(Views.getDetailsFirst(this, modelList));
            fragmentCustomerListView.setAdapter(listView_adapter02);
        } else if (intent.getStringExtra(IntentTag.DetailsTag).equals(SPA_Activity.Tag)) {
            List<SPA_Model> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                SPA_Model model1 = new SPA_Model();
                model1.setDate("2016.3.16");
                model1.setProject("头皮SPA");
                model1.setMask("欧莱雅ss");
                model1.setAssistant("小李");
                model1.setAppointmentTime("时间");
                model1.setAppointmentPerson("林炜智");
                model1.setSignature("图片");
                model1.setShow(false);
                list.add(model1);
            }
            model.setSpa_models(list);
            modelList.add(model);
            Details_Activity_ListView_Adapter03 listView_adapter03 = new Details_Activity_ListView_Adapter03(this, modelList.get(0).getSpa_models());
            fragmentCustomerListView.addHeaderView(Views.getDetailsFirst(this, modelList));
            fragmentCustomerListView.setAdapter(listView_adapter03);
        }
        Content();
    }

    private void Content() {

    }

    @OnItemClick(R.id.fragment_customer_ListView)
    public void onItemClick() {
    }
}
