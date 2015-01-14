package com.example.eliyadaida.billboard.CommercialPage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eliyadaida on 12/27/14.
 */
public class Commercial {
    String title;
    String subTitle;
   Drawable image;
    int resourceId;
    List<String> categories;
    Location location;

    public Commercial(String title, String subTitle,Drawable image,int resourceId, List<String> categories)
     {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
        this.resourceId = resourceId;
        this.categories = categories;
        location = new Location("CommercialProvider");
    }

    public String getTitle() {
        return title;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public List<String> getCategories() { return  categories; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

}
