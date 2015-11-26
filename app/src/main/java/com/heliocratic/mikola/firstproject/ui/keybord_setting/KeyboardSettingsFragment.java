package com.heliocratic.mikola.firstproject.ui.keybord_setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heliocratic.mikola.firstproject.R;

public class KeyboardSettingsFragment extends Fragment {
    View ksView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ksView = inflater.inflate(R.layout.fragment_screen_keyboard_settings, null);


        return ksView;
    }
}
