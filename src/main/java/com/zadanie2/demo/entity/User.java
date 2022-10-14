package com.zadanie2.demo.entity;

import com.zadanie2.demo.customValidation.CheckUserMail;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Id
    private int id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "disk_Size")
    private int diskSize;


//    @CheckUserMail    //check with default values
    @CheckUserMail(value = "@yandex.com", message = "must ends with @yandex.com")
    @Column(name = "mail")
    private String mail;

    public User(){}

    public User(String login, String password, int diskSize, String mail) {
        this.login = login;
        this.password = password;
        this.diskSize = diskSize;
        this.mail = mail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", diskSize=" + diskSize +
                ", mail='" + mail + '\'' +
                '}';
    }
}
