package cn.lee.j.eric.service.impl;

import cn.lee.j.eric.entity.Person;
import cn.lee.j.eric.repository.PersonRepository;
import cn.lee.j.eric.service.IPersonService;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lee.J.Eric on 2015/5/20.
 */
@Service("personService")
public class PersonService implements IPersonService {

    @Resource(name = "personRepository")
    private PersonRepository repository;

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Person saveOrUpdate(Person entity) {
        return repository.save(entity);
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public void updateNameByAge(String name, Integer age) {
        mongoTemplate.updateMulti(new Query(Criteria.where("age").is(age)), Update.update("name",name),Person.class);
    }
}
