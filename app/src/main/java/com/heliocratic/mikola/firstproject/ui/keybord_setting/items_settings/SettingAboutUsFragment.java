package com.heliocratic.mikola.firstproject.ui.keybord_setting.items_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heliocratic.mikola.firstproject.R;

public class SettingAboutUsFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting_about_us, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
