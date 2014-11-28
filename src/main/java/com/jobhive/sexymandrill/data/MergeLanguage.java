package com.jobhive.sexymandrill.data;

/**
 * 
 * @author Hussachai
 *
 */
public enum MergeLanguage {

    MailChimp("mailchimp"), Handlebars("handlebars");

    private String name;

    private MergeLanguage(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
