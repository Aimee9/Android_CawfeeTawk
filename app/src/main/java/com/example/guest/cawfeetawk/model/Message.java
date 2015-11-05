package com.example.guest.cawfeetawk.model;

import android.app.Activity;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Guest on 11/5/15.
 */

public class Message {

    String mMessageText;

    public Message(String text){
        mMessageText = text;
    }

    public String getMessageText() {
        return mMessageText;
    }

    public void setMessageText(String messageText) {
        mMessageText = messageText;
    }



    public static ArrayList<Message> all(final Activity context, final Runnable runnable) {
        final ArrayList<Message> messages = new ArrayList<>();


        ParseQuery<ParseObject> query = ParseQuery.getQuery("NewMessage");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for(int i = 0; i < objects.size(); i++){
                        Log.d("parse", ""+ objects.size());
                        ParseObject parseMessage = objects.get(i);
                        ParseObject parseContent = parseMessage.getParseObject("content");
                        Log.d("parse", "content" + parseContent.getString("content"));
                        Message message = new Message(parseMessage.getString("content"));
                        messages.add(message);

                        context.runOnUiThread(runnable);

                    }
                } else {
                    Log.d("parse", "failed request!" + e);
                }
            }
        });
        return messages;
    }

}