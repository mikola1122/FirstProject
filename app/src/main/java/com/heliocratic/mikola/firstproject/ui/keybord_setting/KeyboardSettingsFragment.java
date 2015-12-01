package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.heliocratic.mikola.firstproject.R;

public class KeyboardSettingsFragment extends Fragment {
    private View ksView;
    private ListView listView;
    private KeyboardSettingAdapter keyboardAdapter;
    String[] itemTitle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ksView = inflater.inflate(R.layout.fragment_screen_keyboard_settings, null);

        String[] itemTitle = getResources().getStringArray(R.array.keyboard_settings_items_titles);

        listView = (ListView) ksView.findViewById(R.id.keyboardSettingsListView);
        keyboardAdapter = new KeyboardSettingAdapter(itemTitle, getContext());
        listView.setAdapter(keyboardAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 3:
                        break;
                    case 4:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerKeybordSettingsFragment, new SettingSizeKeyboardFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 6:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 14:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerKeybordSettingsFragment, new SettingAdjustHotkeysFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 16:
                        break;
                    case 18:
                        break;
                    case 19:
                        break;
                    case 20:
                        break;
                }
            }
        });

        return ksView;
    }
}
