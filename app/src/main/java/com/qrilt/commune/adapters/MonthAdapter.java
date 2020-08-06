package com.qrilt.commune.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;
import com.qrilt.commune.view.view_holders.MonthViewHolder;

import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class MonthAdapter extends RecyclerView.Adapter<MonthViewHolder> {
    // Properties
    private Locale locale = Locale.getDefault();
    private ArrayList<YearMonth> months;

    // Constructors and Methods
    public MonthAdapter(ArrayList<YearMonth> months) {
        this.months = months;
    }

    @NonNull
    @Override
    public MonthViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_month, parent, false);
        return new MonthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthViewHolder viewHolder, int position) {
        viewHolder.monthTextView.setText(months.get(position).getMonth().getDisplayName(TextStyle.FULL, locale));
    }

    @Override
    public int getItemCount() {
        return months.size();
    }
}
