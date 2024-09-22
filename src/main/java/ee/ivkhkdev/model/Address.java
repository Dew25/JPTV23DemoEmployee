package ee.ivkhkdev.model;

import java.util.Objects;

public class Address {
    private String street;
    private String city;
    private String house;
    private String room;

    public Address() {
    }

    public Address(String street, String city, String house, String room) {
        this.street = street;
        this.city = city;
        this.house = house;
        this.room = room;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(house, address.house) && Objects.equals(room, address.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, house, room);
    }
}
