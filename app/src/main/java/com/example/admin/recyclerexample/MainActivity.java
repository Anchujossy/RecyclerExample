package com.example.admin.recyclerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "inside";
    RecyclerView recyclerView;
    ArrayList<UserDetails> arrayList;
    ItemArrayAdapter itemArrayAdapter;
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = Realm.getInstance(this);
        // Initializing list view with the custom adapter
        ArrayList<Item> itemList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                mRealm.beginTransaction();


                for (int i = 0; i < response.body().size(); i++) {

                    recyclerView.setAdapter(null);
                    arrayList = new ArrayList<>();
                    arrayList.clear();
                    UserDetails user = mRealm.createObject(UserDetails.class);
                    user.setUserEmail(response.body().get(i).getEmail());
                    Log.d(TAG, response.body().size() + "");
                    user.setUserName(response.body().get(i).getUsername());
                    user.setUserAddress(response.body().get(i).getAddress().getStreet());
                    user.setUserId(String.valueOf(response.body().get(i).getId()));
                    Log.d("username", user.getUserName() + "");
                    arrayList.add(user);
                    itemArrayAdapter = new ItemArrayAdapter(mRealm.allObjects(UserDetails.class), getApplicationContext(),user);
                    itemArrayAdapter.notifyDataSetChanged();
                }
                mRealm.commitTransaction();
                recyclerView.setAdapter(itemArrayAdapter);

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }


        });

    }
}