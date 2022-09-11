package com.example.tots;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

import javax.net.ssl.SSLEngineResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    Button btn_speak;
    EditText EDITTXT;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_speak=(Button)findViewById(R.id.btn_speak);
        EDITTXT=(EditText) findViewById(R.id.EDITTXT);
        btn_speak.setOnClickListener(this);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onClick(View view) {
        String text=EDITTXT.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int i) {

        int Status=0;
        if (Status!=TextToSpeech.ERROR)
        {
            Toast.makeText(getBaseContext(),"success",Toast.LENGTH_LONG).show();
        }

    }
}
