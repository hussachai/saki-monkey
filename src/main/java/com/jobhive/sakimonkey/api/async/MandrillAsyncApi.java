package com.jobhive.sakimonkey.api.async;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.AbstractMandrillApi;

public abstract class MandrillAsyncApi extends AbstractMandrillApi<MandrillAsyncClient> {

    public MandrillAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
}
