package com.jobhive.sakimonkey.api;

import org.testng.annotations.Test;

import com.jobhive.sakimonkey.test.BaseSyncApiTest;
import com.jobhive.sakimonkey.test.asserts.InboundApiAssert;

/**
 * 
 * @author Hussachai
 *
 */
public class InboundApiTest extends BaseSyncApiTest{

    private InboundApi api = client.api().inbound();
    
    private String domain = "jobhive.com";
    
    @Test(groups="domain")
    public void testAddDomain(){
        InboundApiAssert.assertDomain(api.addDomain(domain));
    }
    
    @Test(groups="domain", dependsOnMethods="testAddDomain")
    public void testCheckDomain(){
        InboundApiAssert.assertDomain(api.checkDomain(domain));
    }
    
    @Test(groups="domain", dependsOnMethods="testAddDomain")
    public void testDeleteDomain(){
        InboundApiAssert.assertDomain(api.deleteDomain(domain));
    }
    
    @Test(dependsOnGroups="domain")
    public void testRoutes(){
        InboundApiAssert.assertDomain(api.addDomain(domain));
        InboundApiAssert.assertRoutes(api.routes(domain));
        InboundApiAssert.assertDomain(api.deleteDomain(domain));
    }
    
}
