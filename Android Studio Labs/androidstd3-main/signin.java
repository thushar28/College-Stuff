package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    EditText username,password;
    Button signinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        signinbtn=findViewById(R.id.signupbtn);

        Bundle bundle=getIntent().getExtras();

        String uname=bundle.getString("username");
        String pwd=bundle.getString("password");

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1=username.getText().toString();
                String password1=password.getText().toString();
                if(username1.equals(uname)&&password1.equals(pwd))
                {
                    Toast.makeText(signin.this,"Success",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(signin.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
