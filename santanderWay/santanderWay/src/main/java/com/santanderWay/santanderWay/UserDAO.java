package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.User;

import java.lang.reflect.Array;
import java.util.*;

public class UserDAO implements DAO<User>
{
    //BD for now, to be deleted
    private List<User> BDMOCK = new ArrayList<>();

    public List<User> getBDMOCK()
    {
        return this.BDMOCK;
    }

    @Override
    public void save(User user)
    {
        this.BDMOCK.add(user);
    }

    @Override
    public void update(User user)
    {
        int index = 0;

        for (User u : this.BDMOCK)
        {
            if(u.getId().equals (user.getId()))
            {
                index = this.BDMOCK.indexOf(u);
                this.BDMOCK.set(index, user);
                break;
            }
        }
    }

    @Override
    public void delete(String id)
    {
        for (User u : this.BDMOCK)
        {
            if(u.getId().equals (id))
            {
                this.BDMOCK.remove(u);
                break;
            }
        }
    }

    @Override
    public User serarch(String id)
    {
        for (User u : this.BDMOCK)
        {
            if(u.getId().equals (id))
                return u;
        }

        return null;
    }

    @Override
    public void close()
    {

    }
}
