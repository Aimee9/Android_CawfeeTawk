package com.example.guest.cawfeetawk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.guest.cawfeetawk.R;
import com.example.guest.cawfeetawk.model.Message;

import java.util.ArrayList;

/**
 * Created by Guest on 11/5/15.
 */
public class ListAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<Message>mMessages;

    public ListAdapter(Context context, ArrayList<Message> messages) {
        mContext = context;
        mMessages = messages;
    }

    @Override
    public int getCount() {
        return mMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return mMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.single_message_item, null);
            holder = new ViewHolder();
            holder.messageLabel = (TextView)convertView.findViewById(R.id.messageLabel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Message message = mMessages.get(position);
        holder.messageLabel.setText(message.getMessageText());

        return convertView;
    }

    private static class ViewHolder{
        TextView messageLabel;
    }

}
