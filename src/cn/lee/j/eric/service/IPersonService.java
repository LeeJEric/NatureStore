package cn.lee.j.eric.service;

import cn.lee.j.eric.entity.Person;

import java.util.List;

/**
 * Created by Lee.J.Eric on 2015/5/20.
 */
public interface IPersonService {

    Person saveOrUpdate(Person entity);

    List<Person> findAll();

    void updateNameByAge(String name, Integer age);

}
