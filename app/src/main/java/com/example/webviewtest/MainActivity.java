package com.example.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private EditText urlText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlText = findViewById(R.id.editText);
        urlText.setText("file:///android_asset/sample.html");

        webView = findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient());
        webView.addJavascriptInterface(new AndroidBridge(MainActivity.this, webView),"Android2");

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/sample.html");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(urlText.getText().toString());
            }
        });
    }
}
