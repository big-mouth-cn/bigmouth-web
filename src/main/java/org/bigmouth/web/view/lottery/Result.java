package org.bigmouth.web.view.lottery;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class Result implements Serializable {

    /**  */
    private static final long serialVersionUID = 5910470650395901794L;

    @Expose
    private int errorcode = 0;

    @Expose
    private String errordesc;

    @Expose
    private String errorspecific;

    @Expose
    private Data data = new Data();

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrordesc() {
        return errordesc;
    }

    public void setErrordesc(String errordesc) {
        this.errordesc = errordesc;
    }

    public String getErrorspecific() {
        return errorspecific;
    }

    public void setErrorspecific(String errorspecific) {
        this.errorspecific = errorspecific;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data implements Serializable {

        /**  */
        private static final long serialVersionUID = -2540951466720315054L;

        @Expose
        private int status = 1;

        @Expose
        private String custom;

        @Expose
        private int ret = 1;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCustom() {
            return custom;
        }

        public void setCustom(String custom) {
            this.custom = custom;
        }

        public int getRet() {
            return ret;
        }

        public void setRet(int ret) {
            this.ret = ret;
        }

    }
}
