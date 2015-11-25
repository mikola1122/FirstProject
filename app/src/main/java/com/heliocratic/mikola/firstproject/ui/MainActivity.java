package com.heliocratic.mikola.firstproject.ui;

import android.app.Activity;
import android.os.Bundle;

import com.heliocratic.mikola.firstproject.R;
import com.heliocratic.mikola.firstproject.tools.ServerCommunication;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String myUrl = "http://food2fork.com/api/search?key=626c8302ec28ca142b82a33cff56b79c&page=1";

                    ServerCommunication serverCommunication = new ServerCommunication();
                    List arrayList = serverCommunication.get(myUrl);
                    serverCommunication.post(myUrl, new ArrayList<BasicNameValuePair>());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
