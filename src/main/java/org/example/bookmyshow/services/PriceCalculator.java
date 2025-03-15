package org.example.bookmyshow.services;

import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.ShowSeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {
    public double calculatePrice(List<ShowSeat> showSeats, List<ShowSeatType> showSeatTypes)  {
        double bookingAmount = 0;

        for (ShowSeat showSeat :  showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    bookingAmount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return bookingAmount;
    }
}
