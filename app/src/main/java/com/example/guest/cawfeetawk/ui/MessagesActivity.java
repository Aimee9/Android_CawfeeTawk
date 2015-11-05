package com.example.guest.cawfeetawk.ui;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.cawfeetawk.R;
import com.example.guest.cawfeetawk.adapter.ListAdapter;
import com.example.guest.cawfeetawk.model.Message;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessagesActivity extends ListActivity {

    private Button mDiscussButton;
    private EditText mMessageText;
    private ArrayList<Message>mMessages;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        mDiscussButton = (Button)findViewById(R.id.discussButton);
        mMessageText = (EditText)findViewById(R.id.messageText);
        mMessages = new ArrayList<Message>();
        mAdapter = new ListAdapter(this, mMessages);
        setListAdapter(mAdapter);

        mDiscussButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userMessage = mMessageText.getText().toString();
                ParseObject newMessage = new ParseObject("NewMessage");
                newMessage.put("content", userMessage);
                newMessage.saveInBackground();

//                ParseQuery<ParseObject> query = ParseQuery.getQuery("NewMessage");
//                query.findInBackground(new FindCallback<ParseObject>() {
//                    @Override
//                    public void done(List<ParseObject> objects, ParseException e) {
//                        if (e==null) {
//                            for(int i=0; i< objects.size(); i++) {
//                                ParseObject parseMessage = objects.get(i);
//                                Message message = new Message(parseMessage.getString("content"));
//                                mMessages.add(message);
//                                mAdapter.notifyDataSetChanged();
//                            }
//
//                        } else {
//                            Log.d("parse", "failed!" +e);
//                        }
//                    }
//                });


                //Message message = new Message(userMessage);
//                message.save();
//                mMessages.add(message);
//                mAdapter.notifyDataSetChanged();

                mMessageText.setText("");
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }


}
