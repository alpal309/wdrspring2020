package com.ilstugram.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users", schema = "ilstugram")
public class User implements Serializable {

    @Column(name="first_name")
    @Expose
    private String firstname;
    @Column(name="last_name")
    @Expose
    private String lastname;
    @Expose
    @NaturalId
    private String username;
    @Expose
    private String email;
    @Expose(serialize = false)
    private String password;
    @Expose(serialize = false)
    private int enabled = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = false)
    private int id;

    @Expose
    @OneToMany(mappedBy = "user")
    private List<Following> followers;

    public User(){}

    public User(String firstname, String lastname,
                String username, String email,
                String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Following> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Following> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", following=" + Arrays.toString(followers.toArray()) +
                ", id=" + id +
                '}';
    }
}
