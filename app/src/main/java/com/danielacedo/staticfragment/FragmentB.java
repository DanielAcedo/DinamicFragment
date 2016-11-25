package com.danielacedo.staticfragment;

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

    private TextView txv_frgB;

    public static FragmentB newInstance(Bundle arguments){
        FragmentB fragmentB = new FragmentB();

        if(arguments != null){
            fragmentB.setArguments(arguments);
        }

        return fragmentB;
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

        if(rootView != null){
            txv_frgB = (TextView)rootView.findViewById(R.id.txv_frgB);
        }

        return rootView;
    }
}
