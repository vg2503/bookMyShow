package org.example.bookmyshow.models;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Getter
//@Setter
@Entity
public class Movie extends  BaseModel{
    private String title;

    public List<Feature> getMovieFeatures() {
        return movieFeatures;
    }

    public void setMovieFeatures(List<Feature> movieFeatures) {
        this.movieFeatures = movieFeatures;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> movieFeatures;

}
