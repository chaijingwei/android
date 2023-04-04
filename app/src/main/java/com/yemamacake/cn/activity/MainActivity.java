package com.yemamacake.cn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.yemamacake.cn.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registerButton, loginButton;
    private EditText usernameText, paswdEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                break;
        }
    }

    //界面组件初始化
    private void init() {
        usernameText = findViewById(R.id.username);
        paswdEdit = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(this);
        registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(this);
    }
}
