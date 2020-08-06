package com.qrilt.commune.view.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;

public class YearViewHolder extends RecyclerView.ViewHolder {
    // Properties
    public TextView yearTextView;

    //Constructors and Methods
    public YearViewHolder(View view) {
        super(view);

        yearTextView = view.findViewById(R.id.view_holder_year_text_view);
    }
}
