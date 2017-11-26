package encodeing;



import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.*;
import java.nio.charset.UnsupportedCharsetException;

public class Program {
    public static void main(String[] args) {
        String filePath = "c:" + File.separator + "encode.txt";
        try {

            FileInputStream inputStream = new FileInputStream(filePath);

            byte[] content_byte = new byte[200];
            inputStream.read(content_byte);

            String content_string = new String(content_byte,"ISO-8859-1");
            System.out.println(content_string);



            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath),"GBK");

            char[] cs = new char[200];
            inputStreamReader.read(cs);
            System.out.println(cs);
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
