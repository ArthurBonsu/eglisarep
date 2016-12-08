package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pee on 1/5/2016.
 */
public class VIEWS extends Activity implements View.OnClickListener {
     Button comment = (Button)findViewById(R.id.comment);
     EditText commentwriter = (EditText)findViewById(R.id.commentwriter);
    TextView commentpaste = (TextView)findViewById(R.id.commentpaste);
    public VIEWS() {
        super();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.sendmessage);
            comment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (getTaskId()){
           case R.id.comment:

                 String comment = commentwriter.getText().toString();
                  commentpaste.setText(comment);
               break;
       }
    }
}
