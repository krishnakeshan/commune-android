package com.qrilt.commune.view.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;

public class MonthViewHolder extends RecyclerView.ViewHolder {
    // Properties
    public TextView monthTextView;

    // Constructors and Methods
    public MonthViewHolder(View view) {
        super(view);

        monthTextView = view.findViewById(R.id.view_holder_month_text_view);
    }
}
