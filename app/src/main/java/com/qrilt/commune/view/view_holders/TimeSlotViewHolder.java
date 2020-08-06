package com.qrilt.commune.view.view_holders;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;

public class TimeSlotViewHolder extends RecyclerView.ViewHolder {
    // Properties
    public CardView cardView;
    public TextView startTimeTextView, endTimeTextView;
    public Switch availableSwitch;

    // Constructors and Methods
    public TimeSlotViewHolder(View view) {
        super(view);

        startTimeTextView = view.findViewById(R.id.view_holder_time_slot_start_text_view);
        endTimeTextView = view.findViewById(R.id.view_holder_time_slot_end_text_view);
        availableSwitch = view.findViewById(R.id.view_holder_time_slot_available_switch);
    }
}
