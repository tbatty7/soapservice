package mypackage.services;

import mypackage.model.request.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<String, User>();
    @PostConstruct
    public void intialize() {

        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(1234);
        peter.setSalary(50000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(6321);
        sam.setSalary(30000);

        User tim = new User();
        tim.setName("Tim");
        tim.setEmpId(7777);
        tim.setSalary(60000);

        users.put("Tim", tim);
        users.put("Sam", sam);
        users.put("Peter", peter);
    }

    public User getUser(String name) {
        return users.get(name);
    }
}
