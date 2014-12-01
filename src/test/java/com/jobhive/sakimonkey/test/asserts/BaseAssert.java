package com.jobhive.sakimonkey.test.asserts;

import java.util.Arrays;

import org.testng.Assert;

import com.jobhive.sakimonkey.data.Result;

/**
 * Common methods for generic assertion.
 *  
 * @author Hussachai
 *
 */
public abstract class BaseAssert {
    
    protected static void assertError(String name, Result<?> result){
        Assert.assertTrue(result.isError());
        Assert.assertNotNull(result.getErrorInfo());
        if(name != null){
            Assert.assertEquals(name, result.getErrorInfo().getName());
        }
        println("Expected Error: " + result.getErrorInfo());
    }
    
    protected static void assertError(Result<?> result){
        assertError(null, result);
    }
    
    /**
     * Check that result is not null and error free
     * @param result
     */
    protected static void assertResult(Result<?> result){
        Assert.assertNotNull(result);
        if(result.isError()){
            println("Error: " + result.getErrorInfo());
            Assert.fail();
        }
        Assert.assertNull(result.getErrorInfo());
        Assert.assertNotNull(result.getObject());
        println("Result: "+result.getObject());
    }
    
    /**
     * Print message to System.out.
     * If the argument is array, it will be converted to String by Arrays.toString()
     * @param message
     */
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
