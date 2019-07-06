package com.example.capstoneshs;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.ViewHolder> {

    private List<AnnouncementClass> announcementClassList;
    private AnnouncementListener mannouncementListener;

    public AnnouncementAdapter(List<AnnouncementClass> announcementClassList, AnnouncementListener announcementListener) {
        this.announcementClassList = announcementClassList;
        this.mannouncementListener = announcementListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_layout,parent,false);
        return new ViewHolder(view, mannouncementListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String Subject = announcementClassList.get(position).getSubject();
        String Message = announcementClassList.get(position).getMessage();
        String Date = announcementClassList.get(position).getDate();
        String Location = announcementClassList.get(position).getLocation();
        String Time = announcementClassList.get(position).getTime();
        holder.setData(Subject,Message,Date,Location,Time);
    }

    @Override
    public int getItemCount() {
        return announcementClassList.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView subject,message,date,location,time;
        private ImageView img;
        AnnouncementListener announcementListener;
        public ViewHolder(@NonNull View itemView, AnnouncementListener announcementListener) {
            super(itemView);
            subject = itemView.findViewById(R.id.subject);
            message = itemView.findViewById(R.id.message);
            date = itemView.findViewById(R.id.date);
            img = itemView.findViewById(R.id.menu);
            location = itemView.findViewById(R.id.location);
            time = itemView.findViewById(R.id.time);
            this.announcementListener = announcementListener;
            itemView.setOnClickListener(this);
        }
        private void setData(String Subject, String Message, String Date,String Location, String Time){
            subject.setText(Subject);
            message.setText(Message);
            date.setText(Date);
            location.setText(Location);
            time.setText(Time);
        }

        @Override
        public void onClick(View v) {
            announcementListener.onAnnouncementClick(getAdapterPosition());
        }
    }

    public interface AnnouncementListener{
        void onAnnouncementClick(int position);
    }
}
