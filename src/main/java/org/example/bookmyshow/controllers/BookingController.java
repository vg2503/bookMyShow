package org.example.bookmyshow.controllers;

import org.example.bookmyshow.services.BookingService;
import org.example.bookmyshow.DTOs.CreateBookingRequestDTO;
import org.example.bookmyshow.DTOs.CreateBookingResponseDTO;
import org.example.bookmyshow.DTOs.ResponseStatus;
import org.example.bookmyshow.models.Booking;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDTO createTicket(CreateBookingRequestDTO requestDTO){
        CreateBookingResponseDTO createBookingResponseDTO = new CreateBookingResponseDTO();
        try{
            Booking booking = bookingService.createBooking(requestDTO.getUserId(), requestDTO.getShowSeatIds(), requestDTO.getShowId());
            createBookingResponseDTO.setBookingId(booking.getId());
            createBookingResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            createBookingResponseDTO.setResponseStatus(ResponseStatus.ERROR);
            createBookingResponseDTO.setMessage(e.getMessage());
        }
        return createBookingResponseDTO;
    }
}
