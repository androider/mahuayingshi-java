package core; /**
 * Author: liuqiang
 * Date: 2018-12-20
 * Time: 13:51
 * Description:
 */

import java.security.MessageDigest;

public class Md5Util {
    private static char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getMd5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return byteArrayToHex(instance.digest());
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getMd5256(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            return byteArrayToHex(instance.digest());
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getMd51(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes());
            return byteArrayToHex(instance.digest());
        } catch (Exception unused) {
            return str;
        }
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = hexDigits[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = hexDigits[b & 15];
        }
        return new String(cArr);
    }

    public static void main(String[] strArr) {
        System.out.println(getMd5256("/api/v2/user/login/2/53&1536569214262&3ace178t&2.0.0&2&53&3ace1781571b766ad65c6d7eecc285db"));
    }
}