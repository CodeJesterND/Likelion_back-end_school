package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Vehicle2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}

@Entity
@Table(name = "Car2")
@Getter
@Setter
class Car2 extends Vehicle2 {
    private int seatCount;
}

@Entity
@Table(name = "Truck2")
@Getter
@Setter
class Truck2 extends Vehicle2 {
    private double payloadCapacity;
}