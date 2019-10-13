package by.it.entity;

import by.it.component.Address;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @Id
//    @GeneratedValue(generator = "gen")
//    @GenericGenerator(name = "gen", strategy = "increment")
    private Integer id;
    @Column(name = "person_age")
    private Integer age;
    @Column
    private String name;
    @Column
    private String surname;

    @Transient
    private String fullName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "town")),
    })
    private Address address;

    public Person(Integer id, Integer age, String name, String surname, Address address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

