package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.heliocratic.mikola.firstproject.R;
import com.heliocratic.mikola.firstproject.constants.SharedPrefConstants;
import com.heliocratic.mikola.firstproject.tools.SharedPrefStorage;
import com.heliocratic.mikola.firstproject.ui.MainActivity;
import com.heliocratic.mikola.firstproject.ui.keybord_setting.items_settings.ColorPickerSeekBar;

import java.util.Arrays;

public class KeyboardSettingAdapter extends BaseAdapter {
    public static final int TYPE_ITEM_TEXT = 0;
    public static final int TYPE_ITEM_CHECK = 1;
    public static final int TYPE_ITEM_SEEKBAR = 2;
    public static final int TYPE_ITEM_SEPARATOR = 3;
    public static final int TYPE_ITEM_RAINBOW_SEEKBAR = 4;
    public static final int TYPE_MAX_COUNT = TYPE_ITEM_RAINBOW_SEEKBAR + 1;

    private Context context;
    private String[] itemTitle;
    private LayoutInflater inflater;

    public KeyboardSettingAdapter(String[] itemTitle, Context context) {
        this.itemTitle = itemTitle;
        this.context = context;
        inflater = LayoutInflater.from(context);
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
        Integer[] checkBoxItems = {7, 9, 12, 13, 15};
        Integer[] seekBarItems = {2, 5};
        Integer[] separatorsItems = {0, 8, 17};
        Integer[] onlyTextItems = {3, 4, 6, 10, 11, 14, 16, 18, 19, 20};

        if (Arrays.asList(checkBoxItems).contains(position))
            return TYPE_ITEM_CHECK;
        else if (Arrays.asList(seekBarItems).contains(position))
            return TYPE_ITEM_SEEKBAR;
        else if (Arrays.asList(separatorsItems).contains(position))
            return TYPE_ITEM_SEPARATOR;
        else if (Arrays.asList(onlyTextItems).contains(position))
            return TYPE_ITEM_TEXT;
        else
            return TYPE_ITEM_RAINBOW_SEEKBAR;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_ITEM_TEXT:
                TextViewHolder textViewHolder = null;
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_text_keyboard_setting, parent, false);
                    textViewHolder = new TextViewHolder(convertView);
                    convertView.setTag(textViewHolder);
                } else {
                    textViewHolder = (TextViewHolder) convertView.getTag();
                }
                textViewHolder.optionsTitle.setText(itemTitle[position]);
                break;
            case TYPE_ITEM_CHECK:
                CheckBoxViewHolder checkBoxViewHolder = null;
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_checkbox_keyboard_setting, parent, false);
                    checkBoxViewHolder = new CheckBoxViewHolder(convertView);
                    convertView.setTag(checkBoxViewHolder);
                } else {
                    checkBoxViewHolder = (CheckBoxViewHolder) convertView.getTag();
                }
                checkBoxViewHolder.optionsTitle.setText(itemTitle[position]);
                break;
            case TYPE_ITEM_SEEKBAR:
                SeekBarViewHolder seekBarViewHolder = null;
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_seekbar_keyboard_settings, parent, false);
                    seekBarViewHolder = new SeekBarViewHolder(convertView);
                    convertView.setTag(seekBarViewHolder);
                } else {
                    seekBarViewHolder = (SeekBarViewHolder) convertView.getTag();
                }
                seekBarViewHolder.optionsTitle.setText(itemTitle[position]);
                break;
            case TYPE_ITEM_SEPARATOR:
                SeparatorViewHolder separatorViewHolder = null;
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_separator_keyboard_settings, parent, false);
                    separatorViewHolder = new SeparatorViewHolder(convertView);
                    convertView.setTag(separatorViewHolder);
                } else {
                    separatorViewHolder = (SeparatorViewHolder) convertView.getTag();
                }
                separatorViewHolder.optionsTitle.setText(itemTitle[position]);
//                separatorViewHolder.optionsTitle.setEnabled(false);
                break;
            case TYPE_ITEM_RAINBOW_SEEKBAR:
                RainbowSeekBarViewHolder rainbowSeekBarViewHolder = null;
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_rainbow_seekbar_keyboard_settings,
                            parent, false);
                    rainbowSeekBarViewHolder = new RainbowSeekBarViewHolder(convertView);
                    convertView.setTag(rainbowSeekBarViewHolder);
                } else {
                    rainbowSeekBarViewHolder = (RainbowSeekBarViewHolder) convertView.getTag();
                }
                rainbowSeekBarViewHolder.optionsTitle.setText(itemTitle[position]);
                rainbowSeekBarViewHolder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int r = 0;
                        int g = 0;
                        int b = 0;

                        if (progress < 256) {
                            b = progress;
                        } else if (progress < 256 * 2) {
                            g = progress % 256;
                            b = 256 - progress % 256;
                        } else if (progress < 256 * 3) {
                            g = 255;
                            b = progress % 256;
                        } else if (progress < 256 * 4) {
                            r = progress % 256;
                            g = 256 - progress % 256;
                            b = 256 - progress % 256;
                        } else if (progress < 256 * 5) {
                            r = 255;
                            g = 0;
                            b = progress % 256;
                        } else if (progress < 256 * 6) {
                            r = 255;
                            g = progress % 256;
                            b = 256 - progress % 256;
                        } else if (progress < 256 * 7) {
                            r = 255;
                            g = 255;
                            b = progress % 256;
                        }
                        Log.d("NIKIM", String.valueOf(r));
                        Log.d("NIKIM", String.valueOf(g));
                        Log.d("NIKIM", String.valueOf(b));
                        SharedPrefStorage.setKeyboardBackgroundColorPref(context, Color.argb(255, r, g, b));
                        SharedPrefStorage.setKeyboardBackgroundColorPref(context, progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                rainbowSeekBarViewHolder.seekBar.setProgress(SharedPrefStorage
                        .getKeyboardBackgroundColorPref1(context));
                break;
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

    class SeparatorViewHolder {
        public TextView optionsTitle;

        public SeparatorViewHolder(View itemView) {
            optionsTitle = (TextView) itemView.findViewById(R.id.itemSeparatorKeyboardSettingTitle);
        }
    }

    class RainbowSeekBarViewHolder {
        public TextView optionsTitle;
        public SeekBar seekBar;

        public RainbowSeekBarViewHolder(View itemView) {
            optionsTitle = (TextView) itemView.findViewById(R.id.itemRainbowSeekBarKeyboardSettingTitle);
            seekBar = (ColorPickerSeekBar) itemView.findViewById(R.id.RainbowSeekBarKeyboardSetting);
        }
    }

}
