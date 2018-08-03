package com.alan.aitstudentsupp0rt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class subjectAdapter extends RecyclerView.Adapter<subjectAdapter.subjectholder> {


    public class subjectholder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView subname;
        public TextView attend ;
        public TextView bunk ;

        public Button attendButton;
        public Button bunkButton ;
        public Button updateButton ;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public subjectholder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            subname = (TextView) itemView.findViewById(R.id.subject);
            attend = (TextView) itemView.findViewById(R.id.attendance);
            bunk =  (TextView) itemView.findViewById(R.id.bunk);

            attendButton = (Button) itemView.findViewById(R.id.attends);
            bunkButton = (Button) itemView.findViewById(R.id.bunks);
            updateButton = (Button) itemView.findViewById(R.id.cancelled);

            attendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //adds attendance of that class
                }
            });

            bunkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //adds bunks of class
                }
            });

            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //updates previous data on subject not entered beforehand
                }
            });
        }


    }

    private List<subject> subjects;

    public subjectAdapter(List<subject> subjectList ){
        subjects = subjectList;
    }

    @Override
    public subjectholder onCreateViewHolder(ViewGroup parent , int viewtype){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_message, parent, false);

        // Return a new holder instance
        subjectAdapter.subjectholder viewHolder = new subjectholder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(subjectAdapter.subjectholder viewHolder, int position) {
        // Get the data model based on position
        subject sub=subjects.get(position);
        TextView tvname = viewHolder.subname;
        tvname.setText(sub.getSubname());
        TextView tvatt = viewHolder.attend;
        tvatt.setText(sub.getPercentage());
        TextView tvbunks = viewHolder.bunk;
        tvbunks.setText(sub.getBunks());


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return 0;
    }

}
