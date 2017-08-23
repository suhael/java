import java.io.BufferedReader;
import java.io.IOException;

public class CharactersInAfile {

    /** CheckSum one text file, given an open BufferedReader.
     * Checksumm does not include line endings, so will give the
     * same value for given text on any platform. Do not use
     * on binary files!
     */
    public int checksum(BufferedReader is) {
        int sum = 0;
        try {
            String inputLine;
            while ((inputLine = is.readLine()) != null) {
                int i;
                for (i=0; i<inputLine.length(); i++) {
                    sum += inputLine.charAt(i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException: " + e);
        }
        return sum;
    }


    public static void main(String[] args) {

    }
}
