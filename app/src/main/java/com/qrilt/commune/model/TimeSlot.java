package com.qrilt.commune.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class TimeSlot {
    // Properties
    private LocalDateTime startDateTime, endDateTime;
    private boolean isAvailable;

    // Constructors and Methods
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static TimeSlot from(int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute, boolean isAvailable) {
        TimeSlot ts = new TimeSlot();
        ts.startDateTime = LocalDateTime.of(startYear, startMonth, startDay, startHour, startMinute);
        ts.endDateTime = LocalDateTime.of(endYear, endMonth, endDay, endHour, endMinute);
        ts.isAvailable = isAvailable;
        return ts;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
