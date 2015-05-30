package cn.lee.j.eric.repository;

import cn.lee.j.eric.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Lee.J.Eric on 2015/5/20.
 */
@Repository("personRepository")
public interface PersonRepository extends MongoRepository<Person,String> {
}
