package encodeing;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Program {
    public static void main(String[] args) {
        String filePath = "c:" + File.separator + "LibAntiPrtSc_INFORMATION.log";
        try {
            String fileEncode = codeString(filePath);
            System.out.println(fileEncode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String codeString(String fileName) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(
                new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        String code = null;
        //其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            case 0x5c75:
                code = "ANSI|ASCII";
                break;
            default:
                code = "GBK";
        }

        return code;
    }
}
