package org.example.bookmyshow.DTOs;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateBookingRequestDTO {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}
