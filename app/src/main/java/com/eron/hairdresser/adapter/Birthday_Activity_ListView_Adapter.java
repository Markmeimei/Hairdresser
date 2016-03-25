package com.eron.hairdresser.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Birthday_Model;
import com.eron.hairdresser.views.Views;
import com.eron.hairdresser.views.dialog.EditDialog;
import com.lin.framwork.utils.ASimpleCache;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.utils.SpannableStringUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/12.
 */
public class Birthday_Activity_ListView_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Birthday_Model> modelList;

    public Birthday_Activity_ListView_Adapter(Context context, List<Birthday_Model> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.modelList = list;
    }

    @Override
    public int getCount() {
        return modelList == null ? 0 : modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_birthday_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String Date = "";
        if (modelList.get(position).getTime().indexOf("农") != -1) {
            String Date2 = modelList.get(position).getTime().substring(0, modelList.get(position).getTime().indexOf("农"));
            String Date3 = modelList.get(position).getTime().substring(modelList.get(position).getTime().indexOf("农"), modelList.get(position).getTime().length());
            Date = convertView.getResources().getString(R.string.adapter_birthday_activity_listview_today) + Date2 +
                    convertView.getResources().getString(R.string.adapter_birthday_activity_listview_line) + Date3;
        }

        String Name = convertView.getResources().getString(R.string.adapter_birthday_activity_listview_today) + modelList.get(position).getName() +
                convertView.getResources().getString(R.string.adapter_birthday_activity_listview_age);
        holder.adapterBirthdayActivityListviewDate.setText(SpannableStringUtil.getForegroundColor(Date, convertView.getResources().getColor(R.color.text_color2), 5, Date.length()));
        holder.adapterBirthdayActivityListviewName.setText(SpannableStringUtil.getForegroundColor(Name, convertView.getResources().getColor(R.color.text_color2), 5, Name.indexOf("岁")));

        allClick(holder, position);
        return convertView;
    }

    private void allClick(final ViewHolder holder, final int position) {
        holder.adapterBirthdayActivityListviewLinearLayoutUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modelList.get(position).getShow() == false) {
                    holder.adapterBirthdayActivityListviewLinearLayoutDown.setVisibility(View.VISIBLE);
                    modelList.get(position).setShow(true);
                } else {
                    holder.adapterBirthdayActivityListviewLinearLayoutDown.setVisibility(View.GONE);
                    modelList.get(position).setShow(false);
                }
            }
        });
        //弹出框
        final EditDialog.Builder builder = new EditDialog.Builder(context);

        if (holder.adapterBirthdayActivityListviewCheckBoxA.isChecked() == false
                && holder.adapterBirthdayActivityListviewCheckBoxB.isChecked() == false
                && holder.adapterBirthdayActivityListviewCheckBoxC.isChecked() == false) {
            defaultClick(holder, position, builder);
        }
        holder.adapterBirthdayActivityListviewCheckBoxA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    holder.adapterBirthdayActivityListviewCheckBoxB.setChecked(false);
                    holder.adapterBirthdayActivityListviewCheckBoxC.setChecked(false);
                    holder.adapterBirthdayActivityListviewButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            builder.setTitle("编写短信")
                                    .setMessage(ASimpleCache.get(context).getAsString("birthdayTemplateA"))
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast_Common.DefaultToast(context, "取消");
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton("发送", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast_Common.DefaultToast(context, "发送");
                                    dialog.dismiss();
                                }
                            }).create().show();
                        }
                    });
                } else {
                    defaultClick(holder, position, builder);
                }
            }
        });

        holder.adapterBirthdayActivityListviewCheckBoxB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    holder.adapterBirthdayActivityListviewCheckBoxA.setChecked(false);
                    holder.adapterBirthdayActivityListviewCheckBoxC.setChecked(false);
                    holder.adapterBirthdayActivityListviewButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            builder.setTitle("编写短信")
                                    .setMessage(ASimpleCache.get(context).getAsString("birthdayTemplateB"))
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast_Common.DefaultToast(context, "取消");
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton("发送", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast_Common.DefaultToast(context, "发送");
                                    dialog.dismiss();
                                }
                            }).create().show();
                        }
                    });
                } else {
                    defaultClick(holder, position, builder);
                }
            }
        });

        holder.adapterBirthdayActivityListviewCheckBoxC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    holder.adapterBirthdayActivityListviewCheckBoxA.setChecked(false);
                    holder.adapterBirthdayActivityListviewCheckBoxB.setChecked(false);
                    holder.adapterBirthdayActivityListviewButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            builder.setTitle("编写短信")
                                    .setMessage(ASimpleCache.get(context).getAsString("birthdayTemplateC"))
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast_Common.DefaultToast(context, "取消");
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton("发送", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast_Common.DefaultToast(context, "发送");
                                    dialog.dismiss();
                                }
                            }).create().show();
                        }
                    });
                } else {
                    defaultClick(holder, position, builder);
                }
            }
        });

        holder.adapterBirthdayActivityListviewCheckBoxA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast_Common.DefaultToast(context, "长按");
                return false;
            }
        });

        holder.adapterBirthdayActivityListviewCheckBoxB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast_Common.DefaultToast(context, "长按");
                return false;
            }
        });

        holder.adapterBirthdayActivityListviewCheckBoxC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast_Common.DefaultToast(context, "长按");
                return false;
            }
        });

        holder.adapterBirthdayActivityListviewCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.callPhone(context, "18663306807");
            }
        });

        holder.adapterBirthdayActivityListviewIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast_Common.DefaultToast(context, "忽略");
            }
        });
    }

    //默认点击
    private void defaultClick(final ViewHolder holder, final int position, final EditDialog.Builder builder) {
        holder.adapterBirthdayActivityListviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("编写短信")
                        .setMessage("")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast_Common.DefaultToast(context, "取消");
                                dialog.dismiss();
                            }
                        }).setPositiveButton("发送", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast_Common.DefaultToast(context, "发送");
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });
    }

    static class ViewHolder {
        @Bind(R.id.adapter_birthday_activity_listview_Date)
        TextView adapterBirthdayActivityListviewDate;
        @Bind(R.id.adapter_birthday_activity_listview_Name)
        TextView adapterBirthdayActivityListviewName;
        @Bind(R.id.adapter_birthday_activity_listview_LinearLayout_Up)
        LinearLayout adapterBirthdayActivityListviewLinearLayoutUp;
        @Bind(R.id.adapter_birthday_activity_listview_CheckBox_A)
        CheckBox adapterBirthdayActivityListviewCheckBoxA;
        @Bind(R.id.adapter_birthday_activity_listview_CheckBox_B)
        CheckBox adapterBirthdayActivityListviewCheckBoxB;
        @Bind(R.id.adapter_birthday_activity_listview_CheckBox_C)
        CheckBox adapterBirthdayActivityListviewCheckBoxC;
        @Bind(R.id.adapter_birthday_activity_listview_Button)
        Button adapterBirthdayActivityListviewButton;
        @Bind(R.id.adapter_birthday_activity_listview_Call)
        TextView adapterBirthdayActivityListviewCall;
        @Bind(R.id.adapter_birthday_activity_listview_Ignore)
        TextView adapterBirthdayActivityListviewIgnore;
        @Bind(R.id.adapter_birthday_activity_listview_LinearLayout_Down)
        LinearLayout adapterBirthdayActivityListviewLinearLayoutDown;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
