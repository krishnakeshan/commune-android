package com.qrilt.commune;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qrilt.commune.adapters.DayAdapter;
import com.qrilt.commune.adapters.MonthAdapter;
import com.qrilt.commune.adapters.TimeSlotsAdapter;
import com.qrilt.commune.adapters.YearAdapter;
import com.qrilt.commune.model.TimeSlot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Properties
    private Locale locale = Locale.getDefault();
    private LocalDateTime current;
    private ArrayList<Year> years = new ArrayList<>();
    private ArrayList<YearMonth> months = new ArrayList<>();
    private ArrayList<LocalDate> days = new ArrayList<>();
    private ArrayList<TimeSlot> timeSlots = new ArrayList<>();

    private Year selectedYear;
    private YearMonth selectedMonth;
    private LocalDate selectedDay;

    // Views
    private RecyclerView yearRecyclerView, monthRecyclerView, dayRecyclerView, timeSlotsRecyclerView;
    private TextView selectedDateTextView;

    private RecyclerView.Adapter yearRecyclerViewAdapter, monthRecyclerViewAdapter, dayRecyclerViewAdapter, timeSlotsRecyclerViewAdapter;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind views
        yearRecyclerView = findViewById(R.id.activity_main_year_recycler_view);
        monthRecyclerView = findViewById(R.id.activity_main_month_recycler_view);
        dayRecyclerView = findViewById(R.id.activity_main_day_recycler_view);
        selectedDateTextView = findViewById(R.id.activity_main_selected_date_text_view);
        timeSlotsRecyclerView = findViewById(R.id.activity_main_time_slots_recycler_view);

        // setup RecyclerViews
        yearRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        monthRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        dayRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        timeSlotsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // setup Adapters
        yearRecyclerViewAdapter = new YearAdapter(years);
        yearRecyclerView.setAdapter(yearRecyclerViewAdapter);
        monthRecyclerViewAdapter = new MonthAdapter(months);
        monthRecyclerView.setAdapter(monthRecyclerViewAdapter);
        dayRecyclerViewAdapter = new DayAdapter(days);
        dayRecyclerView.setAdapter(dayRecyclerViewAdapter);
        timeSlotsRecyclerViewAdapter = new TimeSlotsAdapter(this, timeSlots);
        timeSlotsRecyclerView.setAdapter(timeSlotsRecyclerViewAdapter);

        // populate and select first year, month, and date
        current = LocalDateTime.now();
        years.add(Year.of(2020));
        years.add(Year.of(2021));
        selectYear(years.get(0));
        selectMonth(months.get(0));
        selectDay(days.get(0));
        updateSelectedDateDisplay();
    }

    // method to update current date display
    public void updateSelectedDateDisplay() {
        String text = selectedDay.getDayOfWeek().getDisplayName(TextStyle.FULL, locale) + ", " + selectedDay.getDayOfMonth() + " " + selectedMonth.getMonth().getDisplayName(TextStyle.FULL, locale);
        selectedDateTextView.setText(text);
    }

    // method to select an year
    public void selectYear(Year year) {
        selectedYear = year;

        // update months list
        populateMonths();
        monthRecyclerViewAdapter.notifyDataSetChanged();
    }

    // method to select a month
    public void selectMonth(YearMonth month) {
        selectedMonth = month;

        // update days list
        populateDays();
        dayRecyclerViewAdapter.notifyDataSetChanged();
    }

    // method to select a day
    public void selectDay(LocalDate day) {
        selectedDay = day;

        // populate time slots
        populateTimeSlots();
        timeSlotsRecyclerViewAdapter.notifyDataSetChanged();
    }

    // method to populate months for selected Year
    public void populateMonths() {
        // generate all months
        months.clear();
        if (selectedYear.isAfter(Year.of(current.getYear()))) {
            for (Month month : Month.values()) {
                months.add(selectedYear.atMonth(month));
            }
        } else {
            for (Month month : Month.values()) {
                if (month.getValue() >= current.getMonthValue()) {
                    months.add(selectedYear.atMonth(month));
                }
            }
        }
    }

    // method to populate days for selected YearMonth
    public void populateDays() {
        days.clear();
        int numDays = selectedMonth.lengthOfMonth();
        for (int day = 1; day <= numDays; day++) {
            // add only remaining days of this month
            if (current.getYear() == selectedYear.getValue() && current.getMonthValue() == selectedMonth.getMonthValue()) {
                if (day >= current.getDayOfMonth()) {
                    days.add(selectedMonth.atDay(day));
                }
            }

            // add all days of other months
            else {
                days.add(selectedMonth.atDay(day));
            }
        }
    }

    // method to get time slots for selected day
    public void populateTimeSlots() {
        // query database, if found update

        // not found, create time slots
        timeSlots.clear();
        timeSlots.add(TimeSlot.from(selectedYear.getValue(), selectedMonth.getMonthValue(), selectedDay.getDayOfMonth(), 10, 0, selectedYear.getValue(), selectedMonth.getMonthValue(), selectedDay.getDayOfMonth(), 12, 0, false));
        timeSlots.add(TimeSlot.from(selectedYear.getValue(), selectedMonth.getMonthValue(), selectedDay.getDayOfMonth(), 14, 0, selectedYear.getValue(), selectedMonth.getMonthValue(), selectedDay.getDayOfMonth(), 16, 0, false));
        timeSlots.add(TimeSlot.from(selectedYear.getValue(), selectedMonth.getMonthValue(), selectedDay.getDayOfMonth(), 17, 0, selectedYear.getValue(), selectedMonth.getMonthValue(), selectedDay.getDayOfMonth(), 18, 0, false));
    }
}