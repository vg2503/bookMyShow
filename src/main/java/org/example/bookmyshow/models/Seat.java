package org.example.bookmyshow.models;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int rowNo;
    private int colNo;
    private String seatNo;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
