package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

/**
 * 
 * @author Hussachai
 *
 */
public class TimedStats extends Stats{
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date time;

    public Date getTime() {
        return time;
    }
    
}
