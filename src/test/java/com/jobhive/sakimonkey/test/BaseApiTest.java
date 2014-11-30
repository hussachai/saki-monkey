package com.jobhive.sakimonkey.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseApiTest {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    protected final String className = getClass().getSimpleName();
    
    @Rule public TestName name = new TestName();
    
    @Before
    public void beforeTest(){
        System.out.println("====================================");
        System.out.println("[TEST: "+ className + "." + name.getMethodName()+"]");
    }
    
}
