package com.qrilt.commune.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;
import com.qrilt.commune.view.view_holders.DayViewHolder;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;


public class DayAdapter extends RecyclerView.Adapter<DayViewHolder> {
    // Properties
    private Locale locale = Locale.getDefault();
    private ArrayList<LocalDate> days;

    // Constructors and Methods
    public DayAdapter(ArrayList<LocalDate> days) {
        this.days = days;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        LocalDate day = days.get(position);
        holder.letterTextView.setText(day.getDayOfWeek().getDisplayName(TextStyle.NARROW, locale));
        holder.numberTextView.setText(String.valueOf(day.getDayOfMonth()));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }
}
