package core;

/**
 * Author: liuqiang
 * Date: 2018-12-20
 * Time: 17:36
 * Description: 就是个保存数据的实体类
 */
public class HeaderInfo {
    public String XAuthSign = "";
    public String XAuthTimeStamp = "";
    public String XAuthToken = "";
    public String XClientIP;
    public String XClientNonceStr;
    public String XClientSign;
    public String XClientTimeStamp;
    public String XClientVersion;

    public String getXClientNonceStr() {
        return this.XClientNonceStr;
    }

    public void setXClientNonceStr(String str) {
        this.XClientNonceStr = str;
    }

    public String getXClientSign() {
        return this.XClientSign;
    }

    public void setXClientSign(String str) {
        this.XClientSign = str;
    }

    public String getXAuthSign() {
        return this.XAuthSign;
    }

    public void setXAuthSign(String str) {
        if (str != null) {
            this.XAuthSign = str;
        }
    }

    public String getXClientIP() {
        return this.XClientIP;
    }

    public void setXClientIP(String str) {
        this.XClientIP = str;
    }

    public String getXClientTimeStamp() {
        return this.XClientTimeStamp;
    }

    public void setXClientTimeStamp(String str) {
        this.XClientTimeStamp = str;
    }

    public String getXClientVersion() {
        return this.XClientVersion;
    }

    public void setXClientVersion(String str) {
        this.XClientVersion = str;
    }

    public String getXAuthTimeStamp() {
        return this.XAuthTimeStamp;
    }

    public void setXAuthTimeStamp(String str) {
        if (str != null) {
            this.XAuthTimeStamp = str;
        }
    }

    public String getXAuthToken() {
        return this.XAuthToken;
    }

    public void setXAuthToken(String str) {
        if (str != null) {
            this.XAuthToken = str;
        }
    }
}