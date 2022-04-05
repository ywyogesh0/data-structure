package autoseqnumbergeneration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AutoSeqNumberGeneration {

    public static void main(String[] args) throws InterruptedException, IOException {
        int seqNo = 1;
        String k1Message = "çTXN-NEWç,ç3.0.0ç,ç2020-09-10T12:25:35.187748000+01:00     ç,%d,770502,27358260,0153,0,09,0,0000000000000000000000,ç20990910ç,çCç,çvishal                  ç,çlondon          ç,çUK ç,000000,ç12345612345678ç,ç12345612345678ç,çAMEXç,çDEP   ç,+000000000000015.00,+000000000001225.00,çGBPç,ç                  ç,ç                  ç,ç                  ç,ç                  ç,ç                  ç";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/yogwalia/Documents/bash-scripts/k1.txt"))) {
            while (seqNo <= 100) {
                String formattedString = String.format(k1Message, seqNo);
                System.out.println(formattedString);
                bufferedWriter.write(formattedString);
                bufferedWriter.newLine();
                ++seqNo;
                Thread.sleep(500);
            }
        }
    }

}
