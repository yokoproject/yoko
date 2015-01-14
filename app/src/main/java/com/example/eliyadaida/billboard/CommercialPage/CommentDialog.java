package com.example.eliyadaida.billboard.CommercialPage;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eliyadaida.billboard.R;

import java.util.Vector;

/**
 * Created by eliyadaida on 1/3/15.
 */


public class CommentDialog extends Fragment {


    public CommentDialog() {
        // Required empty public constructor
    }

    String comment;
    Dialog dialog;
    Button save;
    EditText editTextComment;
    TextView singeComment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.comment_dialog, container, false);


        return root;
    }

}


/*
public class CommentDialog extends Activity {

    String comment;
    Dialog dialog;
    Button save;
    EditText editTextComment;
    TextView singeComment;



    public CommentDialog(Dialog dialog, final Vector<String> commentList) {

        comment = "";
        this.dialog = dialog;
        dialog.setContentView(R.layout.comment_dialog);
        dialog.show();
        save = (Button) findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextComment = (EditText) findViewById(R.id.editText);

              //  singeComment = (TextView) findViewById(R.id.comments);
                comment = editTextComment.getText().toString();
                commentList.add(comment);

            }
        });


    }

}
*/