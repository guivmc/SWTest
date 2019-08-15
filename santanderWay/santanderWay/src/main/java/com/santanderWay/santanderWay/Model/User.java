package com.santanderWay.santanderWay.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;

    private String password;

    public User(Integer id, String password)
    {
        this.id = id;
        this.password = password;
    }

    public long getId()
    {
        return id.intValue();
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
