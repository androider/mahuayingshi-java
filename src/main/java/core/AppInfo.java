package core;

import java.util.Random;

/**
 * Author: liuqiang
 * Date: 2018-12-20
 * Time: 17:33
 * Description:  http header的构造都是用的这里面的方法
 */
public class AppInfo {
    private String terminal;

    public AppInfo() {
//        this.mContext = context;
        this.terminal = isEmulator() ? "5" : "2";
    }

    public boolean isEmulator() {
        return false;
    }

    public static final String SOURCE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String getEncryptPackageId() {
        String packageId = getPackageId();
        int length = packageId.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(length);
        stringBuilder.append(packageId);
        packageId = stringBuilder.toString();
        length = 15 - length;
        if (length >= SOURCE.length()) {
            return SOURCE;
        }
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int nextInt = random.nextInt(SOURCE.length());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(SOURCE.substring(nextInt, nextInt + 1));
            str = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(packageId);
        stringBuilder3.append(str);
        return stringBuilder3.toString();
    }

    public String getPackageId() {
        return RHelp.getPackageId();
    }

    public HeaderInfo createHeaderInfo(String str) {
        HeaderInfo headerInfo = new HeaderInfo();
        long currentTimeMillis = System.currentTimeMillis();
        String generateString = generateString(new Random(), SOURCE, 10);
        String version = RHelp.getVersion();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("");
        headerInfo.setXClientTimeStamp(stringBuilder.toString());
        headerInfo.setXClientNonceStr(generateString);
        headerInfo.setXClientVersion(version);
        headerInfo.setXClientIP(RHelp.getX_Client_IP());
        headerInfo.setXClientSign(getSign(str, currentTimeMillis, generateString, version));

//        headerInfo.setXAuthTimeStamp(b.F);
        //这个值是登陆的时候返回的。
//        headerInfo.setXAuthToken(b.E);
//        headerInfo.setXAuthSign(b.G);

        return headerInfo;
    }

    public String generateString(Random random, String str, int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = str.charAt(random.nextInt(str.length()));
        }
        return new String(cArr);
    }

    public String getSign(String str, long j, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&");
        stringBuilder.append(j);
        stringBuilder.append("&");
        stringBuilder.append(str2);
        stringBuilder.append("&");
        stringBuilder.append(str3);
        stringBuilder.append("&");
        stringBuilder.append(this.terminal);
        stringBuilder.append("&");
        stringBuilder.append(RHelp.getPackageId());
        stringBuilder.append("&");
        stringBuilder.append(RHelp.getAppKey());
        return Md5Util.getMd5256(stringBuilder.toString());
    }

    public String getUuid() {
        return getUUID();
    }

    private String getUUID() {
        String deviceId = "862629030227329";
/*        SharedPreferences sharedPreferences;
        String str = null;
        try {
            deviceId = ((TelephonyManager) this.mContext.getSystemService("phone")).getDeviceId();
        } catch (Throwable e) {
            a.a(e);
            deviceId = null;
        }
        if (deviceId == null || deviceId.isEmpty()) {
            deviceId = Secure.getString(this.mContext.getContentResolver(), "android_id");
            if (deviceId != null) {
                deviceId = deviceId.toLowerCase();
                if (deviceId.equals("9774d56d682e549c")) {
                    deviceId = null;
                }
            }
        }
        if (deviceId == null || deviceId.isEmpty()) {
            WifiInfo connectionInfo = ((WifiManager) this.mContext.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                deviceId = connectionInfo.getMacAddress();
                if (!deviceId.equals("02:00:00:00:00:00")) {
                    str = deviceId.replace(":", "");
                }
                if (str == null && !str.isEmpty()) {
                    return str;
                }
                sharedPreferences = this.mContext.getSharedPreferences(RHelp.STORE_NAME, 0);
                deviceId = sharedPreferences.getString("mhuuid", "");
                if (deviceId == "") {
                    deviceId = UUID.randomUUID().toString().replace("-", "");
                    Editor edit = sharedPreferences.edit();
                    edit.putString("mhuuid", deviceId);
                    edit.commit();
                }
                return deviceId;
            }
        }
        str = deviceId;
        if (str == null) {
        }
        sharedPreferences = this.mContext.getSharedPreferences(RHelp.STORE_NAME, 0);
        deviceId = sharedPreferences.getString("mhuuid", "");
        if (deviceId == "") {
        }*/
        return deviceId;
    }
}
