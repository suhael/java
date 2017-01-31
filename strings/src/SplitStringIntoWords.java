public class SplitStringIntoWords {

    public final static int MAXFIELDS = 5;
    public final static String DELIM = "|";


    public static String[] process(String line) {
        String[] results = new String[MAXFIELDS];

        java.util.StringTokenizer st = new java.util.StringTokenizer(line, DELIM, true);

        int i = 0;
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals(DELIM)) {
                if (i++>=MAXFIELDS) {
                }
                continue;
            }
            results[i] = s;
        }
        return results;
    }

    public static void printResults(String input, String[] outputs) {

        System.out.println("Input: " + input);
        int i = 0;
        for (String s : outputs) {
            System.out.println("Output " + ++i + " was: " + s);
        }

    }

    public static void main(String[] args) {
        java.util.StringTokenizer st = new java.util.StringTokenizer("Hello world of java");

        while (st.hasMoreTokens())
            System.out.println("Token: " + st.nextToken());

        SplitStringIntoWords st2 = new SplitStringIntoWords();
        st2.printResults("A|B|C|D", process("A|B|C|D"));
        st2.printResults("A||C|D", process("A||C|D"));
        st2.printResults("A|||D|E", process("A|||D|E"));
    }
}