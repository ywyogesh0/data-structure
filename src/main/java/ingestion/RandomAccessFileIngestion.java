package ingestion;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileIngestion {

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("sample.txt", "rw")) {
            long count = randomAccessFile.length() - 1;

            randomAccessFile.seek(count);
            byte temp = randomAccessFile.readByte();
            while (temp != 10) {
                count = count - 1;
                randomAccessFile.seek(count);
                temp = randomAccessFile.readByte();
            }

            System.out.println(randomAccessFile.readLine());

            // set new length
            randomAccessFile.setLength(count);
        }
    }
}
