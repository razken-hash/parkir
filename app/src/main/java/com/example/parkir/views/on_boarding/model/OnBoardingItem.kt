package com.example.parkir.views.on_boarding.model

import com.example.parkir.R

data class OnBoardingItem(
    val title: String,
    val description: String,
    val image: Int
) {
    companion object {
        val onBoardingItems: List<OnBoardingItem> = listOf(
            OnBoardingItem(
                title = "Find Parking Places Around You Easily",
                description = "Discover nearby parking spots effortlessly with a set of intuitive map-based search features.",
                image = R.drawable.map
            ),
            OnBoardingItem(
                title = "Book and Pay Parking Quickly & Safely",
                description = "Reserve your parking spot in just a few taps and complete your booking securely with our trusted payment gateway.",
                image = R.drawable.pay
            ),
            OnBoardingItem(
                title = "Extend Parking Time As You Need",
                description = "Extend your parking duration seamlessly whenever you need more time, benefiting from flexible options to prolong your stay.",
                image = R.drawable.timing
            )
        )
    }
}
