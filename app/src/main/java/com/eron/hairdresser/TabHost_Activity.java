package com.eron.hairdresser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eron.hairdresser.addform.AddForm_Activity;
import com.eron.hairdresser.customer.Customer_Fragment;
import com.eron.hairdresser.hairdresser.Hairdresser_Fragment;
import com.eron.hairdresser.home.Home_Fragment;
import com.eron.hairdresser.read.Read_Fragment;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabHost_Activity extends AppCompatActivity {
    //容器
    @Bind(R.id.activity_tabhost_Content)
    FrameLayout activityTabhostContent;
    //首页
    @Bind(R.id.include_tab_button_Home_image)
    ImageView includeTabButtonHomeImage;
    @Bind(R.id.include_tab_button_Home_text)
    TextView includeTabButtonHomeText;
    @Bind(R.id.include_tab_button_Home)
    LinearLayout includeTabButtonHome;
    //顾客
    @Bind(R.id.include_tab_button_Customer_image)
    ImageView includeTabButtonCustomerImage;
    @Bind(R.id.include_tab_button_Customer_text)
    TextView includeTabButtonCustomerText;
    @Bind(R.id.include_tab_button_Customer)
    LinearLayout includeTabButtonCustomer;
    //阅读
    @Bind(R.id.include_tab_button_Read_image)
    ImageView includeTabButtonReadImage;
    @Bind(R.id.include_tab_button_Read_text)
    TextView includeTabButtonReadText;
    @Bind(R.id.include_tab_button_Read)
    LinearLayout includeTabButtonRead;
    //发型师
    @Bind(R.id.include_tab_button_Hairdresser_image)
    ImageView includeTabButtonHairdresserImage;
    @Bind(R.id.include_tab_button_Hairdresser_text)
    TextView includeTabButtonHairdresserText;
    @Bind(R.id.include_tab_button_Hairdresser)
    LinearLayout includeTabButtonHairdresser;

    //加号
    @Bind(R.id.include_tab_button_Hairdresser_ImageView)
    ImageView includeTabButtonHairdresserImageView;

    private Fragment[] fragments;
    private ImageView[] imageViews;
    private TextView[] textViews;

    private Home_Fragment homeFragment;     //首页
    private Customer_Fragment customerFragment;     //顾客
    private Read_Fragment readFragment;     //阅读
    private Hairdresser_Fragment hairdresserFragment;       //发型师

    private int index;
    private int fragment_index;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        ButterKnife.bind(this);
        Init();
    }

    private void Init() {
        this.homeFragment = new Home_Fragment();
        this.customerFragment = new Customer_Fragment();
        this.readFragment = new Read_Fragment();
        this.hairdresserFragment = new Hairdresser_Fragment();
        Content();
    }

    private void Content() {
        fragments = new Fragment[]{homeFragment, customerFragment, readFragment, hairdresserFragment};
        imageViews = new ImageView[]{includeTabButtonHomeImage, includeTabButtonCustomerImage, includeTabButtonReadImage, includeTabButtonHairdresserImage};
        textViews = new TextView[]{includeTabButtonHomeText, includeTabButtonCustomerText, includeTabButtonReadText, includeTabButtonHairdresserText};

        imageViews[0].setSelected(true);
        textViews[0].setTextColor(getResources().getColor(R.color.tab_text_background_color_down));
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_tabhost_Content, homeFragment)
                .add(R.id.activity_tabhost_Content, customerFragment)
                .add(R.id.activity_tabhost_Content, readFragment)
                .add(R.id.activity_tabhost_Content, hairdresserFragment)
                .hide(customerFragment).hide(readFragment).hide(hairdresserFragment)
                .show(homeFragment).commit();
    }

    @OnClick({R.id.include_tab_button_Home, R.id.include_tab_button_Customer, R.id.include_tab_button_Read, R.id.include_tab_button_Hairdresser, R.id.include_tab_button_Hairdresser_ImageView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.include_tab_button_Home:
                index = 0;
                break;
            case R.id.include_tab_button_Customer:
                index = 1;
                break;
            case R.id.include_tab_button_Read:
                index = 2;
                break;
            case R.id.include_tab_button_Hairdresser:
                index = 3;
                break;
            case R.id.include_tab_button_Hairdresser_ImageView:
                IntentUtil.goToContext(this, AddForm_Activity.class);
                break;
        }
        if (fragment_index != index) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragments[fragment_index]);
            if (!fragments[index].isAdded()) {
                transaction.add(R.id.activity_tabhost_Content, fragments[index]);
            }
            transaction.show(fragments[index]).commit();
        }
        imageViews[fragment_index].setSelected(false);
        imageViews[index].setSelected(true);
        textViews[fragment_index].setTextColor(getResources().getColor(R.color.tab_text_background_color_up));
        textViews[index].setTextColor(getResources().getColor(R.color.tab_text_background_color_down));
        fragment_index = index;
    }

    /**
     * 退出应用
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                // 判断2次点击事件时间
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    Toast_Common.CenterToast(this, "再按一次退出程序");
                    exitTime = System.currentTimeMillis();
                } else {
                    moveTaskToBack(false);
                    finish();
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
