package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.heliocratic.mikola.firstproject.R;

public class KeybordSettingAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
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
            optionsTitle = (TextView) itemView.findViewById(R.id.itemSeekBarKeyboardSettingTitle);
            checkBox = (CheckBox) itemView.findViewById(R.id.CheckBoxKeyboardSetting);
        }
    }
}
