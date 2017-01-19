package com.database.test;

import com.database.dao.impl.JDBCUserRepositoryImpl;
import com.database.model.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vural on 19-Jan-17.
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCUserRepositoryImpl jdbcUserRepository = (JDBCUserRepositoryImpl)context.getBean("userRepository");

        User user = jdbcUserRepository.getUserById(1);
        System.out.println(user.toString());
    }
}
