package com.jobhive.sexymandrill;

/**
 * 
 * @author Hussachai
 *
 */
public class MandrillClient extends AbstractMandrillClient {
    
    public MandrillClient(){}
    
    public MandrillClient(MandrillContext context) {
        super(context);
    }
    
    public MandrillClient(String apiKey, String configPath){
        super(apiKey, configPath);
    }
    
    @Override
    protected void init() {
        
    }
    
    @Override
    public void shutdown() {
       
    }
    

}
