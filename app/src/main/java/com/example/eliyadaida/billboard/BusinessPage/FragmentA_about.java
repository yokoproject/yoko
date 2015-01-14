package com.example.eliyadaida.billboard.BusinessPage;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eliyadaida.billboard.R;

/**
 * Created by eliyadaida on 1/7/15.
 */
public class FragmentA_about extends Fragment {

    ActionBar actionBar;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_a_about, container, false);


        return rootView;
    }
}
