package item9;

import java.io.*;

/**
 * packageName : item8
 * fileName : NewFileUtil
 * author : haedoang
 * date : 2022/01/09
 * description :
 */
public class NewFileUtil {
    private NewFileUtil() {
    }

    public static String readFirstLineOfFile(String path) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader.readLine();
        }
    }

    public static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
