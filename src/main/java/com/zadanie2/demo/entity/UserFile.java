package com.zadanie2.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_file")
public class UserFile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Id
    private int id;

    @Column(name = "file_Text")
    private String file_text;

    @OneToOne(cascade = CascadeType.ALL) //not sure about cascade
    @JoinColumn(name = "user_Id")
    private User user;

    public UserFile(){}

    public UserFile(String file_text) {
        this.file_text = file_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_text() {
        return file_text;
    }

    public void setFile_text(String file_text) {
        this.file_text = file_text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", file_text='" + file_text + '\'' +
                '}';
    }
}
