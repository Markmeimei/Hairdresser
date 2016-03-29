package com.eron.hairdresser.hairdresser.setting;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.eron.hairdresser.R;
import com.eron.hairdresser.views.dialog.ECProgressDialog;

import butterknife.Bind;

/**
 * Author：Mark
 * Date：2016/2/19 0019
 * Tell：15006330640
 *
 *  建议反馈
 */
public class FeedbackActivity extends Activity {
    @Bind(R.id.feedback_input)
    EditText feedbackInput;
    //
    private SharedPreferences preferences;
    private Context context = FeedbackActivity.this;
    private ECProgressDialog mPostingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_feedback);
        findView();
        initView();
    }

    private void findView() {
    }

    private void initView() {
    }

    // 检测输入
    private boolean checkInput() {
        if (feedbackInput.getText().toString() == null || feedbackInput.getText().toString().equals("")) {
            Toast.makeText(FeedbackActivity.this, getString(R.string.setting_feedback_opinion), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void dismissPostingDialog() {
        if (mPostingDialog == null || !mPostingDialog.isShowing()) {
            return;
        }
        mPostingDialog.dismiss();
        mPostingDialog = null;
    }

}
