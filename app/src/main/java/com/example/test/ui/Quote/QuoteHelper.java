package com.example.test.ui.Quote;

public class QuoteHelper {

    String qname, qemail, qcategory, qdescwork, qexpence;

    public QuoteHelper() {
    }

    public QuoteHelper(String qname, String qemail, String qcategory, String qdescwork, String qexpence) {
        this.qname = qname;
        this.qemail = qemail;
        this.qcategory = qcategory;
        this.qdescwork = qdescwork;
        this.qexpence = qexpence;
    }


    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getQemail() {
        return qemail;
    }

    public void setQemail(String qemail) {
        this.qemail = qemail;
    }

    public String getQcategory() {
        return qcategory;
    }

    public void setQcategory(String qcategory) {
        this.qcategory = qcategory;
    }

    public String getQdescwork() {
        return qdescwork;
    }

    public void setQdescwork(String qdescwork) {
        this.qdescwork = qdescwork;
    }

    public String getQexpence() {
        return qexpence;
    }

    public void setQexpence(String qexpence) {
        this.qexpence = qexpence;
    }

}
