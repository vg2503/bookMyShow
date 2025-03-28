package org.example.bookmyshow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
//
//@Getter
//@Setter
@Entity
public class Screen extends  BaseModel{
    @OneToMany
    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Feature> getScreenFeatures() {
        return screenFeatures;
    }

    public void setScreenFeatures(List<Feature> screenFeatures) {
        this.screenFeatures = screenFeatures;
    }

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> screenFeatures;

}
