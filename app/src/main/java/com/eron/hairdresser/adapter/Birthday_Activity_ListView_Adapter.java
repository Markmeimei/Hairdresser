package com.eron.hairdresser.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
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
import com.eron.hairdresser.common.TagName;
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
    private List<Birthday_Model.ObjectBean> model;

    public Birthday_Activity_ListView_Adapter(Context context, List<Birthday_Model.ObjectBean> model) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.model = model;
    }

    @Override
    public int getCount() {
        return model == null ? 0 : model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
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

        String Date = convertView.getResources().getString(R.string.adapter_birthday_activity_listview_today) + model.get(position).getBirth() +
                convertView.getResources().getString(R.string.adapter_birthday_activity_listview_line) + model.get(position).getBirth();

        String Name = convertView.getResources().getString(R.string.adapter_birthday_activity_listview_today) + model.get(position).getName() +
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
                if (model.get(position).isShow() == false) {
                    holder.adapterBirthdayActivityListviewLinearLayoutDown.setVisibility(View.VISIBLE);
                    model.get(position).setShow(true);
                } else {
                    holder.adapterBirthdayActivityListviewLinearLayoutDown.setVisibility(View.GONE);
                    model.get(position).setShow(false);
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
                                    .setMessage(ASimpleCache.get(context).getAsString(TagName.BirthdayTemplateA))
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast_Common.DefaultToast(context, "取消");
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton("发送", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    IntentUtil.sendMessage(context, model.get(position).getPhone(), builder.getGetmessage());
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
                                    .setMessage(ASimpleCache.get(context).getAsString(TagName.BirthdayTemplateB))
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast_Common.DefaultToast(context, "取消");
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton("发送", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    IntentUtil.sendMessage(context, model.get(position).getPhone(), builder.getGetmessage());
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
                                    .setMessage(ASimpleCache.get(context).getAsString(TagName.BirthdayTemplateC))
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast_Common.DefaultToast(context, "取消");
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton("发送", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    IntentUtil.sendMessage(context, model.get(position).getPhone(), builder.getGetmessage());
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
                IntentUtil.dialPhones(context, model.get(position).getPhone());
            }
        });

        holder.adapterBirthdayActivityListviewIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.remove(position);
                notifyDataSetChanged();
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
                        IntentUtil.sendMessage(context, model.get(position).getPhone(), "");
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
        LinearLayout adapterBirthdayActivityListviewCall;
        @Bind(R.id.adapter_birthday_activity_listview_Ignore)
        LinearLayout adapterBirthdayActivityListviewIgnore;
        @Bind(R.id.adapter_birthday_activity_listview_LinearLayout_Down)
        LinearLayout adapterBirthdayActivityListviewLinearLayoutDown;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
