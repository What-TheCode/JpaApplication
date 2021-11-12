package com.example.jpaapplication.entity.person;

import com.example.jpaapplication.entity.book.Book;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private List<Book> books;

    @Column(name = "favorite_color")
    private String favoriteColor;

    public Person() {

    }

    public Person(String firstName, String lastname, Address address, String favoriteColor) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
        this.books = new ArrayList<>();
        this.favoriteColor = favoriteColor;
    }

    public int getId() {
        return id;
    }

    public void updateFavoriteColor(String color) {
        this.favoriteColor = color;
    }

    public void updateHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void removeBooksContainingFirstChar(char character) {
        this.books.removeAll(
                this.books.stream()
                        .filter(book -> book.getTitle().toLowerCase().charAt(0) == character)
                        .collect(Collectors.toList())
        );
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
