package com.eron.hairdresser.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.eron.hairdresser.R;

/**
 * Created by 林炜智 on 2016/3/14.
 */
public class EditDialog extends Dialog {
    public EditDialog(Context context) {
        super(context);
    }

    public EditDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context context;
        private String title, message, positiveButtonText, negativeButtonText;

        private DialogInterface.OnClickListener positiveButtonClickListener, negativeButtonClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveButtonText = (String) context
                    .getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeButtonText = (String) context
                    .getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public EditDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final EditDialog dialog = new EditDialog(context, R.style.Dialog);
            View view = inflater.inflate(R.layout.views_edit_dialog, null);
            dialog.addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            ((TextView) view.findViewById(R.id.views_edit_dialog_Title)).setText(title);

            if (positiveButtonText != null) {
                ((Button) view.findViewById(R.id.views_edit_dialog_Positive)).setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    ((Button) view.findViewById(R.id.views_edit_dialog_Positive)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            positiveButtonClickListener.onClick(dialog,
                                    DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }
            }

            if (negativeButtonText != null) {
                ((Button) view.findViewById(R.id.views_edit_dialog_Negative)).setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    ((Button) view.findViewById(R.id.views_edit_dialog_Negative)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            negativeButtonClickListener.onClick(dialog,
                                    DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
            }
            // set the content message
            if (message != null) {
                ((TextView) view.findViewById(R.id.views_edit_dialog_Message)).setText(message);
            }
            dialog.setContentView(view);
            return dialog;
        }
    }
}
