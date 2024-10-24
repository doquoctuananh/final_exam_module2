package model;

import java.time.LocalDate;

public class Contact {
    private String phone;
    private String groupContact;
    private String name;
    private String sex;
    private String address;
    private LocalDate birthday;
    private String email;


    public Contact(String groupContact, String name, String phone,
                   String sex, String address, LocalDate birthday, String email) {
        this.groupContact = groupContact;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroupContact() {
        return groupContact;
    }

    public void setGroupContact(String groupContact) {
        this.groupContact = groupContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                 phone +
                "," + groupContact +
                "," + name +
                "," + sex +
                "," + address  +
                "," + birthday +
                "," + email
                ;
    }
}
