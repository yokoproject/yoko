package com.example.eliyadaida.billboard.BusinessPage;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.eliyadaida.billboard.R;


/**
 * Created by eliyadaida on 1/6/15.
 */

public class BusinessPage extends android.app.Fragment {


    //creating the interface connecting between BusinessPage and Main activity
    public interface commercialListToMainActivity{
        public void getData(String title1, String title2, Drawable img);
    }

    static commercialListToMainActivity delegate;

    public void setDelegate(commercialListToMainActivity delegate){
        this.delegate = delegate;
    }



    public BusinessPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_business_page, container, false);


        ImageView profilePicture;
        ViewPager viewPager = null;


        viewPager = (ViewPager)root.findViewById(R.id.pager);
       // FragmentManager fragmentManager = getSupportFragmentManager();
       // viewPager.setAdapter(new MyAdapterPage(fragmentManager));



        profilePicture = (ImageView) root.findViewById(R.id.profile_picture);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        Bitmap resized = Bitmap.createScaledBitmap(bm, 195, 195, true);
        Bitmap conv_bm = getRoundedRectBitmap(resized, 300);
        profilePicture.setImageBitmap(conv_bm);


        return root;
    }









    public static Bitmap getRoundedRectBitmap(Bitmap bitmap, int pixels) {
        Bitmap result = null;
        try {
            result = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);

            int color = 0xff424242;
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, 300, 300);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawCircle(100, 100, 100, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);

        } catch (NullPointerException e) {
        } catch (OutOfMemoryError o) {
        }
        return result;
    }
}









/*
public class BusinessPage extends Fragment {

    ImageView profilePicture;
    ViewPager viewPager = null;

    public BusinessPage(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_business_page, container, false);

        viewPager = (ViewPager)root.findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapterPage(fragmentManager));



        profilePicture = (ImageView) root.findViewById(R.id.profile_picture);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        Bitmap resized = Bitmap.createScaledBitmap(bm, 195, 195, true);
        Bitmap conv_bm = getRoundedRectBitmap(resized, 300);
        profilePicture.setImageBitmap(conv_bm);

        return root;
    }



    public static Bitmap getRoundedRectBitmap(Bitmap bitmap, int pixels) {
        Bitmap result = null;
        try {
            result = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);

            int color = 0xff424242;
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, 300, 300);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawCircle(100, 100, 100, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);

        } catch (NullPointerException e) {
        } catch (OutOfMemoryError o) {
        }
        return result;
    }



*/

