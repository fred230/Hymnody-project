package com.fredrick.hymnal_ultimate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fredrick.hymnal_ultimate.Adapter.to_doAdapter;
import com.fredrick.hymnal_ultimate.model.New_Bookmark;

import java.util.ArrayList;
import java.util.List;

public class BookMark extends AppCompatActivity {
    RecyclerView recyclerView;
    private to_doAdapter bkadapter;

    private List<New_Bookmark> bk_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bk_list = new ArrayList<>();

        bkadapter = new to_doAdapter(this);
        recyclerView.setAdapter(bkadapter);

        New_Bookmark task = new New_Bookmark();
        task.setBookmark("yes");
        task.setPosition(1);
        bkadapter.setTasks(bk_list);

    }
}