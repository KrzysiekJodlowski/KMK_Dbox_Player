package com.MTOPlayer.MTOPlayerSpring.model;

import javax.persistence.*;

@Entity
@Table(name = "Password")
@NamedQuery(name="allPasswordsQuery", query="select t from Password t")
public class Password {
    @Id
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="password")
    private byte[] passwordValue;

    @MapsId
    @OneToOne
    @JoinColumn(name="login_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "password")
    private Salt salt;

    public Password() { }

    public Password(byte[] passwordValue, User user, Salt salt) {
        this.passwordValue = passwordValue;
        this.user = user;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(byte[] passwordValue) {
        this.passwordValue = passwordValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Salt getSalt() {
        return salt;
    }

    public void setSalt(Salt salt) {
        this.salt = salt;
    }
}
