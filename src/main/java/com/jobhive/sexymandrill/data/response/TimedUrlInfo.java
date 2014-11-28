package com.jobhive.sexymandrill.data.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobhive.sexymandrill.Defaults;

public class TimedUrlInfo extends UrlInfo {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Defaults.DATETIME_FORMAT, timezone = Defaults.TIME_ZONE)
    private Date time;

    public Date getTime() {
        return time;
    }

    public TimedUrlInfo setTime(Date time) {
        this.time = time;
        return this;
    }
    
}
