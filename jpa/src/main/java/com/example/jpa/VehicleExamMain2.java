package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleExamMain2 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        Car2 car1 = new Car2();
        car1.setManufacturer("Honda");
        car1.setSeatCount(5);
        em.persist(car1);

        Car2 car2 = new Car2();
        car2.setManufacturer("Volvo");
        car2.setSeatCount(4);
        em.persist(car2);

        Truck2 truck = new Truck2();
        truck.setManufacturer("Scania");
        truck.setPayloadCapacity(20.0);
        em.persist(truck);

        em.getTransaction().commit();

//        // 데이터 조회
//        List<Vehicle2> vehicles = em.createQuery("SELECT v FROM Vehicle2 v", Vehicle2.class).getResultList();
//        for (Vehicle2 vehicle : vehicles) {
//            if (vehicle instanceof Car2) {
//                Car2 car = (Car2) vehicle;
//                System.out.println("Car: " + car.getManufacturer() + ", Seats: " + car.getSeatCount());
//            } else if (vehicle instanceof Truck2) {
//                Truck2 truck = (Truck2) vehicle;
//                System.out.println("Truck: " + truck.getManufacturer() + ", Payload Capacity: " + truck.getPayloadCapacity());
//            }
//        }

        em.close();
    }
}