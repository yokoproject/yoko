package com.example.eliyadaida.billboard.SignIn;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eliyadaida.billboard.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class loginFragment extends Fragment {


    public loginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_login, container, false);
        return root;
    }


}
