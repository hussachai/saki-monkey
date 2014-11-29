package com.jobhive.sexymandrill.api;

import java.util.Map;

import com.jobhive.sexymandrill.MandrillClient;
import com.jobhive.sexymandrill.data.Result;
import com.jobhive.sexymandrill.data.response.Metadata;

/**
 * 
 * @author Hussachai
 *
 */
public class MetadataApi extends MandrillApi {

    public MetadataApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Get the list of custom metadata fields indexed for the account.
     * @return
     */
    public Result<Metadata[]> list() {
        return getClient().execute(Metadata[].class, METADATA_LIST, null);
    }
    
    /**
     * Add a new custom metadata field to be indexed for the account.
     * @param name a unique identifier for the metadata field
     * @param viewTemplate optional Mustache template to control how the metadata 
     *        is rendered in your activity log
     * @return
     */
    public Result<Metadata> add(String name, String viewTemplate) {
        Map<String, Object> params = mapParams("name", name)
                .p("view_template", viewTemplate);
        return getClient().execute(Metadata.class, METADATA_ADD, params);
    }
    
    /**
     * Update an existing custom metadata field.
     * @param name the unique identifier of the metadata field to update
     * @param viewTemplate optional Mustache template to control how the metadata 
     *        is rendered in your activity log
     * @return
     */
    public Result<Metadata> update(String name, String viewTemplate) {
        Map<String, Object> params = mapParams("name", name)
                .p("view_template", viewTemplate);
        return getClient().execute(Metadata.class, METADATA_UPDATE, params);
    }
    
    /**
     * Delete an existing custom metadata field. Deletion isn't instataneous, 
     * and /metadata/list will continue to return the field until the asynchronous 
     * deletion process is complete.
     * @param name the unique identifier of the metadata field to update
     * @return
     */
    public Result<Metadata> delete(String name) {
        return getClient().execute(Metadata.class, METADATA_DELETE, 
                mapParams("name", name));
    }
}
