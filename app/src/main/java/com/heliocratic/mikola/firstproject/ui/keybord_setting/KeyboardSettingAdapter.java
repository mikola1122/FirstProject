package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.heliocratic.mikola.firstproject.R;

import java.util.ArrayList;
import java.util.List;

public class KeyboardSettingAdapter extends BaseAdapter {
    public static final int TYPE_ITEM_TEXT = 0;
    public static final int TYPE_ITEM_CHECK = 1;
    public static final int TYPE_ITEM_SEEKBAR = 2;
    public static final int TYPE_MAX_COUNT = TYPE_ITEM_SEEKBAR + 1;

    private Context context;
    private List<String> itemTitle = new ArrayList<String>();
    private LayoutInflater inflater;

    public KeyboardSettingAdapter(List<String> itemTitle, Context context) {
        this.itemTitle = itemTitle;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemTitle.size();
    }

    @Override
    public Object getItem(int position) {
        return itemTitle.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 7 || position == 9 || position == 12 || position == 13 || position == 15)
            return TYPE_ITEM_CHECK;
        else if(position == 1 || position == 2 || position == 5)
            return TYPE_ITEM_SEEKBAR;
         else
            return TYPE_ITEM_TEXT;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null){
            holder = new ViewHolder();
            switch (getItemViewType(position)) {
                case TYPE_ITEM_TEXT:
                    convertView = inflater.inflate(R.layout.item_text_keyboard_setting, parent, false);
                    holder.optionsTitle = (TextView) convertView.findViewById(R.id.itemTextKeyboardSettingTitle);
                    holder.optionsTitle.setText(itemTitle.get(position));
//                    convertView = LayoutInflater.from(context).inflate(R.layout.item_text_keyboard_setting, parent, false);
//                    TextViewHolder textViewHolder = new TextViewHolder(convertView);
//                    textViewHolder.optionsTitle.setText(itemTitle.get(position));
//                    convertView.setTag(textViewHolder);
                    break;
                case TYPE_ITEM_CHECK:
                    convertView = inflater.inflate(R.layout.item_checkbox_keyboard_setting, parent, false);
                    holder.optionsTitle = (TextView) convertView.findViewById(R.id.itemCheckBoxKeyboardSettingTitle);
                    holder.optionsTitle.setText(itemTitle.get(position));
                    holder.checkBox = (CheckBox) convertView.findViewById(R.id.CheckBoxKeyboardSetting);
                    holder.checkBox.setText("on/off");
//                    convertView = LayoutInflater.from(context).inflate(R.layout.item_checkbox_keyboard_setting, parent, false);
//                    CheckBoxViewHolder checkBoxViewHolder = new CheckBoxViewHolder(convertView);
//                    checkBoxViewHolder.optionsTitle.setText(itemTitle.get(position));
//                    checkBoxViewHolder.checkBox.setText("on/off");
//                    convertView.setTag(checkBoxViewHolder);
                    break;
                case TYPE_ITEM_SEEKBAR:
                    convertView = inflater.inflate(R.layout.item_seekbar_keyboard_settings, parent, false);
                    holder.optionsTitle = (TextView) convertView.findViewById(R.id.itemSeekBarKeyboardSettingTitle);
                    holder.optionsTitle.setText(itemTitle.get(position));
                    holder.seekBar = (SeekBar) convertView.findViewById(R.id.SeekBarKeyboardSetting);
//                    convertView = LayoutInflater.from(context).inflate(R.layout.item_seekbar_keyboard_settings, parent, false);
//                    SeekBarViewHolder seekBarViewHolder = new SeekBarViewHolder(convertView);
//                    seekBarViewHolder.optionsTitle.setText(itemTitle.get(position));
//                    seekBarViewHolder.seekBar.setClickable(false);
//                    seekBarViewHolder.seekBar.setFocusable(false);
//                    seekBarViewHolder.seekBar.setEnabled(false);
//                    convertView.setTag(seekBarViewHolder);
                    break;
            }
            convertView.setTag(holder);
        } else {
               holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder{
        public TextView optionsTitle;
        public SeekBar seekBar;
        public CheckBox checkBox;
    }

//    class TextViewHolder {
//        public TextView optionsTitle;
//
//        public TextViewHolder(View itemView) {
//            optionsTitle = (TextView) itemView.findViewById(R.id.itemTextKeyboardSettingTitle);
//        }
//    }
//
//    class SeekBarViewHolder {
//        public TextView optionsTitle;
//        public SeekBar seekBar;
//
//        public SeekBarViewHolder(View itemView) {
//            optionsTitle = (TextView) itemView.findViewById(R.id.itemSeekBarKeyboardSettingTitle);
//            seekBar = (SeekBar) itemView.findViewById(R.id.SeekBarKeyboardSetting);
//        }
//    }
//
//    class CheckBoxViewHolder {
//        public TextView optionsTitle;
//        public CheckBox checkBox;
//
//        public CheckBoxViewHolder(View itemView) {
//            optionsTitle = (TextView) itemView.findViewById(R.id.itemCheckBoxKeyboardSettingTitle);
//            checkBox = (CheckBox) itemView.findViewById(R.id.CheckBoxKeyboardSetting);
//        }
//    }
}
