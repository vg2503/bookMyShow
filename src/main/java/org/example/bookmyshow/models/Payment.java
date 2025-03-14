package org.example.bookmyshow.models;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends  BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private String referenceNumber;
}
