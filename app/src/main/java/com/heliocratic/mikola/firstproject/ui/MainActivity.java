package com.heliocratic.mikola.firstproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.heliocratic.mikola.firstproject.R;
import com.heliocratic.mikola.firstproject.tools.ServerCommunication;
import com.heliocratic.mikola.firstproject.ui.keybord_setting.KeyboardSettingsFragment;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerKeybordSettingsFragment, new KeyboardSettingsFragment())
                .commit();

        htmlRequestTest();


    }

    //Testing class ServerCommunication.java
    private void htmlRequestTest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String myUrl = "https://translate.google.com.ua/#en/uk/response";

                    ServerCommunication serverCommunication = new ServerCommunication();

                    //request GET
                    String result = serverCommunication.get(myUrl);

                    //request POST
                    serverCommunication.post(myUrl, new ArrayList<BasicNameValuePair>());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
