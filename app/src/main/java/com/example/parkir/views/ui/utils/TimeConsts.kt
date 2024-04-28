package com.example.parkir.views.ui.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date
import kotlin.time.Duration.Companion.hours

class TimeConsts {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        var currentQuarter:Int =  LocalTime.now().minute;
        @RequiresApi(Build.VERSION_CODES.O)
        var currentHour:Int = LocalTime.now().hour;
        @RequiresApi(Build.VERSION_CODES.O)
        var dayTiming: DayTiming = if (currentHour > 12) TimeConsts.DayTiming.AM else TimeConsts.DayTiming.PM;
        @RequiresApi(Build.VERSION_CODES.O)
        var currentDay:Int = LocalDate.now().dayOfMonth;
        @RequiresApi(Build.VERSION_CODES.O)
        var currentMonth:Int = LocalDate.now().monthValue;
        @RequiresApi(Build.VERSION_CODES.O)
        var currentYear:Int = LocalDate.now().year;
    }

    enum class DayTiming {
        AM, PM
    }
}