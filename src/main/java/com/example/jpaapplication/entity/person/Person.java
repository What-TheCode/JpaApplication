package com.example.jpaapplication.entity.person;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.util.List;

import static org.apache.commons.lang.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    @Column(name = "favorite_color")
    private String favoriteColor;

    public Person() {

    }

    public Person(String firstName, String lastname, Address address, String favoriteColor) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
        this.favoriteColor = favoriteColor;
    }

    public void updateFavoriteColor(String color) {
        this.favoriteColor = color;
    }

    public void updateHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
