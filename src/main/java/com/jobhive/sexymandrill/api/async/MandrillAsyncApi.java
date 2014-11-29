package com.jobhive.sexymandrill.api.async;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.AbstractMandrillApi;

public abstract class MandrillAsyncApi extends AbstractMandrillApi<MandrillAsyncClient> {

    public MandrillAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
}
