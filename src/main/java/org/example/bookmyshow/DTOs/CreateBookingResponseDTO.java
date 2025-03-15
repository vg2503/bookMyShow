package org.example.bookmyshow.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDTO extends  BaseResponseDTO{
    private Long bookingId;
}
