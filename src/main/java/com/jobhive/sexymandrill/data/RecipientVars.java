package com.jobhive.sexymandrill.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jobhive.sexymandrill.utils.Assert;

/**
 * Per-recipient merge variables, which override global merge variables with the
 * same name.
 * 
 * @author Hussachai
 *
 */
public class RecipientVars {

    /**
     * the email address of the recipient that the merge variables should apply
     * to
     */
    private String rcpt;

    /**
     * the recipient's merge variables
     */
    private List<Var> vars;

    public RecipientVars(String rcpt, List<Var> vars) {
        setRcpt(rcpt);
        setVars(vars);
    }

    public String getRcpt() {
        return rcpt;
    }

    public void setRcpt(String rcpt) {
        Assert.notNull(rcpt, "rcpt");
        this.rcpt = rcpt;
    }

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        Assert.notNull(vars, "vars");
        this.vars = vars;
    }

    public void setVars(Var... vars) {
        setVars(new ArrayList<Var>(Arrays.asList(vars)));
    }

    public RecipientVars addVar(String name, Object content) {
        if (this.vars == null) {
            this.vars = new ArrayList<Var>();
        }
        this.vars.add(new Var(name, content));
        return this;
    }

}
