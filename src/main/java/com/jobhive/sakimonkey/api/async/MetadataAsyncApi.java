package com.jobhive.sakimonkey.api.async;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sakimonkey.MandrillAsyncClient;
import com.jobhive.sakimonkey.api.async.callback.ObjectResponseCallback;
import com.jobhive.sakimonkey.data.response.Metadata;

/**
 * 
 * @author Hussachai
 *
 */
public class MetadataAsyncApi extends MandrillAsyncApi {

    public MetadataAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Get the list of custom metadata fields indexed for the account.
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(
            ObjectResponseCallback<Metadata[]> callback) {
        return getClient().execute(METADATA_LIST, null, callback);
    }
    
    /**
     * Add a new custom metadata field to be indexed for the account.
     * @param name a unique identifier for the metadata field
     * @param viewTemplate optional Mustache template to control how the metadata 
     *        is rendered in your activity log
     * @param callback
     * @return
     */
    public Future<HttpResponse> add(String name, String viewTemplate,
        ObjectResponseCallback<Metadata> callback) {
        Map<String, Object> params = mapParams("name", name)
                .p("view_template", viewTemplate);
        return getClient().execute(METADATA_ADD, params, callback);
    }
    
    /**
     * Update an existing custom metadata field.
     * @param name the unique identifier of the metadata field to update
     * @param viewTemplate optional Mustache template to control how the metadata 
     *        is rendered in your activity log
     * @param callback
     * @return
     */
    public Future<HttpResponse> update(String name, String viewTemplate,
            ObjectResponseCallback<Metadata> callback) {
        Map<String, Object> params = mapParams("name", name)
                .p("view_template", viewTemplate);
        return getClient().execute(METADATA_UPDATE, params, callback);
    }
    
    /**
     * Delete an existing custom metadata field. Deletion isn't instataneous, 
     * and /metadata/list will continue to return the field until the asynchronous 
     * deletion process is complete.
     * @param name the unique identifier of the metadata field to update
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String name,
            ObjectResponseCallback<Metadata> callback) {
        return getClient().execute(METADATA_DELETE, 
                mapParams("name", name), callback);
    }
}
