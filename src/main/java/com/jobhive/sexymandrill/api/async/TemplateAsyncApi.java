package com.jobhive.sexymandrill.api.async;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.request.Message.Var;
import com.jobhive.sexymandrill.data.request.TemplateContent;
import com.jobhive.sexymandrill.data.request.TemplateParams;
import com.jobhive.sexymandrill.data.response.RenderedTemplate;
import com.jobhive.sexymandrill.data.response.Template;
import com.jobhive.sexymandrill.utils.Literal;

/**
 * 
 * @author Hussachai
 *
 */
public class TemplateAsyncApi extends MandrillAsyncApi {

    public TemplateAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Add a new template
     * @param params
     * @param callback
     * @return
     */
    public Future<HttpResponse> add(TemplateParams params,
            ObjectResponseCallback<Template> callback) {
        return getClient().execute("/templates/add.json", params, callback);
    }
    
    /**
     * Get the information for an existing template
     * @param name the immutable name of an existing template
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(String name,
            ObjectResponseCallback<Template> callback) {
        return getClient().execute("/templates/info.json", 
                mapParams("name", name), callback);
    }
    
    /**
     * Update the code for an existing template. If null is provided 
     * for any fields, the values will remain unchanged.
     * @param params
     * @param callback
     * @return
     */
    public Future<HttpResponse> update(TemplateParams params,
            ObjectResponseCallback<Template> callback) {
        return getClient().execute("/templates/update.json", 
                params, callback);
    }
    
    /**
     * Publish the content for the template. Any new messages sent using 
     * this template will start using the content that was previously in draft.
     * @param name
     * @param callback
     * @return
     */
    public Future<HttpResponse> publish(String name,
            ObjectResponseCallback<Template> callback) {
        return getClient().execute("/templates/publish.json", 
                mapParams("name", name), callback);
    }
    
    /**
     * Delete a template
     * @param name
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String name,
            ObjectResponseCallback<Template> callback) {
        return getClient().execute("/templates/delete.json", 
                mapParams("name", name), callback);
    }
    
    /**
     * Return a list of all the templates available to this user
     * @param label an optional label to filter the templates
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(String label,
            ObjectResponseCallback<Template[]> callback) {
        return getClient().execute("/templates/list.json", 
                mapParams("label", label), callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<Template[]> callback) {
        return getClient().execute("/templates/list.json", null , callback);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a template
     * @param name the name of an existing template
     * @param callback
     * @return
     */
    public Future<HttpResponse> timeSeries(String name,
            ObjectResponseCallback<Template[]> callback) {
        return getClient().execute("/templates/time-series.json", 
                mapParams("name", name), callback);
    }
    
    /**
     * 
     * @param name the immutable name of a template that exists in the user's account
     * @param templateContents an array of template content to render. 
     *        Each item in the array should be a struct with two keys - name: the name 
     *        of the content block to set the content for, and content: the actual content 
     *        to put into the block
     * @param mergeVars optional merge variables to use for injecting merge field content. 
     *        If this is not provided, no merge fields will be replaced.
     * @param callback
     * @return
     */
    public Future<HttpResponse> render(String name,
            List<TemplateContent> templateContents, List<Var> mergeVars,
            ObjectResponseCallback<RenderedTemplate> callback) {
        /* TemplateContent is required field even we don't need it */
        if(templateContents == null){
            templateContents = Literal.list(new TemplateContent("N", "O"));
        }
        Map<String, Object> params = mapParams("template_name", name)
                .p("template_content", templateContents)
                .p("merge_vars", mergeVars);
        return getClient().execute("/templates/render.json", params, callback);
    }
    
    /**
     * 
     * @param name
     * @param mergeVars
     * @param callback
     * @return
     */
    public Future<HttpResponse> render(String name, List<Var> mergeVars,
            ObjectResponseCallback<RenderedTemplate> callback) {
        return render(name, null, mergeVars, callback);
    }
}
