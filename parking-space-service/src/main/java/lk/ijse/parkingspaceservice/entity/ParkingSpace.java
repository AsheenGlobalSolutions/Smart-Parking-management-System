package lk.ijse.parkingspaceservice.entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String location;
    String address;
    boolean available;
    String type;
    Long ownerId;


    public ParkingSpace() {
    }

    public ParkingSpace(int id, String location, String address, boolean available, String type, Long ownerId) {
        this.id = id;
        this.location = location;
        this.address = address;
        this.available = available;
        this.type = type;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
