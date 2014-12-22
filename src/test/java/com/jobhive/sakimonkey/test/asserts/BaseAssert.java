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
    
    public static void assertError(String name, Result<?> result){
        Assert.assertTrue(result.isError());
        Assert.assertNotNull(result.getErrorInfo());
        if(name != null){
            Assert.assertEquals(name, result.getErrorInfo().getName());
        }
        println("Expected Error: %s", result.getErrorInfo());
    }
    
    public static void assertError(Result<?> result){
        assertError(null, result);
    }
    
    /**
     * Check that result is not null and error free
     * @param result
     */
    public static void assertResult(Result<?> result){
        Assert.assertNotNull(result);
        if(result.isError()){
            println("Error: %s", result.getErrorInfo());
            Assert.fail();
        }
        Assert.assertNull(result.getErrorInfo());
        Assert.assertNotNull(result.getObject());
        println("Result: %s", result.getObject());
    }
    
    /**
     * Print message to System.out.
     * If the argument is array, it will be converted to String by Arrays.toString()
     * @param message
     */
    public static void println(String format, Object... args){
        for(int i=0;i<args.length;i++){
            Object arg = args[i];
            if(arg.getClass().isArray()){
                args[i] = Arrays.toString((Object[])arg);
            }
        }
        if(!format.endsWith("\n")){
            format += "\n";
        }
        System.out.format(format, args);
    }
}
