package com.example.parkir.views.core.bookings.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.bookings.data.entity.BookingStatus
import com.example.parkir.views.core.bookings.data.repository.BookingsRepository
import com.example.parkir.views.core.parkings.data.repository.ParkingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.logging.Logger

class BookingsViewModel(val bookingsRepository: BookingsRepository) : ViewModel() {

    var bookings by mutableStateOf<List<Booking>>(emptyList())

    var selectedBooking: Booking? by mutableStateOf<Booking?>(null)

    var isLoading by mutableStateOf(true)
    fun getAllBookings() {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val logger = Logger.getLogger("bookers")
                val data = bookingsRepository.getAllBookings();
                logger.info("HELLO")
                if (data.isSuccessful) {
                    logger.info("Success")

                    if (data.body() != null) {
                        logger.info("Not null")
                        bookings = data.body()!!
                        isLoading = false;
                    }
                }
            }
        }
    }

    fun getBookingsByStatus(status: BookingStatus) {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = bookingsRepository.getBookingsByStatus(status = status);
                val logger = Logger.getLogger("myprint")
                logger.info("BEfire")
                if (data.isSuccessful) {
                    logger.info("Suceees")
                    logger.info(data.body().toString())
                    if (data.body() != null) {
                        logger.info("Body")
                        bookings = data.body()!!
                        isLoading = false;
                        logger.info(selectedBooking.toString())
                    }
                }
            }
        }
    }

    fun getBookingById(bookingId: Int) {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = bookingsRepository.getBookingById(bookingId = bookingId);
                if (data.isSuccessful) {
                    if (data.body() != null) {
                        selectedBooking = data.body()!!
                        isLoading = false;
                    }
                }
            }
        }
    }

    class Factory(private val bookingsRepository: BookingsRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BookingsViewModel(bookingsRepository) as T
        }
    }
}