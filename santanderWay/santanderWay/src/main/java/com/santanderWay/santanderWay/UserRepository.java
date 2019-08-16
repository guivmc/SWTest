package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{

}
