/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;

/**
 *
 * @author Lenovo
 */
public class Utilisateur {
    
    
    private int id; 
    private String firstName,lastName,email,password,roles,picture;
    public String getEmail;

    public Utilisateur(int id, String firstName, String lastName, String email, String password, String roles, String picture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.roles = roles;
    }

    public Utilisateur(String firstName, String lastName, String email, String password, String roles, String picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.roles = roles;
    }

    public Utilisateur() {
        
    }

    public Utilisateur(int id) {
        this.id = id;
    }


   

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

 


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", roles=" + roles + ", picture=" + picture + '}';
    }

  



    
}
