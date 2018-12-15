package com.example.tech2k8.todo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NotesListViewHolder> {

    private ArrayList<String> dataFromDb;
    private Context context;

    public NotesListAdapter(Context context,ArrayList<String> data)
    {
        dataFromDb=data;
        this.context=context;
    }

    @NonNull
    @Override
    public NotesListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rowLayout =LayoutInflater.from(context).inflate(R.layout.notes_list_row,viewGroup,false);
        NotesListViewHolder holder =new NotesListViewHolder(rowLayout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListViewHolder notesListViewHolder, int postion)
    {
        notesListViewHolder.notesTitle.setText(dataFromDb.get(postion));
    }

    @Override
    public int getItemCount() {
        return dataFromDb.size();
    }

    class NotesListViewHolder extends RecyclerView.ViewHolder
    {

        TextView notesTitle;
        public NotesListViewHolder(@NonNull View itemView) {
            super(itemView);
            notesTitle=itemView.findViewById(R.id.title);
        }
    }
}
