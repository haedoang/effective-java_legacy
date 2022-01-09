package item9;

import java.io.*;

/**
 * packageName : PACKAGE_NAME
 * fileName : item9.FileUtil
 * author : haedoang
 * date : 2022/01/09
 * description :
 */
public class FileUtil {
    private FileUtil() {
    }

    public static String readFirstLineOfFile(String src) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(src));
        try {
            return br.readLine();
        } finally {
            br.close();
        }

    }

    public static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1024];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
