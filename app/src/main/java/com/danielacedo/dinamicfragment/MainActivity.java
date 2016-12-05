package com.danielacedo.dinamicfragment;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentIterationListener{

    private FragmentB frgB;
    private FragmentA frgA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgA = (FragmentA) getFragmentManager().findFragmentByTag(FragmentA.FRAGMENTA_TAG);

        if(frgA == null){
            frgA = new FragmentA();
            getFragmentManager().beginTransaction().add(R.id.activity_main, frgA, FragmentA.FRAGMENTA_TAG).commit();
        }

        //frgB = (FragmentB)getFragmentManager().findFragmentByTag(FragmentB.FRAGMENTB_TAG);

        /*if(frgB != null){
            getFragmentManager().beginTransaction().replace(R.id.activity_main, frgB, FragmentB.FRAGMENTB_TAG);
        }*/

    }

    @Override
    public void onFragmentIterationListener(String text, int size) {
        Bundle bundle = new Bundle();
        bundle .putString(FragmentB.TEXTVIEW_TEXT, text);
        bundle.putInt(FragmentB.TEXTVIEW_SIZE, size);

        frgB = FragmentB.newInstance(bundle);


        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main, frgB, FragmentB.FRAGMENTB_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
