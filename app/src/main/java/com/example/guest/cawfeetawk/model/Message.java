package com.example.guest.cawfeetawk.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Guest on 11/5/15.
 */
@Table(name = "Messages", id = "_id")
public class Message extends Model {

    @Column(name = "Content")
    private String mContent;

    public Message() {
        super();
    }

    public Message(String content) {
        mContent = content;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public static List<Message> all(){
        return new Select()
                .from(Message.class)
                .execute();
    }
}
