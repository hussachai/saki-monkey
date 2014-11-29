package com.jobhive.sakimonkey.api;

import java.util.List;
import java.util.Map;

import com.jobhive.sakimonkey.MandrillClient;
import com.jobhive.sakimonkey.data.Result;
import com.jobhive.sakimonkey.data.request.TemplateContent;
import com.jobhive.sakimonkey.data.request.TemplateParams;
import com.jobhive.sakimonkey.data.request.Message.Var;
import com.jobhive.sakimonkey.data.response.RenderedTemplate;
import com.jobhive.sakimonkey.data.response.Template;
import com.jobhive.sakimonkey.utils.Literal;

/**
 * 
 * @author Hussachai
 *
 */
public class TemplateApi extends MandrillApi {

    public TemplateApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Add a new template
     * @param params
     * @return
     */
    public Result<Template> add(TemplateParams params) {
        return getClient().execute(Template.class, TEMPLATE_ADD, params);
    }
    
    /**
     * Get the information for an existing template
     * @param name the immutable name of an existing template
     * @return
     */
    public Result<Template> info(String name) {
        return getClient().execute(Template.class, TEMPLATE_INFO, 
                mapParams("name", name));
    }
    
    /**
     * Update the code for an existing template. If null is provided 
     * for any fields, the values will remain unchanged.
     * @param params
     * @return
     */
    public Result<Template> update(TemplateParams params) {
        return getClient().execute(Template.class, 
                TEMPLATE_UPDATE, params);
    }
    
    /**
     * Publish the content for the template. Any new messages sent using 
     * this template will start using the content that was previously in draft.
     * @param name
     * @return
     */
    public Result<Template> publish(String name) {
        return getClient().execute(Template.class, TEMPLATE_PUBLISH, 
                mapParams("name", name));
    }
    
    /**
     * Delete a template
     * @param name
     * @return
     */
    public Result<Template> delete(String name) {
        return getClient().execute(Template.class, TEMPLATE_DELETE, 
                mapParams("name", name));
    }
    
    /**
     * Return a list of all the templates available to this user
     * @param label an optional label to filter the templates
     * @return
     */
    public Result<Template[]> list(String label) {
        return getClient().execute(Template[].class, TEMPLATE_LIST, 
                mapParams("label", label));
    }
    
    /**
     * 
     * @return
     */
    public Result<Template[]> list() {
        return list(null);
    }
    
    /**
     * Return the recent history (hourly stats for the last 30 days) for a template
     * @param name the name of an existing template
     * @return
     */
    public Result<Template[]> timeSeries(String name) {
        return getClient().execute(Template[].class, TEMPLATE_TIME_SERIES, 
                mapParams("name", name));
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
     * @return
     */
    public Result<RenderedTemplate> render(String name,
            List<TemplateContent> templateContents, List<Var> mergeVars) {
        /* TemplateContent is required field even we don't need it */
        if(templateContents == null){
            templateContents = Literal.list(new TemplateContent("N", "O"));
        }
        Map<String, Object> params = mapParams("template_name", name)
                .p("template_content", templateContents)
                .p("merge_vars", mergeVars);
        return getClient().execute(RenderedTemplate.class,
                TEMPLATE_RENDER, params);
    }
    
    /**
     * 
     * @param name
     * @param mergeVars
     * @return
     */
    public Result<RenderedTemplate> render(String name, List<Var> mergeVars) {
        return render(name, null, mergeVars);
    }
}
