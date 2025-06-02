package com.example.appdong25

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.fragment.app.Fragment

class Excalendar : Fragment() {

    private lateinit var calendarView: CalendarView
    private lateinit var showToastButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_excalendar, container, false)

        // Initialize the CalendarView
        calendarView = binding.findViewById(R.id.calendarView)

        // Set an event listener for when a date is selected
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // You can handle the date change here
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            // You can show a Toast, update a TextView, or whatever you want to do
            Toast.makeText(requireContext(), "Selected date: $selectedDate", Toast.LENGTH_SHORT).show()
        }

        return binding
    }

}