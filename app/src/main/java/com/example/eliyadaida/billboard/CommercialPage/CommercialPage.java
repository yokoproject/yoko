package com.example.eliyadaida.billboard.CommercialPage;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.example.eliyadaida.billboard.BusinessPage.BusinessPage;
import com.example.eliyadaida.billboard.MainActivity;
import com.example.eliyadaida.billboard.R;

import java.util.Vector;

/**
 * Created by eliyadaida on 12/31/14.
 */


public class CommercialPage extends Fragment {


    //creating the interface connecting between commercialPage and Main activity
    public interface commercialPageToMainActivity{
        public void getData();
    }

    static commercialPageToMainActivity delegate;

    public void setDelegate(commercialPageToMainActivity delegate){
        this.delegate = delegate;
    }



    static  Vector<String> commentList;


    TextView title;
    TextView subTitle;
    ImageView image;
    String firstTitle;
    String secondTitle;
    Drawable mainImage;
    ListView comment_list;
    Button goToBusinessPage;
    MyAdapter adapter;
    Button moreDedails;


    //set the the data that I get from the main Activity
    public void setData(String mainTitle, String subTitle, Drawable img){
        firstTitle = mainTitle;
        secondTitle = subTitle;
        mainImage = img;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_commercial_page, container, false);




        commentList = new Vector<String>();
        adapter = new MyAdapter();

        title = (TextView)root.findViewById(R.id.commercialTitleId);
        subTitle=(TextView)root.findViewById(R.id.commercialSubTaitleId);
        image=(ImageView)root.findViewById(R.id.commercialImageId);

        title.setText(firstTitle);
        subTitle.setText(secondTitle);
        image.setImageDrawable(mainImage);


        //when you press you go to the business page
        goToBusinessPage = (Button)root.findViewById(R.id.goToBusinessPageBtn);
        goToBusinessPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delegate!=null){
                    delegate.getData();
                }

            }
        });

        moreDedails = (Button)root.findViewById(R.id.more_details_btn);
        moreDedails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new DialogFragment();

            }
        });


/*
        //creating the button that create a new comment on the commercial
        Button commentBtn = (Button)root.findViewById(R.id.commentB);
        commentBtn.setOnClickListener(new View.OnClickListener() {

            //dialog comment
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(CommercialPage.this);
                CommentDialog commentDialog= new CommentDialog(dialog,commentList);
            }
        });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                     //editTextComment = (EditText)findViewById(R.id.editText);

                     //singeComment = (TextView)findViewById(R.id.comments);
                  //   commentDialog.comment = editTextComment.getText().toString();
                  //   commentList.add(commentDialog.comment);

                    }
                });*/

        comment_list = (ListView)root.findViewById(R.id.comment_list);
        comment_list.setAdapter(adapter);



        // commentListView.setAdapter(new MyListAdapterComment());


        return root;

    }



    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return commentList.size();
        }

        @Override
        public Object getItem(int i) {
            return commentList.elementAt(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View itemView, ViewGroup parent)
        {
            if(itemView == null)
            {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                itemView = inflater.inflate(R.layout.comment_item,null);
            }


            TextView tv = (TextView)itemView.findViewById(R.id.comments);

            tv.setText(commentList.get(position));
          //  editTextComment.setText("");

            return itemView;
        }
    }


  /*  public void openConnection() {
        mainActivity.setDelegate(new MainActivity.interface1() {
            @Override
            public void getData(String mainTitle, String subTitle2,Drawable img) {
                firstTitle=mainTitle;
                secondTitle=subTitle2;
                mainImage = img;
            }
        });
    }

*/


}
