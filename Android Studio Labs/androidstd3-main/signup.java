package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button signupbtn;
    String ex="^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         username=findViewById(R.id.username);
         password=findViewById(R.id.password);
         signupbtn=findViewById(R.id.signupbtn);
         signupbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String uname=username.getText().toString();
                 String pwd=password.getText().toString();

                 if(validatePassword(pwd)){
                     Intent intent=new Intent(MainActivity.this,signin.class);
                     Bundle bundle=new Bundle();
                     bundle.putString("username",uname);
                     bundle.putString("password",pwd);
                     intent.putExtras(bundle);

                     startActivity(intent);
                 }
                 else
                 {
                     Toast.makeText(MainActivity.this,"Invalid password", Toast.LENGTH_LONG).show();
                 }

             }
         });


    }

    private boolean validatePassword(String pwd) {
        Pattern pattern=Pattern.compile(ex);
        Matcher matcher=pattern.matcher(pwd);
        return matcher.matches();
    }
}
