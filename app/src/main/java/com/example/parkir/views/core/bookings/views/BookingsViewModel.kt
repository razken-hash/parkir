package com.example.parkir.views.core.bookings.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.parkir.views.core.payment.data.repository.PaymentRepository
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.logging.Logger

class BookingsViewModel(
    val bookingsRepository: BookingsRepository,
    val paymentRepository: PaymentRepository
) : ViewModel() {

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


    var newBooking: Booking by mutableStateOf<Booking>(
        Booking()
    )


    @RequiresApi(Build.VERSION_CODES.O)
    fun bookParking(
    ) {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                var now = LocalDateTime.now()
                val payment: Payment = Payment(
                    cardNumber = "1234567890123456",
                    cardCVC = "123",
                    cardDate = "12/25",
                    amount = (newBooking.duration.substring(2, 4)
                        .toInt() * newBooking.parkingSpot!!.floor.parking.pricePerHour).toDouble(),
                    time = "${now.hour.toString().padStart(2, '0')}:${now.minute.toString().padStart(2, '0')}:${now.second.toString().padStart(2, '0')}",
                    date = "${now.year}-${now.monthValue.toString().padStart(2, '0')}-${
                        now.dayOfMonth.toString().padStart(2, '0')
                    }"
                )

                val paymentData = paymentRepository.pay(payment = payment);

                Log.i("QOAY", "Am here")

                if (paymentData.isSuccessful) {
//
                    if (paymentData.body() != null) {
//
                        val newPayment = paymentData.body()!!
//
                        val user = User(
                            id = "1",
                            email = "ka_kenniche@esi.dz",
                            name = "KENNICHE",
                            phoneNumber = "9649163879134",
                            gender = "Male"
                        )
//
                        newBooking.payment = newPayment
                        newBooking.user = user
//
                        val data = bookingsRepository.bookParking(booking = newBooking);
                        if (data.isSuccessful) {
                            Log.i("QOAY", "Am here")
                            if (data.body() != null) {
                                selectedBooking = data.body()!!
                                isLoading = false;
                            }
                        }
                    }
                }

            }
        }
    }

    class Factory(
        private val bookingsRepository: BookingsRepository,
        private val paymentRepository: PaymentRepository
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BookingsViewModel(bookingsRepository, paymentRepository) as T
        }
    }
}