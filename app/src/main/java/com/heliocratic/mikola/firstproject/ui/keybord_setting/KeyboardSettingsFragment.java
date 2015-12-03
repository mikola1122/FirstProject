package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.heliocratic.mikola.firstproject.R;
import com.heliocratic.mikola.firstproject.tools.SharedPrefStorage;
import com.heliocratic.mikola.firstproject.ui.MainActivity;
import com.heliocratic.mikola.firstproject.ui.keybord_setting.items_settings.SettingAboutUsFragment;

public class KeyboardSettingsFragment extends Fragment {
    private View ksView;
    private ListView listView;
    private KeyboardSettingAdapter keyboardAdapter;
    String[] itemTitle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ksView = inflater.inflate(R.layout.fragment_screen_keyboard_settings, null);

        itemTitle = getResources().getStringArray(R.array.keyboardSettingsItemsTitles);

        listView = (ListView) ksView.findViewById(R.id.keyboardSettingsListView);
        keyboardAdapter = new KeyboardSettingAdapter(itemTitle, getContext());
        listView.setAdapter(keyboardAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 3:
                        int checkedItemSizeMode = SharedPrefStorage.getKeyboardSizeModePref(getActivity());
                        String[] itemsSizeMode = getResources().getStringArray(R.array.keyboardSizeMode);
                        dialog(itemsSizeMode, position, checkedItemSizeMode);
                        break;
                    case 4:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerKeybordSettingsFragment, new SettingSizeKeyboardFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 6:
                        int checkedItemFontStyle = SharedPrefStorage.getKeyboardFontStylePref(getActivity());
                        String[] itemsFontStyle = getResources().getStringArray(R.array.fontStyle);
                        dialog(itemsFontStyle, position, checkedItemFontStyle);
                        break;
                    case 10:
                        int checkedItemTextSpeech = SharedPrefStorage.getKeyboardTextSpeechPref(getActivity());
                        String[] itemsTextSpeech = getResources().getStringArray(R.array.textSpeech);
                        dialog(itemsTextSpeech, position, checkedItemTextSpeech);
                        break;
                    case 11:
                        int checkedItemKeySound = SharedPrefStorage.getKeyboardKeySoundPref(getActivity());
                        String[] itemsKeySound = getResources().getStringArray(R.array.keySound);
                        dialog(itemsKeySound, position, checkedItemKeySound);
                        break;
                    case 14:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerKeybordSettingsFragment, new SettingAdjustHotkeysFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 16:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerKeybordSettingsFragment, new SettingStatisticFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 18:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerKeybordSettingsFragment, new SettingTutorialFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 19:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerKeybordSettingsFragment, new SettingAboutUsFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 20:
                        Uri uri = Uri.parse(getString(R.string.contactUsUrl));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                }
            }
        });

        return ksView;
    }

    private void dialog(String[] items, final int position, int checkedItem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(itemTitle[position]);
        builder.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (position) {
                    case 3:
                        SharedPrefStorage.setKeyboardSizeModePref(getActivity(), item);
                        break;
                    case 6:
                        SharedPrefStorage.setKeyboardFontStylePref(getActivity(), item);
                        break;
                    case 10:
                        SharedPrefStorage.setKeyboardTextSpeechPref(getActivity(), item);
                        break;
                    case 11:
                        SharedPrefStorage.setKeyboardKeySoundPref(getActivity(), item);
                        break;
                }
                dialog.dismiss();
            }
        });
        AlertDialog levelDialog = builder.create();
        levelDialog.show();
    }
}
