package com.danielacedo.staticfragment;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentIterationListener{

    private FragmentB fgrB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fgrB = (FragmentB) getFragmentManager().findFragmentById(R.id.frg_B);
    }

    @Override
    public void onFragmentIterationListener(String text, int size) {
        fgrB.receiveTextParameters(text, size);
    }
}
