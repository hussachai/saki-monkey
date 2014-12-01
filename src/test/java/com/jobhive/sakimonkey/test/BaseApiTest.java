package com.jobhive.sakimonkey.test;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

public abstract class BaseApiTest {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    protected final String className = getClass().getSimpleName();
    
    @BeforeMethod
    public void beforeTest(Method method){
        System.out.println("====================================");
        System.out.println("[TEST: "+ className + "." + method.getName()+"]");
    }
    
}
