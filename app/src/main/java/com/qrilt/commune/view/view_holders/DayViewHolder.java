package com.qrilt.commune.view.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;

public class DayViewHolder extends RecyclerView.ViewHolder {
    // Properties
    public TextView letterTextView, numberTextView;

    // Constructors and Methods
    public DayViewHolder(View view) {
        super(view);

        letterTextView = view.findViewById(R.id.view_holder_day_letter_text_view);
        numberTextView = view.findViewById(R.id.view_holder_day_number_text_view);
    }
}
