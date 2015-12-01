package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heliocratic.mikola.firstproject.R;

public class SettingSizeKeyboardFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting_size_keyboard, null);
//        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_setting_size_keyboard);
//        linearLayout.setBackgroundResource(SharedPrefStorage.getKeyboardBackgroundColorPref(getContext()));
        return view;
    }
}
