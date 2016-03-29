package com.eron.hairdresser.hairdresser.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.eron.hairdresser.R;


/**
 * Author：Mark
 * Date：2016/2/19 0019
 * Tell：15006330640
 *
 * 关于我们
 *
 */
public class AboutActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_about);
        findView();
        initView();
    }

    private void findView() {
    }

    private void initView() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
}
