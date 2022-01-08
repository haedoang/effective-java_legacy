package item8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * packageName : item8
 * fileName : Finalizable
 * author : haedoang
 * date : 2022/01/08
 * description :
 */
public class Finalizable {
    private final BufferedReader bufferedReader;

    public Finalizable() {
        InputStream input = this.getClass()
                .getClassLoader()
                .getResourceAsStream("file.txt");
        this.bufferedReader = new BufferedReader(new InputStreamReader(input));
    }

    public String readFirstLine() throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    protected void finalize() {
        try {
            bufferedReader.close();
            System.out.println("finalize invoke!!");
        } catch(IOException e) {

        }
    }

    public boolean isClose() {
        try {
            bufferedReader.ready();
        } catch(Exception e) {
            return true;
        }
        return false;
    }
}
