package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

    private final String id;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String email;
    private final String email2;
    private final String email3;
    private String group;

    public ContactData(String firstname, String lastname, String address, String home, String mobile, String work, String email, String email2, String email3, String group) {
        this.id = null;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.group = group;
    }

    public ContactData(String id, String firstname, String lastname, String address, String home, String mobile, String work, String email, String email2, String email3, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.group = group;
    }



    public String getId() { return id; }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

}