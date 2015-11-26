package com.heliocratic.mikola.firstproject.tools;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ServerCommunication {
    HttpClient httpclient;

    public ServerCommunication() {
        httpclient = new DefaultHttpClient();
    }

    public String get(String requestUrl) {
        HttpGet httpGet = new HttpGet(requestUrl);
        String responseTxt = null;
        try {
            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputstream = entity.getContent();
                responseTxt = responseToString(inputstream);
                Log.d("HTTP REQUEST GET", responseTxt);
                inputstream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseTxt;
    }

    public void post(String requestUrl, List<BasicNameValuePair> postParameters) {
        try {
            HttpPost httpPost = new HttpPost(requestUrl);
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters);
            httpPost.setEntity(formEntity);
            HttpResponse response = httpclient.execute(httpPost);
            InputStream inputStream = response.getEntity().getContent();
            Log.d("HTTP REQUEST POST", responseToString(inputStream));
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String responseToString(InputStream inputstream) {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        StringBuilder stringbuilder = new StringBuilder();

        String currentline = null;
        try {
            while ((currentline = bufferedreader.readLine()) != null) {
                stringbuilder.append(currentline + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = stringbuilder.toString();
        return result;
    }
}
