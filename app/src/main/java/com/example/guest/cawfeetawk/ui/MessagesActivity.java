package com.example.guest.cawfeetawk.ui;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.cawfeetawk.R;
import com.example.guest.cawfeetawk.adapter.ListAdapter;
import com.example.guest.cawfeetawk.model.Message;

import java.util.ArrayList;

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
        mMessages = (ArrayList)Message.all();
        mAdapter = new ListAdapter(this, mMessages);
        setListAdapter(mAdapter);

        mDiscussButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = mMessageText.getText().toString();
                Message message = new Message(userMessage);
                message.save();
                mMessages.add(message);
                mAdapter.notifyDataSetChanged();

                mMessageText.setText("");
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }


}
