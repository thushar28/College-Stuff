package com.example.dialing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText phonenumber;
    Button one,two,three,four,five,six,seven,eight,nine,zero,hash,star,save,call,del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phonenumber=findViewById(R.id.number);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        hash=findViewById(R.id.hash);
        star=findViewById(R.id.star);
        save=findViewById(R.id.save);
        call=findViewById(R.id.call);
        del=findViewById(R.id.del);
        ///onclick
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        hash.setOnClickListener(this);
        star.setOnClickListener(this);
        save.setOnClickListener(this);
        call.setOnClickListener(this);
        del.setOnClickListener(this);
        phonenumber.setText("");

    }

    @Override
    public void onClick(View v) {
        String phone=phonenumber.getText().toString().trim();
        if (v.equals(one)) {
            phone += "1";
            phonenumber.setText(phone);

        } else if (v.equals(two)) {
            phone += "2";
            phonenumber.setText(phone);

        } else if (v.equals(three)) {
            phone += "3";
            phonenumber.setText(phone);

        } else if (v.equals(four)) {
            phone += "4";
            phonenumber.setText(phone);

        } else if (v.equals(five)) {
            phone += "5";
            phonenumber.setText(phone);

        } else if (v.equals(six)) {
            phone += "6";
            phonenumber.setText(phone);

        } else if (v.equals(seven)) {
            phone += "7";
            phonenumber.setText(phone);

        } else if (v.equals(eight)) {
            phone += "8";
            phonenumber.setText(phone);

        } else if (v.equals(nine)) {
            phone += "9";
            phonenumber.setText(phone);

        } else if (v.equals(zero)) {
            phone += "0";
            phonenumber.setText(phone);

        } else if (v.equals(hash)) {
            phone+="#";
            phonenumber.setText(phone);

        } else if (v.equals(star)) {
            phone += "*";
            phonenumber.setText(phone);

        } else if (v.equals(del)) {
            phonenumber.setText("");
        } else if (v.equals(call)) {
            if (phone.isEmpty()) {
                Toast.makeText(getBaseContext(), "Enter Phone Number", Toast.LENGTH_LONG).show();
            } else {
                Uri uri = Uri.parse("tel:" + phone);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        } else if (v.equals(save)) {
            if (phone.isEmpty()) {
                Toast.makeText(getBaseContext(), "Enter Phone Number", Toast.LENGTH_LONG).show();
            } else {
                Intent i = new Intent(ContactsContract.Intents.Insert.ACTION);
                i.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                i.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                startActivity(i);
            }

        }
    }

}
