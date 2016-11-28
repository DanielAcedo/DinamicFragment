package com.danielacedo.staticfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by Daniel on 28/11/16.
 */

public class FragmentC extends Fragment {

    WebView web_about;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.frg_c_layout, container, false);

        if(rootView != null){
            web_about = (WebView) rootView.findViewById(R.id.web_about);
            web_about.loadData(getResources().getString(R.string.aboutus), "text/html", "UTF-8");
        }

        return rootView;
    }
}
