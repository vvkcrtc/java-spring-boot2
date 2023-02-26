package ru.netology.springboot2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboot2.service.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<UserInfo> users = new ArrayList<>();

    public UserRepository() {
        List<Authorities> lst1 = new ArrayList<>();
        lst1.add(Authorities.READ);
        users.add(new UserInfo("User1", "pass1", lst1));
        List<Authorities> lst2 = new ArrayList<>();
        lst2.add(Authorities.WRITE);
        lst2.add(Authorities.DELETE);
        users.add(new UserInfo("Admin", "admin", lst2));
        List<Authorities> lst3 = new ArrayList<>();
        lst3.add(Authorities.READ);
        lst3.add(Authorities.WRITE);
        users.add(new UserInfo("User2", "pass2", lst3));
        users.add(new UserInfo("User3", "pass3", null));

    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (UserInfo elem : users) {
            if (user.equals(elem.getName()) && password.equals(elem.getPassword())) {
                return elem.getAccessRights();
            }
        }
        return null;
    }
}