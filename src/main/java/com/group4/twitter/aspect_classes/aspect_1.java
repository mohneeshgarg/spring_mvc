package com.group4.twitter.aspect_classes;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class aspect_1 {
    @Before(value="execution(* com.group4.twitter.Services.UserService.*(..))")
    public void startBeforeUserService(){
        System.out.println("This will work before every user service triggers!");
    }
}
