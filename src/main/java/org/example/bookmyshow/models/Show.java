package org.example.bookmyshow.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Movie movie;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> showFeatures;
}
