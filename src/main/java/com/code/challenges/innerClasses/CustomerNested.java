package com.code.challenges.innerClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class CustomerNested {
    /** Customer Begin */
    private final String id;
    private String name;
    private String email;
    private CustomerType customerType;
    private List<User> users;



    public enum CustomerType {
        REGULAR, PREMIUM, VIP
    }

    @Override
    public String toString() {
        return  " id = " + this.id +
                " name = " + this.name +
                " email = " + this.email +
                " customerType = " + this.customerType.name();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    /** Customer End */

    @Getter
    @Setter
    @AllArgsConstructor
    public static class User {
        private String username;
        private String password;
        private String phoneNumber;
        private Address address;
        private List<Shipment> shipments;

        @Override
        public String toString() {
            return  " username = " + this.username +
                    " password = " + this.password +
                    " phoneNumber = " + this.phoneNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, password, phoneNumber);
        }

        @Getter
        @Setter
        @AllArgsConstructor
        public static class Address {
            private String street;
            private String city;
            private String zip;

            @Override
            public String toString() {
                return  " street = " + this.street +
                        " city = " + this.city +
                        " zip = " + this.zip;
            }
        }

        @Getter
        @Setter
        @AllArgsConstructor
        public static class Shipment {
            private String trackingId;
            private String status;

            @Override
            public String toString() {
                return  " trackingId = " + this.trackingId  +
                        " status = " + this.status;
            }
        }
    }
}
