package com.example.eliyadaida.billboard.Filtering_pages;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.eliyadaida.billboard.MainActivity;
import com.example.eliyadaida.billboard.R;

import java.io.Serializable;

public class FilterPage extends Fragment {


    public FilterPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_filter_page, container, false);

        return root;
    }
}


/*
public class FilterPage extends Activity {

    public FilterPage(){};

    CommercialFilter commercialFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_filter_page);

        Intent intent = getIntent();
       commercialFilter = (CommercialFilter)intent.getSerializableExtra("Filter");


        //initialize the SeekBar and change the value when the user move him
        SeekBar distanceFilter = (SeekBar)findViewById(R.id.seekBar);
        distanceFilter.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //save the position of the SeekBar
        distanceFilter.setProgress((int)commercialFilter.getDistance());

        Button btnFilter = (Button)findViewById(R.id.filter_button);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeekBar distanceFilter = (SeekBar)findViewById(R.id.seekBar);
                commercialFilter.setDistance(distanceFilter.getProgress());

                Intent i = new Intent(FilterPage.this,MainActivity.class);

                i.putExtra("Filter", commercialFilter);

                setResult(RESULT_OK, i);

                finish();
            }
        });


    }

}
*/