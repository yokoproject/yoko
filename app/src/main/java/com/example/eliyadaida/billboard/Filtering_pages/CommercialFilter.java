package com.example.eliyadaida.billboard.Filtering_pages;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by eliyadaida on 1/11/15.
 */
public class CommercialFilter implements Serializable {


    private float distance = 0;                                 //the distance that the user choose for the filtering
    private List<String> categories = new ArrayList<String>();  //the categories that the user choose for the filtering


    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
