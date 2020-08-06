package com.qrilt.commune.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;
import com.qrilt.commune.model.TimeSlot;
import com.qrilt.commune.view.view_holders.TimeSlotViewHolder;

import java.util.ArrayList;

public class TimeSlotsAdapter extends RecyclerView.Adapter<TimeSlotViewHolder> {
    // Properties
    private Context context;
    ArrayList<TimeSlot> timeSlots;

    // Constructors and Methods
    public TimeSlotsAdapter(Context context, ArrayList<TimeSlot> timeSlots) {
        this.context = context;
        this.timeSlots = timeSlots;
    }

    @NonNull
    @Override
    public TimeSlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_time_slot, parent, false);
        return new TimeSlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeSlotViewHolder holder, int position) {
        final TimeSlot timeSlot = timeSlots.get(position);
        holder.startTimeTextView.setText(timeSlot.getStartDateTime().getHour() + " PM" + " - ");
        holder.endTimeTextView.setText(timeSlot.getEndDateTime().getHour() + " PM");

        holder.availableSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                timeSlot.setAvailable(b);
            }
        });

        // determine look
//        if (timeSlot.isAvailable()) {
//            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorBackgroundTimeSlotAvailable));
//            holder.startTimeTextView.setTextColor(ContextCompat.getColor(context, R.color.colorTextTimeSlotAvailable));
//            holder.endTimeTextView.setTextColor(ContextCompat.getColor(context, R.color.colorTextTimeSlotAvailable));
//        } else {
//            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorBackgroundTimeSlotUnavailable));
//            holder.startTimeTextView.setTextColor(ContextCompat.getColor(context, R.color.colorTextTimeSlotUnavailable));
//            holder.endTimeTextView.setTextColor(ContextCompat.getColor(context, R.color.colorTextTimeSlotUnavailable));
//        }
    }

    @Override
    public int getItemCount() {
        return timeSlots.size();
    }
}
