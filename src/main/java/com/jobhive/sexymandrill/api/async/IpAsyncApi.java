package com.jobhive.sexymandrill.api.async;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;

import com.jobhive.sexymandrill.MandrillAsyncClient;
import com.jobhive.sexymandrill.api.async.callback.ObjectResponseCallback;
import com.jobhive.sexymandrill.data.response.DedicatedIp;
import com.jobhive.sexymandrill.data.response.DedicatedIpPool;

/**
 * 
 * @author Hussachai
 *
 */
public class IpAsyncApi extends MandrillAsyncApi {

    public IpAsyncApi(MandrillAsyncClient client) {
        super(client);
    }

    /**
     * Lists your dedicated IPs.
     * 
     * @param callback
     * @return
     */
    public Future<HttpResponse> list(ObjectResponseCallback<DedicatedIp[]> callback) {
        return getClient().execute("/ips/list.json", null, callback);
    }
    
    /**
     * Retrieves information about a single dedicated ip.
     * @param ip a dedicated IP address
     * @param callback
     * @return
     */
    public Future<HttpResponse> info(String ip,
            ObjectResponseCallback<DedicatedIp> callback) {
        return getClient().execute("/ips/info.json", 
                mapParams("ip", ip), callback);
    }
    
    /**
     * Requests an additional dedicated IP for your account. 
     * Accounts may have one outstanding request at any time, and provisioning 
     * requests are processed within 24 hours.
     * @param warmup whether to enable warmup mode for the ip
     * @param pool the id of the pool to add the dedicated ip to, or null to use your account's default pool
     * @param callback
     * @return
     */
    public Future<HttpResponse> provision(Boolean warmup, String pool,
            ObjectResponseCallback<DedicatedIp> callback) {
        Map<String, Object> params = mapParams("warmup", warmup).p("pool", pool);
        return getClient().execute("/ips/provision.json", params, callback);
    }
    
    /**
     * Begins the warmup process for a dedicated IP. During the warmup process, 
     * Mandrill will gradually increase the percentage of your mail that is sent over 
     * the warming-up IP, over a period of roughly 30 days. The rest of your mail 
     * will be sent over shared IPs or other dedicated IPs in the same pool.
     * @param ip a dedicated ip address
     * @param callback
     * @return
     */
    public Future<HttpResponse> startWarmup(String ip,
            ObjectResponseCallback<DedicatedIp> callback) {
        return getClient().execute("/ips/start-warmup.json", 
                mapParams("ip", ip), callback);
    }
    
    /**
     * Cancels the warmup process for a dedicated IP.
     * @param ip a dedicated ip address
     * @param callback
     * @return
     */
    public Future<HttpResponse> cancelWarmup(String ip,
            ObjectResponseCallback<DedicatedIp> callback) {
        return getClient().execute("/ips/cancel-warmup.json", 
                mapParams("ip", ip), callback);
    }
    
    /**
     * Moves a dedicated IP to a different pool.
     * @param ip a dedicated ip address
     * @param pool the name of the new pool to add the dedicated ip to
     * @param createPool whether to create the pool if it does not exist; 
     *        if false and the pool does not exist, an Unknown_Pool will be thrown.
     * @param callback
     * @return
     */
    public Future<HttpResponse> setPool(String ip, String pool, Boolean createPool,
            ObjectResponseCallback<DedicatedIp> callback) {
        Map<String, Object> params = mapParams("ip", ip)
                .p("pool", pool).p("create_pool", createPool);
        return getClient().execute("/ips/set-pool.json", params, callback);
    }
    
    /**
     * Deletes a dedicated IP. This is permanent and cannot be undone.
     * @param ip the dedicated ip to remove from your account
     * @param callback
     * @return
     */
    public Future<HttpResponse> delete(String ip,
            ObjectResponseCallback<DedicatedIp.IpDeleteStatus> callback) {
        return getClient().execute("/ips/delete.json", 
                mapParams("ip", ip), callback);
    }
    
    /**
     * Lists your dedicated IP pools.
     * @param callback
     * @return
     */
    public Future<HttpResponse> listPools(ObjectResponseCallback<DedicatedIpPool[]> callback) {
        return getClient().execute("/ips/list-pools.json", null, callback);
    }
    
    /**
     * Describes a single dedicated IP pool.
     * @param pool a pool name
     * @param callback
     * @return
     */
    public Future<HttpResponse> poolInfo(String pool, 
            ObjectResponseCallback<DedicatedIpPool> callback) {
        return getClient().execute("/ips/pool-info.json", 
                mapParams("pool", pool), callback);
    }
    
    /**
     * Creates a pool and returns it. 
     * If a pool already exists with this name, no action will be performed.
     * @param pool the name of a pool to create
     * @param callback
     * @return
     */
    public Future<HttpResponse> createPool(String pool, 
            ObjectResponseCallback<DedicatedIpPool> callback) {
        return getClient().execute("/ips/create-pool.json", 
                mapParams("pool", pool), callback);
    }
    
    /**
     * Deletes a pool. A pool must be empty before you can delete it, 
     * and you cannot delete your default pool.
     * @param pool the name of the pool to delete
     * @param callback
     * @return
     */
    public Future<HttpResponse> deletePool(String pool, 
            ObjectResponseCallback<DedicatedIpPool.PoolDeleteStatus> callback) {
        return getClient().execute("/ips/delete-pool.json", 
                mapParams("pool", pool), callback);
    }
    
    /**
     * Tests whether a domain name is valid for use as the custom reverse 
     * DNS for a dedicated IP.
     * @param ip
     * @param domain
     * @param callback
     * @return
     */
    public Future<HttpResponse> checkCustomDns(String ip, String domain, 
            ObjectResponseCallback<DedicatedIp.CustomDnsStatus> callback) {
        Map<String, Object> params = mapParams("ip", ip).p("domain", domain);
        return getClient().execute("/ips/check-custom-dns.json", params, callback);
    }
    
    /**
     * Configures the custom DNS name for a dedicated IP.
     * @param ip a dedicated ip address
     * @param domain a domain name to set as the dedicated IP's custom dns name.
     * @param callback
     * @return
     */
    public Future<HttpResponse> setCustomDns(String ip, String domain, 
            ObjectResponseCallback<DedicatedIp> callback) {
        Map<String, Object> params = mapParams("ip", ip).p("domain", domain);
        return getClient().execute("/ips/set-custom-dns.json", params, callback);
    }
    
}
