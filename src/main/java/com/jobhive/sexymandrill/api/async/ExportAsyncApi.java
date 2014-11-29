package com.jobhive.sexymandrill.api.async;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.request.ExportActivityParams;
import com.jobhive.sexymandrill.data.response.ExportJob;

/**
 * 
 * @author Hussachai
 *
 */
public class ExportAsyncApi extends MandrillAsyncApi {

    public ExportAsyncApi(MandrillAsyncClient client) {
        super(client);
    }
    
    /**
     * Returns information about an export job. If the export job's state is 'complete', 
     * the returned data will include a URL you can use to fetch the results. 
     * Every export job produces a zip archive, but the format of the archive is 
     * distinct for each job type. The api calls that initiate exports include more 
     * details about the output format for that job type.
     * @param id an export job identifier
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(String id, 
            ObjectResponseCallback<ExportJob> callback) {
        return getClient().execute("/exports/info.json", 
                mapParams("id", id), callback);
    }
    
    /**
     * Returns a list of your exports.
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<ExportJob[]> callback) {
        return getClient().execute("/exports/list.json", null, callback);
    }
    
    /**
     * Begins an export of your rejection blacklist. The blacklist will be exported to 
     * a zip archive containing a single file named rejects.csv that includes the 
     * following fields: email, reason, detail, created_at, expires_at, last_event_at, 
     * expires_at.
     * @param notifyEmail an optional email address to notify when the export job has finished.
     * @param callback
     * @return
     */
    public Future<HttpResponse> rejects(String notifyEmail, 
            ObjectResponseCallback<ExportJob> callback) {
        return getClient().execute("/exports/rejects.json", 
                mapParams("notify_email", notifyEmail), callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> rejects(ObjectResponseCallback<ExportJob> callback) {
        return rejects(null, callback);
    }
    
    /**
     * Begins an export of your rejection whitelist. The whitelist will be exported 
     * to a zip archive containing a single file named whitelist.csv that includes 
     * the following fields: email, detail, created_at.
     * @param notifyEmail an optional email address to notify when the export job has finished.
     * @param callback
     * @return
     */
    public Future<HttpResponse> whitelist(String notifyEmail, 
            ObjectResponseCallback<ExportJob> callback) {
        return getClient().execute("/exports/whitelist.json", 
                mapParams("notify_email", notifyEmail), callback);
    }
    
    /**
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> whitelist(ObjectResponseCallback<ExportJob> callback) {
        return whitelist(null, callback);
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
     * @param callback
     * @return
     */
    public Future<HttpResponse> activity(ExportActivityParams params,
            ObjectResponseCallback<ExportJob> callback) {
        return getClient().execute("/exports/activity.json", params, callback);
    }
}
