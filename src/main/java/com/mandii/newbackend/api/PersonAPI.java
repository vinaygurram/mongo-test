package com.mandii.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by vinay on 29/12/15.
 */
public class PersonAPI {

    private String first;
    private String last;
    private String gender;
    private String occupation;

    @JsonProperty
    public String getOccupation() {
        return occupation;
    }

    @JsonProperty
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @JsonProperty
    public String getFirst() {

        return first;
    }

    @JsonProperty
    public void setFirst(String first) {
        this.first = first;
    }

    @JsonProperty
    public String getLast() {
        return last;
    }

    @JsonProperty
    public void setLast(String last) {
        this.last = last;
    }

    @JsonProperty
    public String getGender() {
        return gender;
    }

    @JsonProperty
    public void setGender(String gender) {
        this.gender = gender;
    }
}
