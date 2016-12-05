package com.danielacedo.dinamicfragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by usuario on 25/11/16.
 */

public class FragmentA extends Fragment {

    public static final String FRAGMENTA_TAG = "TAGA";

    private SeekBar skb_frgA;
    private EditText edt_frgA;
    private Button btn_frgA;
    private FragmentIterationListener mCallback;

    public interface FragmentIterationListener{
        void onFragmentIterationListener(String text, int size);
    }

    public static FragmentA newInstance(Bundle arguments){
        FragmentA fragmentA = new FragmentA();

        if(arguments != null){
            fragmentA.setArguments(arguments);
        }

        return fragmentA;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            mCallback = (FragmentIterationListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement FragmentIterationListener");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mCallback = (FragmentIterationListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must implement FragmentIterationListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.frg_a_layout, container, false);

        if(rootView != null){
            edt_frgA = (EditText)rootView.findViewById(R.id.edt_frgA);

            btn_frgA = (Button)rootView.findViewById(R.id.btn_frgA);
            btn_frgA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onFragmentIterationListener(edt_frgA.getText().toString(), skb_frgA.getProgress());
                }
            });

            skb_frgA = (SeekBar) rootView.findViewById(R.id.skb_frgA);
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }
}
