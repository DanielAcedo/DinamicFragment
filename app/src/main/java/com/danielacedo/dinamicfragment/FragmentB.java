package com.danielacedo.dinamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 25/11/16.
 */

public class FragmentB extends Fragment {

    public static final String TEXTVIEW_TEXT = "textview_text";
    public static final String TEXTVIEW_SIZE = "textview_size";

    public static final String FRAGMENTB_TAG = "TAGB";

    private TextView txv_frgB;

    public static FragmentB newInstance(Bundle arguments){
        FragmentB fragmentB = new FragmentB();

        if(arguments != null){
            fragmentB.setArguments(arguments);
        }

        return fragmentB;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.frg_b_layout, container, false);

        if(rootView != null) {
            txv_frgB = (TextView) rootView.findViewById(R.id.txv_frgB);
            receiveTextParameters();

        }

        return rootView;
    }

    /**
     * Initialize text parameters sent by arguments
     */
    public void receiveTextParameters(){

        Bundle argument = getArguments();

        if(argument != null){
            String text = argument.getString(TEXTVIEW_TEXT);
            int size = argument.getInt(TEXTVIEW_SIZE);

            if(text != null)
                txv_frgB.setText(text);

            txv_frgB.setTextSize(size);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(TEXTVIEW_TEXT, txv_frgB.getText().toString());
        outState.putFloat(TEXTVIEW_SIZE, txv_frgB.getTextSize()/getResources().getDisplayMetrics().scaledDensity); //Convert pixels to sp
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState != null){
            String txv_state = savedInstanceState.getString(TEXTVIEW_TEXT);
            float txv_size = savedInstanceState.getFloat(TEXTVIEW_SIZE);

            if(txv_state != null){
                txv_frgB.setText(txv_state);
            }

            if(txv_size != 0){
                txv_frgB.setTextSize(txv_size);
            }
        }
    }
}
