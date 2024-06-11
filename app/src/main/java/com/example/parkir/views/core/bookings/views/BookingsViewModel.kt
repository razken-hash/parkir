package com.example.parkir.views.core.bookings.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.bookings.data.entity.BookingStatus
import com.example.parkir.views.core.bookings.data.repository.BookingsRepository
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.parkings.data.repository.ParkingRepository
import com.example.parkir.views.core.payment.data.entity.Payment
import com.google.gson.annotations.SerializedName
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
//                val count = bookingsRepository.getCount()
//                if(count!=0){
//                    val logger = Logger.getLogger("bookers")
//                    bookings = bookingsRepository.getAllSavedBookings()
//                    logger.info("amchii")
//                } else {
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
//                }
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


    fun bookParking(
        id:Int,
        parkingSpot: ParkingSpot,
        date: String,
        beginTime: String,
        endTime: String,
        duration: String,
        user: User,
    ) {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val payment: Payment = Payment(
                    cardNumber = "1234567890123456",
                    cardCVC = "123",
                    cardDate = "12/25",
                    amount = 120.0,
                    date = "2024-12-23",
                    time = "12:34:23",
                    id = 12434
                )

                val booking: Booking = Booking(
                    id= id,
                    date = date,
                    beginTime = beginTime,
                    duration = duration,
                    parkingSpot = parkingSpot,
                    user = user,
                    payment = payment
                )

                val data = bookingsRepository.bookParking(booking = booking);

                if (data.isSuccessful) {
                    if (data.body() != null) {
                        selectedBooking = data.body()!!
                        isLoading = false;
                    }
                }
            }
        }
    }

    suspend fun getAllSavedBookings(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                bookings = bookingsRepository.getAllSavedBookings()
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