package com.jobhive.sakimonkey.test;

import com.jobhive.sakimonkey.MandrillClient;

public abstract class BaseSyncApiTest extends BaseApiTest {

    public static enum Singleton {
        GET;
        protected final MandrillClient client = new MandrillClient();
    }
    
    protected MandrillClient client = Singleton.GET.client;
    
}
