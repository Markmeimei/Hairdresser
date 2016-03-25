package com.eron.hairdresser.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.views.PaintView;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Author：Mark
 * Date：2016/3/24 0024
 * Tell：15006330640
 */
public class Dialog_Sign {
    private Display display;
    private Dialog dialog;
    private Context context;
    private PaintView paintView;
    private String path = Environment.getExternalStorageDirectory().getPath()
            + "/HairDresser/sign/"; // 图片地址
    //
    private RelativeLayout dialogBg;
    private TextView dialogTx;
    private FrameLayout dialogFl;
    private Button dialogBtnConfirm;
    private Button dialogBtnCancel;


    public Dialog_Sign(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public Dialog_Sign builder() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_sign, null);

        dialogBg = (RelativeLayout) view.findViewById(R.id.dialog_bg);
        dialogTx = (TextView) view.findViewById(R.id.dialog_tx);
        dialogFl = (FrameLayout) view.findViewById(R.id.dialog_fl);
        dialogBtnConfirm = (Button) view.findViewById(R.id.dialog_btn_confirm);
        dialogBtnCancel = (Button) view.findViewById(R.id.dialog_btn_cancel);

        paintView = new PaintView(context.getApplicationContext(), display.getWidth(),
                display.getHeight() / 7 * 6);
        dialogFl.addView(paintView);

        dialog = new Dialog(context,R.style.DialogStyle);
        dialog.setContentView(view);

        // 调整dialog背景大小
        dialogBg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));

        return this;
    }
    public Dialog_Sign setTitle(String title) {
        if ("".equals(title)) {
            dialogTx.setText("标题");
        } else {
            dialogTx.setText(title);
        }
        return this;
    }
    public Dialog_Sign setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public Dialog_Sign setPositiveButton(String text,
                                         final View.OnClickListener listener) {
        if ("".equals(text)) {
            dialogBtnConfirm.setText("确定");
        } else {
            dialogBtnConfirm.setText(text);
        }
        dialogBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(path);
                if (!file.exists())
                    file.mkdirs();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file.getPath() + "/customer_sign.jpg");
                    paintView.getCachebBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                    System.out.println("saveBmp is here");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }
    public void show() {
        dialog.show();
    }
}
