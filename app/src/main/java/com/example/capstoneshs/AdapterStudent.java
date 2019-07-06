package com.example.capstoneshs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.ViewHolder> {

    private List<ModelClass> modelClassList;
    private OnNoteListener mOnNoteListener;
    public AdapterStudent(List<ModelClass> modelClassList, OnNoteListener onNoteListener) {
        this.modelClassList = modelClassList;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource = modelClassList.get(position).getImageResource();
        String title = modelClassList.get(position).getTitle();
        String body = modelClassList.get(position).getBody();
        String userId = modelClassList.get(position).getUserId();
        holder.setData(resource,title,body,userId);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView title;
        private TextView body;
        private String userId;
        OnNoteListener onNoteListener;
        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title_text_view);
            body = itemView.findViewById(R.id.body_text_view);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);

        }
        private void setData(int resource,String titleText,String bodyText,String id){
            imageView.setImageResource(resource);
            title.setText(titleText);
            body.setText(bodyText);
            userId = id;
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    public interface OnNoteListener{

        void onNoteClick(int position);
    }
}
