package com.fredrick.hymnal_ultimate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fredrick.hymnal_ultimate.BookMark;
import com.fredrick.hymnal_ultimate.R;
import com.fredrick.hymnal_ultimate.model.New_Bookmark;

import java.util.List;

public class to_doAdapter extends RecyclerView.Adapter<to_doAdapter.ViewHolder> {

    private List<New_Bookmark> bookmark_list;
    private BookMark activity;

    public to_doAdapter(BookMark activity){
        this.activity = activity;



    };

    public ViewHolder onCreateViewHolder( ViewGroup parent, int ViewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bk,parent,false);
        return new ViewHolder(itemView);

    }
    public void onBindViewHolder(ViewHolder holder, int position){
        New_Bookmark item = bookmark_list.get(position);
        holder.task.setText(item.getBookmark());
    }

    @Override
    public int getItemCount() {
        return bookmark_list.size() ;


    };

    public void setTasks(List<New_Bookmark> bookmark_list){
        this.bookmark_list = bookmark_list;
        notifyDataSetChanged();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView task;
        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.title_bk_txt);
        }



    }




}
