package core;

/**
 * Author: liuqiang
 * Date: 2018-12-20
 * Time: 19:08
 * Description: 就是个保存数据的实体类
 */
public class PackInfo {
    String aesKey;
    String appKey;
    String domain;
    String flurryKey;
    String miId;
    String miKey;
    String packageId;
    String packageName;
    String qqKey;
    String trackKey;
    String umAppkey;
    String umMessagekey;
    String version;
    String wbKey;
    String wxKey;

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getUmAppkey() {
        return this.umAppkey;
    }

    public void setUmAppkey(String str) {
        this.umAppkey = str;
    }

    public String getUmMessagekey() {
        return this.umMessagekey;
    }

    public void setUmMessagekey(String str) {
        this.umMessagekey = str;
    }

    public String getWxKey() {
        return this.wxKey;
    }

    public void setWxKey(String str) {
        this.wxKey = str;
    }

    public String getAesKey() {
        return this.aesKey;
    }

    public void setAesKey(String str) {
        this.aesKey = str;
    }

    public String getFlurryKey() {
        return this.flurryKey;
    }

    public void setFlurryKey(String str) {
        this.flurryKey = str;
    }

    public String getMiId() {
        return this.miId;
    }

    public void setMiId(String str) {
        this.miId = str;
    }

    public String getMiKey() {
        return this.miKey;
    }

    public void setMiKey(String str) {
        this.miKey = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public String getWbKey() {
        return this.wbKey;
    }

    public void setWbKey(String str) {
        this.wbKey = str;
    }

    public String getQqKey() {
        return this.qqKey;
    }

    public void setQqKey(String str) {
        this.qqKey = str;
    }

    public String getTrackKey() {
        return this.trackKey;
    }

    public void setTrackKey(String str) {
        this.trackKey = str;
    }

    @Override
    public String toString() {
        return "PackInfo{" +
                "aesKey='" + aesKey + '\'' +
                ", appKey='" + appKey + '\'' +
                ", domain='" + domain + '\'' +
                ", flurryKey='" + flurryKey + '\'' +
                ", miId='" + miId + '\'' +
                ", miKey='" + miKey + '\'' +
                ", packageId='" + packageId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", qqKey='" + qqKey + '\'' +
                ", trackKey='" + trackKey + '\'' +
                ", umAppkey='" + umAppkey + '\'' +
                ", umMessagekey='" + umMessagekey + '\'' +
                ", version='" + version + '\'' +
                ", wbKey='" + wbKey + '\'' +
                ", wxKey='" + wxKey + '\'' +
                '}';
    }
}