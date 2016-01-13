package cn.lee.j.eric.controller;

import cn.lee.j.eric.entity.Person;
import cn.lee.j.eric.service.IPersonService;
import com.common.RO;
import com.mongodb.WriteResult;
import com.tools.utils.RandomUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lee.J.Eric on 2015/5/20.
 */
@Controller
@RequestMapping(value = "person")
public class PersonController {

    @Resource(name = "personService")
    private IPersonService personService;

    @ResponseBody
    @RequestMapping(value = "action")
    public RO action(){
        RO ro = new RO();
        ro.setMethod("action");
        try {
            Person person = new Person();
            person.setAge(25);
            person.setName(RandomUtil.get32RandomUUID());
            personService.saveOrUpdate(person);
            personService.updateNameByAge("Lee.J.Eric", 25);
            List<Person> list = personService.findAll();
            ro.setData(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ro;
    }
}
