package com.jobhive.sakimonkey.test.asserts;

import java.util.Arrays;

public abstract class BaseAssert {
    
    protected static void println(Object message){
        if(message == null){
            System.out.println("null <<<<<<<<<<<<<");
            return;
        }
        if(message.getClass().isArray()){
            System.out.println(Arrays.toString((Object[])message));
        }else{
            System.out.println(message);
        }
    }
}
