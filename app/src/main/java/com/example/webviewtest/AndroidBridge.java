package com.example.webviewtest;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.ConcurrentModificationException;

public class AndroidBridge {

    Context context;
    WebView webView;

    public AndroidBridge(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(context, "테스트1", Toast.LENGTH_SHORT).show();;
    }

    @JavascriptInterface
    public String getUserData() {

        Log.i("TEST", "getUserData");

        UserData userData = new UserData();

        userData.setAccessId("test_accessId");
        userData.setAccNm("tset_성빈");

        return  (new Gson().toJson(userData));
    }
}
