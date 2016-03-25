package com.eron.hairdresser.addform;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.views.dialog.Dialog_Sign;
import com.eron.hairdresser.views.headTitle.HeadTitle;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddForm_Activity extends AppCompatActivity {

    @Bind(R.id.fragment_home_HeadTitle)
    HeadTitle fragmentHomeHeadTitle;
    @Bind(R.id.activity_add_form_Smallicon01)
    ImageView activityAddFormSmallicon01;
    @Bind(R.id.activity_add_form_Phone)
    TextView activityAddFormPhone;
    @Bind(R.id.activity_add_form_RadioButton11_Up)
    RadioButton activityAddFormRadioButton11Up;
    @Bind(R.id.activity_add_form_RadioButton12_Up)
    RadioButton activityAddFormRadioButton12Up;
    @Bind(R.id.activity_add_form_RadioButton13_Up)
    RadioButton activityAddFormRadioButton13Up;
    @Bind(R.id.activity_add_form_RadioGroup01_Up)
    RadioGroup activityAddFormRadioGroup01Up;
    @Bind(R.id.activity_add_form_EditText01)
    EditText activityAddFormEditText01;
    @Bind(R.id.activity_add_form_LinearLayout_For_EditText01)
    LinearLayout activityAddFormLinearLayoutForEditText01;
    @Bind(R.id.activity_add_form_RadioButton21_Up)
    RadioButton activityAddFormRadioButton21Up;
    @Bind(R.id.activity_add_form_RadioButton22_Up)
    RadioButton activityAddFormRadioButton22Up;
    @Bind(R.id.activity_add_form_RadioButton23_Up)
    RadioButton activityAddFormRadioButton23Up;
    @Bind(R.id.activity_add_form_RadioGroup02_Up)
    RadioGroup activityAddFormRadioGroup02Up;
    @Bind(R.id.activity_add_form_EditText02)
    EditText activityAddFormEditText02;
    @Bind(R.id.activity_add_form_LinearLayout_For_EditText02)
    LinearLayout activityAddFormLinearLayoutForEditText02;
    @Bind(R.id.activity_add_form_Stylist)
    TextView activityAddFormStylist;
    @Bind(R.id.activity_add_form_Type01)
    TextView activityAddFormType01;
    @Bind(R.id.activity_add_form_Hairdressing)
    TextView activityAddFormHairdressing;
    @Bind(R.id.activity_add_form_Type02)
    TextView activityAddFormType02;
    @Bind(R.id.activity_add_form_PermDye)
    TextView activityAddFormPermDye;
    @Bind(R.id.activity_add_form_Type03)
    TextView activityAddFormType03;
    @Bind(R.id.activity_add_form_Money)
    TextView activityAddFormMoney;
    @Bind(R.id.activity_add_form_TakeOut)
    TextView activityAddFormTakeOut;
    @Bind(R.id.activity_add_form_Cost)
    TextView activityAddFormCost;
    @Bind(R.id.activity_add_form_Practical)
    TextView activityAddFormPractical;
    @Bind(R.id.activity_add_form_Cashier)
    TextView activityAddFormCashier;
    @Bind(R.id.activity_add_form_Manager)
    TextView activityAddFormManager;
    @Bind(R.id.activity_add_form_Remark)
    EditText activityAddFormRemark;
    @Bind(R.id.activity_add_form_RadioButton11_Down)
    RadioButton activityAddFormRadioButton11Down;
    @Bind(R.id.activity_add_form_RadioButton12_Down)
    RadioButton activityAddFormRadioButton12Down;
    @Bind(R.id.activity_add_form_RadioButton13_Down)
    RadioButton activityAddFormRadioButton13Down;
    @Bind(R.id.activity_add_form_RadioGroup01_Down)
    RadioGroup activityAddFormRadioGroup01Down;
    @Bind(R.id.activity_add_form_RadioButton21_Down)
    RadioButton activityAddFormRadioButton21Down;
    @Bind(R.id.activity_add_form_RadioButton22_Down)
    RadioButton activityAddFormRadioButton22Down;
    @Bind(R.id.activity_add_form_RadioButton23_Down)
    RadioButton activityAddFormRadioButton23Down;
    @Bind(R.id.activity_add_form_RadioGroup11_Down)
    RadioGroup activityAddFormRadioGroup11Down;
    @Bind(R.id.activity_add_form_Submit)
    Button activityAddFormSubmit;
    @Bind(R.id.activity_add_form_Add)
    ImageView activityAddFormAdd;
    @Bind(R.id.activity_add_form_TextView01)
    TextView activityAddFormTextView01;
    @Bind(R.id.activity_add_form_ImageView)
    ImageView activityAddFormImageView;
    @Bind(R.id.add_customer_sign)
    RelativeLayout addCustomerSign;

    private Context context;
    private String path = Environment.getExternalStorageDirectory().getPath()
            + "/HairDresser/sign/"; // 图片地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        ButterKnife.bind(this);
        initConstants();
    }

    private void initConstants() {
        context = this;
    }

    @OnClick({R.id.activity_add_form_Add, R.id.activity_add_form_Smallicon01, R.id.activity_add_form_RadioButton11_Up, R.id.activity_add_form_RadioButton12_Up,
            R.id.activity_add_form_RadioButton13_Up, R.id.activity_add_form_RadioGroup01_Up, R.id.activity_add_form_EditText01,
            R.id.activity_add_form_LinearLayout_For_EditText01, R.id.activity_add_form_RadioButton21_Up, R.id.activity_add_form_RadioButton22_Up,
            R.id.activity_add_form_RadioButton23_Up, R.id.activity_add_form_RadioGroup02_Up, R.id.activity_add_form_EditText02,
            R.id.activity_add_form_LinearLayout_For_EditText02, R.id.activity_add_form_Stylist, R.id.activity_add_form_Type01,
            R.id.activity_add_form_Hairdressing, R.id.activity_add_form_Type02, R.id.activity_add_form_PermDye, R.id.activity_add_form_Type03,
            R.id.activity_add_form_Money, R.id.activity_add_form_TakeOut, R.id.activity_add_form_Cost, R.id.activity_add_form_Practical,
            R.id.activity_add_form_Cashier, R.id.activity_add_form_Manager, R.id.activity_add_form_Submit, R.id.activity_add_form_TextView01,R.id.add_customer_sign})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_add_form_Smallicon01:
                break;
            case R.id.activity_add_form_RadioButton11_Up:
                break;
            case R.id.activity_add_form_RadioButton12_Up:
                break;
            case R.id.activity_add_form_RadioButton13_Up:
                break;
            case R.id.activity_add_form_RadioGroup01_Up:
                break;
            case R.id.activity_add_form_EditText01:
                break;
            case R.id.activity_add_form_LinearLayout_For_EditText01:
                break;
            case R.id.activity_add_form_RadioButton21_Up:
                break;
            case R.id.activity_add_form_RadioButton22_Up:
                break;
            case R.id.activity_add_form_RadioButton23_Up:
                break;
            case R.id.activity_add_form_RadioGroup02_Up:
                break;
            case R.id.activity_add_form_EditText02:
                break;
            case R.id.activity_add_form_LinearLayout_For_EditText02:
                break;
            case R.id.activity_add_form_Stylist:
                break;
            case R.id.activity_add_form_Type01:
                break;
            case R.id.activity_add_form_Hairdressing:
                break;
            case R.id.activity_add_form_Type02:
                break;
            case R.id.activity_add_form_PermDye:
                break;
            case R.id.activity_add_form_Type03:
                break;
            case R.id.activity_add_form_Money:
                break;
            case R.id.activity_add_form_TakeOut:
                break;
            case R.id.activity_add_form_Cost:
                break;
            case R.id.activity_add_form_Practical:
                break;
            case R.id.activity_add_form_Cashier:
                break;
            case R.id.activity_add_form_Manager:
                break;
            case R.id.activity_add_form_Submit:
                break;
            case R.id.activity_add_form_Add:
                break;
            case R.id.activity_add_form_TextView01:

                break;
            case R.id.add_customer_sign:
                // 顾客签名
                new Dialog_Sign(context)
                        .builder()
                        .setCancelable(false)
                        .setTitle("手写签名")
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showSign();
                            }
                        })
                        .show();
                break;
        }
    }

    public void showSign() {
        File file = new File(path + "customer_sign.jpg");
        if (file.exists()) {
            Log.e("显示照片",path);
            activityAddFormImageView.setImageBitmap(BitmapFactory.decodeFile(path + "customer_sign.jpg"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        showSign();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        File file = new File(path + "customer_sign.jpg");
        file.delete();
    }
}
