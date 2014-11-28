package com.jobhive.sexymandrill.api.async.callback;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobhive.sexymandrill.data.response.ErrorInfo;

public class JsonHttpFutureCallback implements FutureCallback<HttpResponse> {

    protected ObjectMapper mapper;

    protected ObjectResponseCallback<?> callback;

    public JsonHttpFutureCallback(ObjectMapper mapper,
            ObjectResponseCallback<?> callback) {
        this.mapper = mapper;
        this.callback = callback;
    }
    
    @Override
    public void completed(HttpResponse result) {
        try (InputStream in = result.getEntity().getContent()) {
            Object object = null;
            if (result.getStatusLine().getStatusCode() == 200) {
                Class<?> objectType = callback.getObjectType();
                object = readObject(in, objectType);
                callback.completed(object, false);
            } else {
                Class<ErrorInfo> errorType = callback.getErrorType();
                object = readError(in, errorType);
                callback.completed(object, true);
            }
        } catch (IllegalStateException | IOException e) {
            failed(e);
        }
    }

    @Override
    public void failed(Exception e) {
        callback.onFailure(e);
    }

    @Override
    public void cancelled() {
    }

    protected Object readObject(InputStream in, Class<?> objectType)
            throws IOException {
        return mapper.readValue(in, objectType);
    }
    
    protected Object readError(InputStream in, Class<ErrorInfo> errorType)
            throws IOException {
        return mapper.readValue(in, errorType);
    }
}
