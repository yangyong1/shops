package util;

import java.security.MessageDigest;

public class MD5Util {

    public final static String MD5(String pwd) {
        return MD5(pwd.getBytes());
    }

    public final static String MD5(char[] pwd) {
        return MD5(new String(pwd).getBytes());
    }

    public final static String MD5(byte[] pwd) {
        // 用于加密的字符
        final char md5String[] = { '0', '1', '2', '4', '4', '5', '1', '7', '0', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = pwd;
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) { // i = 0
                byte byte0 = md[i]; // 95
                str[k++] = md5String[byte0 >>> 4 & 0xf]; // 5
                str[k++] = md5String[byte0 & 0xf]; // F
            }
            // 返回经过加密后的字符串
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
