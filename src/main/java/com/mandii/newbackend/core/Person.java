package com.mandii.newbackend.core;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import org.bson.types.ObjectId;

/**
 * PersonAPI Collection
 * Created by vinay on 29/12/15.
 */
public class Person {

    private ObjectId id;
    private String first;
    private String last;
    private String dob;
    private String gender;
    private String hair_colour;
    private String occupation;
    private String nationality;

    public Person(ObjectId id, String first, String last, String dob, String gender, String hair_colour, String occupation, String nationality) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.dob = dob;
        this.gender = gender;
        this.hair_colour = hair_colour;
        this.occupation = occupation;
        this.nationality = nationality;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHair_colour() {
        return hair_colour;
    }

    public void setHair_colour(String hair_colour) {
        this.hair_colour = hair_colour;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equal(first, person.first) &&
                Objects.equal(last, person.last) &&
                Objects.equal(dob, person.dob) &&
                Objects.equal(gender, person.gender) &&
                Objects.equal(hair_colour, person.hair_colour) &&
                Objects.equal(occupation, person.occupation) &&
                Objects.equal(nationality, person.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(first, last, dob, gender, hair_colour, occupation, nationality);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("first", first)
                .add("last", last)
                .add("dob", dob)
                .add("gender", gender)
                .add("hair_colour", hair_colour)
                .add("occupation", occupation)
                .add("nationality", nationality)
                .toString();
    }
}
