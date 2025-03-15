package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class CreateBookingResponseDTO extends  BaseResponseDTO{
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    private Long bookingId;
}
