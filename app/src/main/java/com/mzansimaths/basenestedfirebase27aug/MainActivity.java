package com.mzansimaths.basenestedfirebase27aug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity {
    List<ParentItem> itemList = new ArrayList<>();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button3);

        RecyclerView
                ParentRecyclerViewItem
                = findViewById(
                R.id.parent_recyclerview);


        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        ParentItemList();
        button.setOnClickListener(view -> {
            ParentItemAdapter parentItemAdapter = new ParentItemAdapter(itemList);


            ParentRecyclerViewItem.setLayoutManager(layoutManager);
            ParentRecyclerViewItem.setAdapter(parentItemAdapter);
        });

    }

    private List<ParentItem> ParentItemList()
    {


        DatabaseReference database;

        database = FirebaseDatabase.getInstance().getReference("ChildItemTitle");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                   // ParentItem item = dataSnapshot.getValue(ParentItem.class);
                    Log.d("Leonard", "onDataChange: "+dataSnapshot.getValue(String.class));
                    ParentItem itm1=new ParentItem(dataSnapshot.getValue(String.class),ChildItemList());

                   itemList.add(itm1);
                   itemList.add(itm1);
                   itemList.add(itm1);
                   itemList.add(itm1);
                   itemList.add(itm1);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        return itemList;
        //ParentItem item = new ParentItem("Title 1", ChildItemList());
        //itemList.add(item);
        //ParentItem item1 = new ParentItem("Title 2", ChildItemList());
        //itemList.add(item1);
        //ParentItem item2 = new ParentItem("Title 3", ChildItemList());
        //itemList.add(item2);
        //ParentItem item3 = new ParentItem("Title 4", ChildItemList());
        //itemList.add(item3);


    }


    private List<ChildItem> ChildItemList()
    {
        List<ChildItem> ChildItemList = new ArrayList<>();

        ChildItemList.add(new ChildItem("Card 1"));
        ChildItemList.add(new ChildItem("Card 2"));
        ChildItemList.add(new ChildItem("Card 3"));
        ChildItemList.add(new ChildItem("Card 4"));

        return ChildItemList;
    }
}

/*
1. Changing it in  firebase Itsef


2. To get the data from firebase and construct the data in ParentItem format
 */