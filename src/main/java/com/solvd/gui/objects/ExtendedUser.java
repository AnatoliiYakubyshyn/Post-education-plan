package com.solvd.gui.objects;

public class ExtendedUser extends User {

    private String firstName;

    private String lastName;

    public ExtendedUser() {

    }
    public ExtendedUser(String firstName, String lastName, String email, String password) {
        super(email,password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
