package com.example.eliyadaida.billboard.CommercialList;


import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.eliyadaida.billboard.CommercialPage.Commercial;

import com.example.eliyadaida.billboard.Filtering_pages.CommercialFilter;
import com.example.eliyadaida.billboard.R;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class CommercialList extends Fragment {

    //creating the interface connecting between commercialList and Main activity
    public interface commercialListToMainActivity{
    public void getData(String title1, String title2, Drawable img);
}

    static commercialListToMainActivity delegate;

    public void setDelegate(commercialListToMainActivity delegate){
        this.delegate = delegate;
    }


    public CommercialList() {
        // Required empty public constructor
    }

    CommercialFilter commercialFilter;
    ListView listView;
    ArrayList<Commercial> commercialsList;
    Activity c;
    Button moreDetails;
    MyAdapter adapter;
    Location currentLocation;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_commercial_list, container, false);

        listView = (ListView) root.findViewById(R.id.commercialListView);

        commercialsList = new ArrayList<Commercial>();

        Drawable img1 = getResources().getDrawable(R.drawable.hamburger);
        commercialsList.add(new Commercial("Burger", "1+1", img1,R.drawable.hamburger, Arrays.asList("Food")));

        Drawable img2 = getResources().getDrawable(R.drawable.underwear) ;
        commercialsList.add(new Commercial("underwear", "buy one get one", img2, R.drawable.underwear, Arrays.asList("Clothing")));

        Drawable img3 = getResources().getDrawable(R.drawable.cat);
        commercialsList.add(new Commercial("cats food", "30%", img3, R.drawable.cat, Arrays.asList("Animals")));

        Drawable img4 =  getResources().getDrawable(R.drawable.coffee);
        commercialsList.add(new Commercial("coffee", "coffee with free cake for 10NIS", img4,R.drawable.coffee, Arrays.asList("Food", "Pub")));
       // listView.setAdapter(new MyAdapter());

         adapter = new MyAdapter();
        listView.setAdapter(adapter);


        return root;
    }




    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return commercialsList.size();
        }

        @Override
        public Object getItem(int position) {
            return commercialsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View itemView, ViewGroup parent) {

            Commercial commercial =(Commercial) listView.getItemAtPosition(position);
            int i = position;


            if(itemView == null)
            {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                itemView = inflater.inflate(R.layout.commercials_template,null);
            }


            final Commercial currentCommercial = commercialsList.get(i);
            TextView title = (TextView)itemView.findViewById(R.id.commercialTitleId);
            title.setText(currentCommercial.getTitle());

            TextView subTitle = (TextView)itemView.findViewById(R.id.commercialSubTaitleId);
            subTitle.setText(currentCommercial.getSubTitle());

            ImageView image = (ImageView)itemView.findViewById(R.id.commercialImageId);
            image.setImageDrawable(currentCommercial.getImage());



            //sent the parameters from the commercial to the commercial page
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(delegate!=null){
                        delegate.getData(currentCommercial.getTitle(),currentCommercial.getSubTitle(),currentCommercial.getImage());
                    }

                }
            });
/*
            Button button = (Button)itemView.findViewById(R.id.moreDedailButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(c);
                    DialogMoreDetails detailsDialog= new DialogMoreDetails(dialog);
                }
            });



            //sent the parameters from the commercial to the commercial page
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(delegate!=null){
                        delegate.getData(currentCommercial.getTitle(),currentCommercial.getSubTitle(),currentCommercial.getImage());
                    }

                }
            });

      /*      if ((commercialFilter.getDistance() > 0) && (currentLocation != null) && (currentLocation.distanceTo(commercial.getLocation()) > commercialFilter.getDistance()))
            {
                itemView.setVisibility(View.GONE);
            }
            else
            {
                itemView.setVisibility(View.VISIBLE);
            }

*/
            return  itemView;


        }
    }

    }



