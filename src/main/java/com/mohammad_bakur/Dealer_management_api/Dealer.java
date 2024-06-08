package com.mohammad_bakur.Dealer_management_api;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Dealer", uniqueConstraints = {
        @UniqueConstraint(name = "unique_dealer_email", columnNames = "email" )
})
public class Dealer {
    @Id
    @SequenceGenerator(name = "dealer_id_seq",
            sequenceName = "dealer_id_seq",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "dealer_id_seq")
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public Dealer(Integer id,String fullName, String email, String phoneNumber, String password, String address, LocalDateTime registrationDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public Dealer(String fullName, String email, String phoneNumber, String password, String address, LocalDateTime registrationDate) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public Dealer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dealer dealer = (Dealer) o;
        return Objects.equals(id, dealer.id) && Objects.equals(fullName, dealer.fullName) && Objects.equals(email, dealer.email) && Objects.equals(phoneNumber, dealer.phoneNumber) && Objects.equals(password, dealer.password) && Objects.equals(address, dealer.address) && Objects.equals(registrationDate, dealer.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, phoneNumber, password, address, registrationDate);
    }
}

