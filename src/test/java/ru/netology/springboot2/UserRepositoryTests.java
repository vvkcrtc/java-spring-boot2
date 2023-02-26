package ru.netology.springboot2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.springboot2.repository.UserRepository;
import ru.netology.springboot2.service.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTests {
    @Test
    public void getUserAuthoritiesTest() {
        UserRepository ur = new UserRepository();
        List<Authorities> lst = new ArrayList<>();
        List<Authorities> lst2 = new ArrayList<>();
        lst2.add(Authorities.READ);
        //lst2.add(Authorities.WRITE);
        lst = ur.getUserAuthorities("User1","pass1");
        System.out.println(lst);
        Assertions.assertEquals(lst, lst2);

    }
}
