package com.example.admin.recyclerexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.RealmResults;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.MyViewHolder> {
Context context;
    RealmResults<UserDetails> results;
UserDetails userDetails;

    public ItemArrayAdapter(RealmResults<UserDetails> userDetails, Context applicationContext,UserDetails userDetails1) {
        this.results = userDetails;
        this.userDetails=userDetails1;
        context=applicationContext;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username, emailid, address, userid;

        public MyViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.rgt_tv_username);
            emailid = (TextView) view.findViewById(R.id.rgt_tv_emailid);
            address = (TextView) view.findViewById(R.id.rgt_tv_useraddress);
            userid = (TextView) view.findViewById(R.id.rgt_tv_userid);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        for (int i = 0; i < results.size(); i++) {
            Log.d("arraysize",results.get(i).getUserName()+"");

            holder.username.setText(results.get(i).getUserName());
            holder.userid.setText(userDetails.getUserId());
            holder.emailid.setText(userDetails.getUserEmail());
            holder.address.setText(userDetails.getUserAddress()+"");
        }

    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}