package com.jobhive.sexymandrill.data;

/**
 * 
 * @author Hussachai
 *
 */
public class Var {

    /**
     * the merge variable's name. Merge variable names are case-insensitive and
     * may not start with _
     */
    private String name;

    /**
     * the merge variable's content
     */
    private Object content;

    public Var(String name, Object content) {
        setName(name);
        setContent(content);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}