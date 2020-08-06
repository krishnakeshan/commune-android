package com.qrilt.commune.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.R;
import com.qrilt.commune.view.view_holders.YearViewHolder;

import java.time.Year;
import java.util.ArrayList;

public class YearAdapter extends RecyclerView.Adapter<YearViewHolder> {
    // Properties
    private ArrayList<Year> years;

    // Constructors and Methods
    public YearAdapter(ArrayList<Year> years) {
        this.years = years;
    }

    @NonNull
    @Override
    public YearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_year, parent, false);
        return new YearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YearViewHolder viewHolder, int position) {
        viewHolder.yearTextView.setText(years.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return years.size();
    }
}
