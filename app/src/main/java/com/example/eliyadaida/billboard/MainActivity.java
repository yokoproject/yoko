package com.example.eliyadaida.billboard;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.app.ActionBar.Tab;
import com.example.eliyadaida.billboard.BusinessPage.BusinessPage;
import com.example.eliyadaida.billboard.BusinessPage.FragmentA_about;
import com.example.eliyadaida.billboard.BusinessPage.FragmentB_gallery;
import com.example.eliyadaida.billboard.BusinessPage.FragmentC_previousCommercials;
import com.example.eliyadaida.billboard.CommercialList.CommercialList;
import com.example.eliyadaida.billboard.CommercialPage.Commercial;
import com.example.eliyadaida.billboard.CommercialPage.CommercialPage;
import com.example.eliyadaida.billboard.Filtering_pages.CommercialFilter;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    private static final long LOCATION_REFRESH_TIME = 10000;
    private static final float LOCATION_REFRESH_DISTANCE = 100;
    private static final int FILTER_REQUEST_CODE = 43;

    public CommercialFilter commercialFilter = new CommercialFilter();

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }


    /* public void setDistanceFilter(float distance) {
         commercialFilter.setDistance(distance);
         MyListAdapter adapter = (MyListAdapter) listView.getAdapter();
         adapter.notifyDataSetInvalidated();
     }
 */
    interface interface1 {
        public void getData(String mainTitle, String subTitle2, Drawable img);
    }

    public interface1 delegate;

    public void setDelegate(interface1 delegate) {
        this.delegate = delegate;
    }

    public interface1 getDelegate() {
        return delegate;
    }

    ListView listView;
    ArrayList<Commercial> commercialsList;
    Activity c;
    Button moreDetails;
    ArrayList<String> commentArray;
    Button goToFilterPageBtn;

    ViewPager Tab;
    TabPagerAdapter TabAdapter;
    ActionBar actionBar;



    CommercialPage commercialPage = new CommercialPage();

    BusinessPage businessPage = new BusinessPage();

    CommercialList commercialList;

    LocationManager mLocationManager;

    Location currentLocation;

    /*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

          if (requestCode == FILTER_REQUEST_CODE)
            {

                if (resultCode == RESULT_OK)
                {
                    commercialFilter = (CommercialFilter) data.getSerializableExtra("Filter");
                    MyListAdapter adapter = (MyListAdapter)listView.getAdapter();
                    adapter.notifyDataSetInvalidated();
                }
            }
        }
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commercialList = new CommercialList();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.add(R.id.fragment_container, commercialList);

        //   transaction.addToBackStack("Commercial List Fragment");

        transaction.commit();

        commercialList.setDelegate(new CommercialList.commercialListToMainActivity() {
            @Override
            public void getData(String title1, String title2, Drawable img) {


                commercialPage.setData(title1, title2, img);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.add(R.id.fragment_container, commercialPage);


                // getFragmentManager().popBackStack();

                transaction.hide(commercialList);

                //   transaction.addToBackStack("Commercial Page Fragment");

                //Log.d("Load Commercial Page Fragment","msg");

                transaction.commit();


            }
        });


        commercialPage.setDelegate(new CommercialPage.commercialPageToMainActivity() {
            @Override
            public void getData() {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                transaction.add(R.id.fragment_container, businessPage);


                //   getFragmentManager().popBackStack();

                transaction.hide(commercialPage);

                //  transaction.addToBackStack("Business Page Fragment");

                //Log.d("Load Commercial Page Fragment","msg");

                transaction.commit();


            }
        });


        /*
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        actionBar = getActionBar();
                        actionBar.setSelectedNavigationItem(position);                    }
                });
        Tab.setAdapter(TabAdapter);
        actionBar = getActionBar();
        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
            @Override
            public void onTabReselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                Tab.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub
            }};
        //Add New Tab
        actionBar.addTab(actionBar.newTab().setText("Android").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("iOS").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Windows").setTabListener(tabListener));
        */
    }





        /*


        //set the filter button and send you to the filter page when you pressed on the button
        goToFilterPageBtn = (Button)findViewById(R.id.go_to_filter_page);
        goToFilterPageBtn.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent intent = new Intent(MainActivity.this, FilterPage.class);
                                                        intent.putExtra("Filter", commercialFilter);
                                                     MainActivity.this.startActivityForResult(intent, FILTER_REQUEST_CODE);

                                                 }
                                             });


        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (mLocationManager != null) {
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME,
                    LOCATION_REFRESH_DISTANCE, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            currentLocation = location;

                            MyListAdapter adapter = (MyListAdapter)listView.getAdapter();
                            adapter.notifyDataSetInvalidated();

                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    });
        }
    }


    private class MyListAdapter extends ArrayAdapter<Commercial>
    {


        public MyListAdapter() {
            super(c,R.layout.commercials_template,commercialsList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            Commercial commercial =(Commercial) getItem(position);

            int i = position;


            if(itemView == null)
            {
                itemView = c.getLayoutInflater().inflate(R.layout.commercials_template,parent,false);
            }


            final Commercial currentCommercial = commercialsList.get(i);
            TextView title = (TextView)itemView.findViewById(R.id.commercialTitleId);
            title.setText(currentCommercial.getTitle());

            TextView subTitle = (TextView)itemView.findViewById(R.id.commercialSubTaitleId);
            subTitle.setText(currentCommercial.getSubTitle());

            ImageView image = (ImageView)itemView.findViewById(R.id.commercialImageId);
            image.setImageDrawable(currentCommercial.getImage());

            Button button = (Button)itemView.findViewById(R.id.moreDedailButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(c);
                    DialogMoreDetails detailsDialog= new DialogMoreDetails(dialog);
                }
            });
*/
    //sent the parameters from the commercial to the commercial page
           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, CommercialPage.class);

                    if(delegate!=null)
                    {
                        delegate.getData(currentCommercial.getTitle(), currentCommercial.getSubTitle(), currentCommercial.getImage());
                    }
                    MainActivity.this.startActivity(intent);
                }
            });

            if ((commercialFilter.getDistance() > 0) && (currentLocation != null) && (currentLocation.distanceTo(commercial.getLocation()) > commercialFilter.getDistance()))
            {
                itemView.setVisibility(View.GONE);
            }
            else
            {
                itemView.setVisibility(View.VISIBLE);
            }

            return  itemView;

        }
    }
*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class TabPagerAdapter extends FragmentStatePagerAdapter {
        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }
        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    //Fragement for Android Tab
                    return new FragmentC_previousCommercials();
                case 1:
                    //Fragment for Ios Tab
                    return new FragmentB_gallery();
                case 2:
                    //Fragment for Windows Tab
                    return new FragmentA_about();
            }
            return null;
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 3; //No of Tabs
        }
    }


}
