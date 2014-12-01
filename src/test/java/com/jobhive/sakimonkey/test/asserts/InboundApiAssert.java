package com.jobhive.sakimonkey.test.asserts;

import org.testng.Assert;

import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.response.InboundDomain;
import com.jobhive.sakimonkey.data.response.InboundRoute;

/**
 * 
 * @author Hussachai
 *
 */
public class InboundApiAssert extends BaseAssert{
    
    public static InboundDomain assertDomain( Result<InboundDomain> result){
        assertResult(result);
        InboundDomain domain = result.getObject();
        println("Domain: " + domain.getDomain());
        Assert.assertNotNull(domain.getDomain());
        println("Created At: " + domain.getCreatedAt());
        Assert.assertNotNull(domain.getCreatedAt());
        println("Valid MX: " + domain.getValidMx());
        Assert.assertFalse(domain.getValidMx());
        return domain;
    }
    
    public static InboundDomain[] assertDomains(Result<InboundDomain[]> result){
        assertResult(result);
        for(InboundDomain domain: result.getObject()){
            assertDomain(new Result<>(domain));
        }
        return result.getObject();
    }
    
    public static InboundRoute assertRoute(Result<InboundRoute> result){
        assertResult(result);
        InboundRoute route = result.getObject();
        println("Route ID: " + route.getId());
        Assert.assertNotNull(route.getId());
        println("Route URL: "+ route.getUrl());
        Assert.assertNotNull(route.getUrl());
        return route;
    }
    
    public static InboundRoute[] assertRoutes(Result<InboundRoute[]> result){
        assertResult(result);
        InboundRoute routes[] = result.getObject();
        for(InboundRoute route: routes){
            assertRoute(new Result<>(route));
        }
        return routes;
    }
    
}
