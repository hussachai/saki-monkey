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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Var other = (Var) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

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