package com.jobhive.sexymandrill.api;

import java.util.Map;

import com.jobhive.sexymandrill.MandrillClient;
import com.jobhive.sexymandrill.data.Result;
import com.jobhive.sexymandrill.data.response.DedicatedIp;
import com.jobhive.sexymandrill.data.response.DedicatedIp.CustomDnsStatus;
import com.jobhive.sexymandrill.data.response.DedicatedIp.IpDeleteStatus;
import com.jobhive.sexymandrill.data.response.DedicatedIpPool;
import com.jobhive.sexymandrill.data.response.DedicatedIpPool.PoolDeleteStatus;

/**
 * 
 * @author Hussachai
 *
 */
public class IpApi extends MandrillApi {

    public IpApi(MandrillClient client) {
        super(client);
    }

    /**
     * Lists your dedicated IPs.
     * 
     * @return
     */
    public Result<DedicatedIp[]> list() {
        return getClient().execute(DedicatedIp[].class, IP_LIST, null);
    }
    
    /**
     * Retrieves information about a single dedicated ip.
     * @param ip a dedicated IP address
     * @return
     */
    public Result<DedicatedIp> info(String ip) {
        return getClient().execute(DedicatedIp.class, IP_INFO, 
                mapParams("ip", ip));
    }
    
    /**
     * Requests an additional dedicated IP for your account. 
     * Accounts may have one outstanding request at any time, and provisioning 
     * requests are processed within 24 hours.
     * @param warmup whether to enable warmup mode for the ip
     * @param pool the id of the pool to add the dedicated ip to, or null to use your account's default pool
     * @return
     */
    public Result<DedicatedIp> provision(Boolean warmup, String pool) {
        Map<String, Object> params = mapParams("warmup", warmup).p("pool", pool);
        return getClient().execute(DedicatedIp.class, IP_PROVISION, params);
    }
    
    /**
     * Begins the warmup process for a dedicated IP. During the warmup process, 
     * Mandrill will gradually increase the percentage of your mail that is sent over 
     * the warming-up IP, over a period of roughly 30 days. The rest of your mail 
     * will be sent over shared IPs or other dedicated IPs in the same pool.
     * @param ip a dedicated ip address
     * @return
     */
    public Result<DedicatedIp> startWarmup(String ip) {
        return getClient().execute(DedicatedIp.class, 
                IP_START_WARMUP, mapParams("ip", ip));
    }
    
    /**
     * Cancels the warmup process for a dedicated IP.
     * @param ip a dedicated ip address
     * @return
     */
    public Result<DedicatedIp> cancelWarmup(String ip) {
        return getClient().execute(DedicatedIp.class,
                IP_CANCEL_WARMUP, mapParams("ip", ip));
    }
    
    /**
     * Moves a dedicated IP to a different pool.
     * @param ip a dedicated ip address
     * @param pool the name of the new pool to add the dedicated ip to
     * @param createPool whether to create the pool if it does not exist; 
     *        if false and the pool does not exist, an Unknown_Pool will be thrown.
     * @return
     */
    public Result<DedicatedIp> setPool(String ip, String pool, Boolean createPool) {
        Map<String, Object> params = mapParams("ip", ip)
                .p("pool", pool).p("create_pool", createPool);
        return getClient().execute(DedicatedIp.class, IP_SET_POOL, params);
    }
    
    /**
     * Deletes a dedicated IP. This is permanent and cannot be undone.
     * @param ip the dedicated ip to remove from your account
     * @return
     */
    public Result<IpDeleteStatus> delete(String ip) {
        return getClient().execute(IpDeleteStatus.class,
                IP_DELETE, mapParams("ip", ip));
    }
    
    /**
     * Lists your dedicated IP pools.
     * @return
     */
    public Result<DedicatedIpPool[]> listPools() {
        return getClient().execute(DedicatedIpPool[].class, 
                IP_LIST_POOLS, null);
    }
    
    /**
     * Describes a single dedicated IP pool.
     * @param pool a pool name
     * @return
     */
    public Result<DedicatedIpPool> poolInfo(String pool) {
        return getClient().execute(DedicatedIpPool.class,
                IP_POOL_INFO, mapParams("pool", pool));
    }
    
    /**
     * Creates a pool and returns it. 
     * If a pool already exists with this name, no action will be performed.
     * @param pool the name of a pool to create
     * @return
     */
    public Result<DedicatedIpPool> createPool(String pool) {
        return getClient().execute(DedicatedIpPool.class, IP_CREATE_POOL, 
                mapParams("pool", pool));
    }
    
    /**
     * Deletes a pool. A pool must be empty before you can delete it, 
     * and you cannot delete your default pool.
     * @param pool the name of the pool to delete
     * @return
     */
    public Result<PoolDeleteStatus> deletePool(String pool) {
        return getClient().execute(PoolDeleteStatus.class,
                IP_SET_POOL, mapParams("pool", pool));
    }
    
    /**
     * Tests whether a domain name is valid for use as the custom reverse 
     * DNS for a dedicated IP.
     * @param ip
     * @param domain
     * @return
     */
    public Result<CustomDnsStatus> checkCustomDns(String ip, String domain) {
        Map<String, Object> params = mapParams("ip", ip).p("domain", domain);
        return getClient().execute(CustomDnsStatus.class,
                IP_CHECK_CUSTOM_DNS, params);
    }
    
    /**
     * Configures the custom DNS name for a dedicated IP.
     * @param ip a dedicated ip address
     * @param domain a domain name to set as the dedicated IP's custom dns name.
     * @return
     */
    public Result<DedicatedIp> setCustomDns(String ip, String domain) {
        Map<String, Object> params = mapParams("ip", ip).p("domain", domain);
        return getClient().execute(DedicatedIp.class, 
                IP_SET_CUSTOM_DNS, params);
    }
    
}
