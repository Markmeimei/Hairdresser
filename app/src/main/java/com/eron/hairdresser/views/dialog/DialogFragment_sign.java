//package com.eron.hairdresser.views.dialog;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.os.Environment;
//import android.support.v4.app.DialogFragment;
//import android.view.Display;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.eron.hairdresser.R;
//import com.eron.hairdresser.views.PaintView;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//
//@SuppressLint("ValidFragment")
//public class DialogFragment_sign extends DialogFragment {
//    // View
//    View view;
//    // Ui
//
//    String url;
//    String status;
//    @Bind(R.id.linearLayout4)
//    LinearLayout linearLayout4;
//    private PaintView paintView;
//    private Display display;
//    private String path = Environment.getExternalStorageDirectory().getPath()
//            + "/HairDresser/sign/"; // 图片地址
//
//    public DialogFragment_sign() {
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.dialog_sign, null);
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        ButterKnife.bind(this, view);
//        initConstants();
//        initView();
//        return view;
//    }
//
//    private void initConstants() {
//        WindowManager windowManager = (WindowManager) getActivity()
//                .getSystemService(Context.WINDOW_SERVICE);
//        display = windowManager.getDefaultDisplay();
//    }
//
//
//    public void initView() {
//        tvTitlehand.setText("手写签名");
//        paintView = new PaintView(getActivity().getApplicationContext(), display.getWidth(),
//                display.getHeight() / 7 * 6);
//        flSign.addView(paintView);
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Window window = getDialog().getWindow();
//        window.setLayout(display.getWidth(),
//                display.getHeight() / 4 * 3);
//        window.setGravity(Gravity.CENTER);
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ButterKnife.unbind(this);
//    }
//
//    @OnClick({R.id.btn_ok, R.id.btn_cancel})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_ok:
//                File file = new File(path);
//                if (!file.exists())
//                    file.mkdirs();
//                try {
//                    FileOutputStream fileOutputStream = new FileOutputStream(file.getPath() + "/customer_sign.jpg");
//                    paintView.getCachebBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
//                    fileOutputStream.close();
//                    System.out.println("saveBmp is here");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                dismiss();
//                break;
//            case R.id.btn_cancel:
//                dismiss();
//                break;
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//}
