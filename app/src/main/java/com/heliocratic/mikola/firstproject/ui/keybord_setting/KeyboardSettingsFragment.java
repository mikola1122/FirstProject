package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.heliocratic.mikola.firstproject.R;

public class KeyboardSettingsFragment extends Fragment {
    private View ksView;
    private ListView listView;
    private KeyboardSettingAdapter keyboardAdapter;
    public static final int ITEM_KEYBOARD_SETTING_COUNT = 21;
    private String[] itemTitle = new String[ITEM_KEYBOARD_SETTING_COUNT];


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ksView = inflater.inflate(R.layout.fragment_screen_keyboard_settings, null);
        itemTitle = getResources().getStringArray(R.array.keyboard_settings_items_titles);
        listView = (ListView) ksView.findViewById(R.id.keyboardSettingsListView);
        keyboardAdapter = new KeyboardSettingAdapter(itemTitle, getContext());
        listView.setAdapter(keyboardAdapter);

        return ksView;
    }
}
