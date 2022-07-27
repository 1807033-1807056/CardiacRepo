package com.example.cardiacrecorderapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>  {


    private ArrayList<Record>arrayList;
    private RecyclerViewClicklistener listener;

    public RecyclerAdapter(ArrayList<Record> arrayList, RecyclerViewClicklistener listener) {
        this.arrayList = arrayList;
        this.listener=listener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        String pressure_systolic= arrayList.get(position).getSystolic();
        String pressure_diastolic= arrayList.get(position).getDiastolic();

        String pressure="Pressure is: "+ pressure_diastolic + "/" +pressure_systolic + "mm Hg";
        String date=arrayList.get(position).getDate();
        date = "on : " + date;
        holder.pressure.setText(pressure);
        holder.date.setText(date);

        holder.delete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Record theRemovedItem = arrayList.get(position);
                String date= arrayList.get(position).getDate();
                String time=arrayList.get(position).getTime();
                DatabaseHelper db=new DatabaseHelper(v.getContext());
                db.DeleteData(date,time);
                arrayList.remove(position);  // remove the item from list
                notifyItemRemoved(position); // notify the adapter about the removed item
                notifyItemRangeChanged(position,getItemCount());

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView pressure;
        private TextView date;
        private Button delete;
        private Button update;

        public MyViewHolder(final View itemView) {
            super(itemView);
            pressure=itemView.findViewById(R.id.pressure_id);
            date=itemView.findViewById(R.id.date_id);
            delete=itemView.findViewById(R.id.delete_data);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }

    public interface RecyclerViewClicklistener
    {
        void onClick(View v, int position);
    }
}
