package com.jobhive.sexymandrill.api;

import com.jobhive.sexymandrill.MandrillClient;
import com.jobhive.sexymandrill.data.Result;
import com.jobhive.sexymandrill.data.request.ExportActivityParams;
import com.jobhive.sexymandrill.data.response.ExportJob;

/**
 * 
 * @author Hussachai
 *
 */
public class ExportApi extends MandrillApi {

    public ExportApi(MandrillClient client) {
        super(client);
    }
    
    /**
     * Returns information about an export job. If the export job's state is 'complete', 
     * the returned data will include a URL you can use to fetch the results. 
     * Every export job produces a zip archive, but the format of the archive is 
     * distinct for each job type. The api calls that initiate exports include more 
     * details about the output format for that job type.
     * @param id an export job identifier
     * @return
     */
    public Result<ExportJob> info(String id) {
        return getClient().execute(ExportJob.class, EXPORT_INFO, 
                mapParams("id", id));
    }
    
    /**
     * Returns a list of your exports.
     * @return
     */
    public Result<ExportJob[]> list() {
        return getClient().execute(ExportJob[].class, EXPORT_LIST, null);
    }
    
    /**
     * Begins an export of your rejection blacklist. The blacklist will be exported to 
     * a zip archive containing a single file named rejects.csv that includes the 
     * following fields: email, reason, detail, created_at, expires_at, last_event_at, 
     * expires_at.
     * @param notifyEmail an optional email address to notify when the export job has finished.
     * @return
     */
    public Result<ExportJob> rejects(String notifyEmail) {
        return getClient().execute(ExportJob.class, EXPORT_REJECTS, 
                mapParams("notify_email", notifyEmail));
    }
    
    /**
     * 
     * @return
     */
    public Result<ExportJob> rejects() {
        return rejects(null);
    }
    
    /**
     * Begins an export of your rejection whitelist. The whitelist will be exported 
     * to a zip archive containing a single file named whitelist.csv that includes 
     * the following fields: email, detail, created_at.
     * @param notifyEmail an optional email address to notify when the export job has finished.
     * @return
     */
    public Result<ExportJob> whitelist(String notifyEmail) {
        return getClient().execute(ExportJob.class, EXPORT_WHITELIST, 
                mapParams("notify_email", notifyEmail));
    }
    
    /**
     * 
     * @return
     */
    public Result<ExportJob> whitelist() {
        return whitelist(null);
    }
    
    /**
     * Begins an export of your activity history. The activity will be exported to 
     * a zip archive containing a single file named activity.csv in the same format 
     * as you would be able to export from your account's activity view. 
     * It includes the following fields: Date, Email Address, Sender, Subject, Status, 
     * Tags, Opens, Clicks, Bounce Detail. If you have configured any custom metadata 
     * fields, they will be included in the exported data.
     * 
     * @param params
     * @return
     */
    public Result<ExportJob> activity(ExportActivityParams params) {
        return getClient().execute(ExportJob.class, EXPORT_ACTIVITY, params);
    }
}
