package com.example.george.test_aegean_app;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ARGIRIS on 01-Dec-16.
 */

public class WinterCal extends  Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.WinterCal, container, false);

      //  ListView lista = (ListView) rootView.findViewById(R.id.Winterlistview);


        return rootView;
    }
}
