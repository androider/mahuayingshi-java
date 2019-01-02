package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author: liuqiang
 * Date: 2018-12-20
 * Time: 13:49
 * Description: 这个类里的字段是在 assert/pack_info 文件里面的解密后的字符串
 */
public class RHelp {
    public static String aesKey = "DtXZcHh9XJ5SfPAe";
    private static String appKey;
    public static String packageId;
    private static String version;

    static {

        InputStream open = null;
        try {

            String filePath = RHelp.class.getResource("/pack_info").getPath();

            open = new FileInputStream(new File(filePath));
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            String str = new String(bArr, "utf8");
            String decryptHex = AesUtil.decryptHex(str, AesUtil.getKey(true));
            if (decryptHex != null) {
                str = decryptHex;
            }
            //这个e是混淆后的Gson类
            RHelp.initInfo(new com.google.gson.Gson().fromJson(str, PackInfo.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initInfo(PackInfo packInfo) {
        setVersion(packInfo.getVersion());
        setAppKey(packInfo.getAppKey());
        setPackageId(packInfo.getPackageId());

        //System.out.println("initInfo:" + packInfo);
    }

    public static String getKey() {
        return aesKey;
    }

    public static void setPackageId(String str) {
        packageId = str;
    }

    public static String getPackageId() {
        if (isEmpty(packageId))
            return "7";
        else
            return packageId;
    }

    public static void setVersion(String str) {
        version = str;
    }

    public static String getVersion() {
        if (isEmpty(version))
            return "2.3.0";
        else
            return version;
    }

    public static String getX_Client_IP() {
        return "127.0.0.1";
    }

    public static String getAppKey() {
        if (isEmpty(appKey))
            return "d221266fd3457bbacbfb914e6c3e0af3";
        else
            return appKey;
    }

    public static void setAppKey(String str) {
        appKey = str;
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }
}
