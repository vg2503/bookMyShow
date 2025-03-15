package org.example.bookmyshow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

//@Getter
//@Setter
//@Getter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setShowFeatures(List<Feature> showFeatures) {
        this.showFeatures = showFeatures;
    }

    @ManyToOne
    private Movie movie;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> showFeatures;
}
