package com.example.appdong25

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView


class CalendarFragment : Fragment() {
    private lateinit var calendarView: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_excalendar, container, false)

        // Initialize the CalendarView
        calendarView = binding.findViewById(R.id.calendarView)

        // Set an event listener for when a date is selected
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // You can handle the date change here
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            // You can show a Toast, update a TextView, or whatever you want to do
        }

        return binding
    }
}