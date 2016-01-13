package cn.lee.j.eric.base;

import cn.lee.j.eric.entity.Person;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee.J.Eric on 2015/5/22.
 */
public class Test {

    public static void main(String[] args){
        ServerAddress serverAddress = new ServerAddress("112.74.112.241",27017);
        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential("padb", "pa", "pa2015".toCharArray());
        List<MongoCredential> mongoCredentials = new ArrayList<MongoCredential>();
        mongoCredentials.add(mongoCredential);
        MongoClient mongoClient = new MongoClient(serverAddress,mongoCredentials);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient,"pa");
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        List<Person> list = mongoTemplate.findAll(Person.class);
        System.out.println(list.get(0));

    }
}
