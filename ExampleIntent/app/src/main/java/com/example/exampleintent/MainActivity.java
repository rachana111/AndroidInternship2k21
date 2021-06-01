package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //declare all views here
    EditText name,number,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize all the views here
        name=findViewById(R.id.name);
        name=findViewById(R.id.number);
        name=findViewById(R.id.link);
    }

    public void next(View view) {
        //here we will work with explicit intent
        String n=name.getText().toString();
        //intent obj=new intent(present class,next class);
        //start activity(obj)
        Intent i =new Intent(this,SecondActivity.class);
                i.putExtra("key",n);
        startActivity(i);
    }

    public void dial(View view) {
        //here work with implicit intent
        String n =number.getText().toString();
        //uri=unified resource identifier
        //phone - tel;web-https:// ,loc-geo:lat,lan
        Uri uri = Uri.parse("tel:"+n);
        Intent i =new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);

    }

    public void search(View view) {
        String n =link.getText().toString();
        Uri uri = Uri.parse("https://"+n);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}