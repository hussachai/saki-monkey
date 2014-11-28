package com.jobhive.sexymandrill.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobhive.sexymandrill.utils.Assert;

/**
 * 
 * @author Hussachai
 *
 */
public class Recipient {

    public enum Type {

        To, CC, BCC;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }

    }
    /**
     * the email address of the recipient
     */
    private String email;

    /**
     * the optional display name to use for the recipient
     */
    private String name;

    /**
     * the header type to use for the recipient, defaults to "to" if not
     * provided oneof(to, cc, bcc)
     */
    private Recipient.Type type = Recipient.Type.To;
    
    @JsonIgnore
    private List<Var> vars;

    public Recipient() {
    }

    public Recipient(String email, String name, Recipient.Type type) {
        setEmail(email);
        setName(name);
        setType(type);
    }

    public Recipient(String email, String name) {
        this(email, name, Recipient.Type.To);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Recipient setName(String name) {
        this.name = name;
        return this;
    }

    public Recipient.Type getType() {
        return type;
    }

    public Recipient setType(Recipient.Type type) {
        this.type = type;
        return this;
    }

    public List<Var> getVars() {
        return vars;
    }

    public Recipient setVars(List<Var> vars) {
        this.vars = vars;
        return this;
    }

    public Recipient addVar(Var var) {
        Assert.notNull(var, "var");
        if (this.vars == null) {
            this.vars = new ArrayList<>();
        }
        this.vars.add(var);
        return this;
    }

    public Recipient addVar(String name, Object content) {
        Var var = new Var(name, content);
        return addVar(var);
    }
}
