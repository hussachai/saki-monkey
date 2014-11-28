package com.jobhive.sexymandrill.api.async;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.MandrillApi;

public abstract class MandrillAsyncApi extends MandrillApi<MandrillAsyncClient> {

    public MandrillAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
}
