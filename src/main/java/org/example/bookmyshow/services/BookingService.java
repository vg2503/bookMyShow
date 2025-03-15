package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.SeatNotAvailableException;
import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BookingService {
    private final ShowSeatRepository showSeatRepository;
    private final ShowSeatTypeRepository showSeatTypeRepository;
    private final PriceCalculator priceCalculator;
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;
    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          ShowSeatTypeRepository showSeatTypeRepository,
                          PriceCalculator priceCalculator) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
        this.priceCalculator = priceCalculator;
    }
    @Transactional(isolation =  Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId)
            throws UserNotFoundException, ShowNotFoundException, SeatNotAvailableException {
        //get the user details. If user not present throw error
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not present.");
        }
        //get the show with show Id
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new ShowNotFoundException("No show exist with this id");
        }
        Show show = showOptional.get();
        //get the show seats that user is trying to book
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        //check if the seat is available
        //if no, throw an exception
        //if yes then get a lock on those seats
        //check if the status is available again and then and mark it as blocked
        //Release the lock
        for (ShowSeat showSeat : showSeats) {
            if(showSeat.getSeatStatus() != SeatStatus.BOOKED){
                throw new SeatNotAvailableException("Seat you are trying to book is not available");
            }
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
        }
        for (ShowSeat showSeat : showSeats) {
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        double bookingAmount = priceCalculator.calculatePrice(showSeats, showSeatTypes);

        List<Payment> payments = new ArrayList<>();
        payments.stream().forEach(x-> x.setPaymentStatus(PaymentStatus.PENDING));
        Booking booking = new Booking();
        booking.setUser(user.get());
        booking.setShow(show);
        booking.setBookingStatus(BookingStatus.BOOKED);
        booking.setShowSeats(showSeats);
        booking.setAmount(bookingAmount);
        booking.setPayments(payments);
        //save the changes for Booking in db.
        //create the booking with Payment status as Pending.
        //return the booking object
        //Optional<Booking> optionalBooking =  bookingRepository.save(booking);
        return bookingRepository.save(booking);


    }
}
