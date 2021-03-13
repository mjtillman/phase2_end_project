package com.login;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "email")
  private String email;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  public User() {}

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Long getid() {return this.id; }
  public String getUsername() { return this.username;}
  public String getEmail() { return this.email;}
  public String getPassword() { return this.password;}

  public void setUsername(String name) { this.username = name;}
  public void setEmail(String email) { this.email = email;}
  public void setPassword(String password) { this.password = password;}
}