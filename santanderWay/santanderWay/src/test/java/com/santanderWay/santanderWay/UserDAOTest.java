package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest
{
    @InjectMocks
    private UserDAO dao;


//    @Deployment
//    public static JavaArchive createDeployment()
//    {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(UserDAO.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }

    @Test
    public void save()
    {
        //Prep
        User u = new User("1", "1");

        // Action
        this.dao.save(u);

        //Assertion
        Assert.assertNotNull(this.dao.getBDMOCK().get(0));
        Assert.assertEquals(u, this.dao.getBDMOCK().get(0));
    }

    @Test
    public void update()
    {
        //Prep
        User u = new User("1", "1");
        User u1 = new User("2", "2");
        User u2 = new User("3", "3");

        this.dao.save(u);
        this.dao.save(u1);
        this.dao.save(u2);

        // Action
        this.dao.update(new User("2", "6"));

        //Assertion
        Assert.assertTrue(this.dao.getBDMOCK().size() == 3);
        Assert.assertTrue(this.dao.getBDMOCK().get(1).getId().equals("2"));
        Assert.assertTrue(this.dao.getBDMOCK().get(1).getPassword().equals("6"));
    }

    @Test
    public void delete()
    {
        //Prep
        User u = new User("1", "1");
        User u1 = new User("2", "2");
        User u2 = new User("3", "3");

        this.dao.save(u);
        this.dao.save(u1);
        this.dao.save(u2);

        //Action
        this.dao.delete("2");

        //Assertion
        Assert.assertTrue(this.dao.getBDMOCK().size() == 2);
        Assert.assertNull(this.dao.serarch("2"));
    }

    @Test
    public void serarch()
    {
        //Prep
        User u = new User("1", "1");
        User u1 = new User("2", "2");
        User u2 = new User("3", "3");

        this.dao.save(u);
        this.dao.save(u1);
        this.dao.save(u2);

        //Action + Assertion
        Assert.assertNotNull(this.dao.serarch("2"));
    }
}
