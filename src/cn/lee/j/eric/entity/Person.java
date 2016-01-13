package cn.lee.j.eric.entity;

import com.tools.utils.RandomUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Lee.J.Eric on 2015/5/20.
 */
@Document(collection = "person")
public class Person implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 3617931430808763429L;

    @Id
    private String id = System.currentTimeMillis() + RandomUtil.getRandomeStringForLength(10);

    private String name;
    private int age;
    public Person() {
        super();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person[id="+id+",name="+name+",age="+age+"]";
    }
}
