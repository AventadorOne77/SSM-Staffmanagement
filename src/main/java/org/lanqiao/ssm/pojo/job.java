package org.lanqiao.ssm.pojo;

public class job {
    private int jid;
    private String jname;

    public job() {
    }

    public job(String jname) {
        this.jname = jname;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Override
    public String toString() {
        return "job{" +
                "jid=" + jid +
                ", jname='" + jname + '\'' +
                '}';
    }
}
