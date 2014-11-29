package com.jobhive.sakimonkey;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jobhive.sakimonkey.exception.IORuntimeException;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * 
 * @author Hussachai
 *
 */
public class MandrillContext {
    
    public static final String BASE_URL = "https://mandrillapp.com/api/1.0";
    
    private String apiKey;

    private Config config;

    private ObjectMapper objectMapper;
    
    private MandrillMetadata metadata;
    
    public MandrillContext(String apiKey, String configPath) {
        this.config = createConfigObject(configPath);
        this.apiKey = (apiKey != null)? apiKey: this.config.getString("apiKey");
        this.objectMapper = createObjectMapper();
        this.metadata = new MandrillMetadata();
        
        Package thisPackage = getClass().getPackage();
        metadata.name = thisPackage.getImplementationTitle();
        metadata.name = thisPackage.getImplementationVersion();
        
    }
    
    public Config getConfig(){
        return config;
    }
    
    public String getApiKey() {
        return apiKey;
    }

    public String getApiUrl(String api) {
        return BASE_URL + api;
    }
    
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    
    public MandrillMetadata getMetadata(){
        return metadata;
    }
    
    protected Config createConfigObject(String configPath){
        Config config = null;
        if (configPath == null) {
            config = ConfigFactory.defaultReference();
        }else{
            if (configPath.startsWith("classpath:")) {
                if (configPath.length() < 11) {
                    throw new IllegalArgumentException("configPath seems not right");
                }
                try (InputStream in = ClassLoader.getSystemClassLoader()
                        .getResourceAsStream(configPath.substring(10))) {
                    config = ConfigFactory.parseReader(new InputStreamReader(in));
                } catch (IOException e) {
                    throw new IORuntimeException(e);
                }
            } else {
                File configFile = new File(configPath);
                if (!configFile.exists() || configFile.isDirectory()) {
                    throw new IllegalArgumentException(
                            "Config file doesn't exist or it's directory");
                }
                config = ConfigFactory.parseFile(configFile);
            }
            config.withFallback(ConfigFactory.defaultReference());
        }
        return config;
    }
    
    protected ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.setVisibility(PropertyAccessor.GETTER, Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.SETTER, Visibility.NONE);
        mapper.setSerializationInclusion(Include.NON_NULL);

        return mapper;
    }
    
    public static class MandrillMetadata {
        
        private String name;
        
        private String version;

        public String getName() {
            return name;
        }

        public String getVersion() {
            return version;
        }
    }
}
