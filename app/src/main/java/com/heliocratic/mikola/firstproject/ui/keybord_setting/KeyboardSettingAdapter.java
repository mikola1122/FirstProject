package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.content.Context;
import android.support.v4.content.res.TypedArrayUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.heliocratic.mikola.firstproject.R;

import java.util.Arrays;

public class KeyboardSettingAdapter extends BaseAdapter {
    public static final int TYPE_ITEM_TEXT = 0;
    public static final int TYPE_ITEM_CHECK = 1;
    public static final int TYPE_ITEM_SEEKBAR = 2;
    public static final int TYPE_MAX_COUNT = TYPE_ITEM_SEEKBAR + 1;

    private Context context;
    private String[] itemTitle;
    private LayoutInflater layoutInflater;

    public KeyboardSettingAdapter(String[] itemTitle, Context context) {
        this.itemTitle = itemTitle;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemTitle.length;
    }

    @Override
    public Object getItem(int position) {
        return itemTitle[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int[] itemsWithCheckBox = {8, 10, 13, 14, 16};
        int[] itemsWithSeekBar = {2, 3, 6};
        if (Arrays.asList(itemsWithCheckBox).contains(position))
            return TYPE_ITEM_CHECK;
        else if (Arrays.asList(itemsWithSeekBar).contains(position))
            return TYPE_ITEM_SEEKBAR;
        //other variant(item contains TextView only)
        return TYPE_ITEM_TEXT;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            switch (getItemViewType(position)) {
                case TYPE_ITEM_TEXT:
                    convertView = layoutInflater.inflate(R.layout.item_text_keyboard_setting, parent, false);
                    TextViewHolder textViewHolder = new TextViewHolder(convertView);
                    textViewHolder.optionsTitle.setText(itemTitle[position]);
                    convertView.setTag(textViewHolder);
                    break;
                case TYPE_ITEM_CHECK:
                    convertView = layoutInflater.inflate(R.layout.item_checkbox_keyboard_setting, parent, false);
                    CheckBoxViewHolder checkBoxViewHolder = new CheckBoxViewHolder(convertView);
                    checkBoxViewHolder.optionsTitle.setText(itemTitle[position]);
                    checkBoxViewHolder.checkBox.setText("on/off");
                    convertView.setTag(checkBoxViewHolder);
                    break;
                case TYPE_ITEM_SEEKBAR:
                    convertView = layoutInflater.inflate(R.layout.item_seekbar_keyboard_settings, parent, false);
                    SeekBarViewHolder seekBarViewHolder = new SeekBarViewHolder(convertView);
                    seekBarViewHolder.optionsTitle.setText(itemTitle[position]);
                    convertView.setTag(seekBarViewHolder);
                    break;
            }
        } else {
            try {
                convertView.getTag();
            } catch (Exception e){

            }
        }
        return convertView;
    }


    class TextViewHolder {
        public TextView optionsTitle;

        public TextViewHolder(View itemView) {
            optionsTitle = (TextView) itemView.findViewById(R.id.itemTextKeyboardSettingTitle);
        }
    }

    class SeekBarViewHolder {
        public TextView optionsTitle;
        public SeekBar seekBar;

        public SeekBarViewHolder(View itemView) {
            optionsTitle = (TextView) itemView.findViewById(R.id.itemSeekBarKeyboardSettingTitle);
            seekBar = (SeekBar) itemView.findViewById(R.id.SeekBarKeyboardSetting);
        }
    }

    class CheckBoxViewHolder {
        public TextView optionsTitle;
        public CheckBox checkBox;

        public CheckBoxViewHolder(View itemView) {
            optionsTitle = (TextView) itemView.findViewById(R.id.itemCheckBoxKeyboardSettingTitle);
            checkBox = (CheckBox) itemView.findViewById(R.id.CheckBoxKeyboardSetting);
        }
    }
}
