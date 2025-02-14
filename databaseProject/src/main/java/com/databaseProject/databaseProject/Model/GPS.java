package com.databaseProject.databaseProject.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GPS {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double latitude;
    private double longitude;
    private double altitude;
    private LocalDateTime timeValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public GPS() {
    }

    public GPS(double latitude, double longitude, double altitude, LocalDateTime timeValue, User user) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timeValue = timeValue;
        this.user = user;
    }

    public GPS(double latitude, double longitude, double altitude, LocalDateTime timeValue) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timeValue = timeValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(LocalDateTime timeValue) {
        this.timeValue = timeValue;
    }
}
