package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.heliocratic.mikola.firstproject.R;

import java.util.ArrayList;
import java.util.List;

public class KeyboardSettingsFragment extends Fragment {
    private View ksView;
    private ListView listView;
    private List<String> itemTitleList = new ArrayList<String>();
    private KeyboardSettingAdapter keyboardAdapter;
//    public static final int ITEM_KEYBOARD_SETTING_COUNT = 21;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ksView = inflater.inflate(R.layout.fragment_screen_keyboard_settings, null);

        String[] itemTitle = getResources().getStringArray(R.array.keyboard_settings_items_titles);
        for (int i = 0; i < itemTitle.length; i++){
            Log.d("NIKI", itemTitle[i]);
            itemTitleList.add(itemTitle[i]);
        }


        listView = (ListView) ksView.findViewById(R.id.keyboardSettingsListView);
        keyboardAdapter = new KeyboardSettingAdapter(itemTitleList, getContext());
        listView.setAdapter(keyboardAdapter);

        return ksView;
    }
}
