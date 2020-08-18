package com.example.myapplicationppp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        t=findViewById(R.id.hell);
        t.setText(getPythonmodule());

    }

    private String getPythonmodule(){
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("a");
        return pythonFile.callAttr("aa").toString();



    }
}