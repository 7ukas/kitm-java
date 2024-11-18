public class L2_String {
    public static void textAnalyser(String text) {
        /* Splits text by spaces so it's length would represent amount of words */
        int wordsCount = text.split(" ").length;

        /* Gets length of text which is the amount of characters in it */
        int charsCount = text.length();

        /* Removes spaces from given string and iterates through every character
           checking how many times it has repeated in our string. Measures which one is the most frequent */
        String spacelessText = text.replaceAll(" ", "");
        char mostFreqChar = 0;
        int count = 0;

        for (int i = 0; i < spacelessText.length(); i++) {
            int tempCount = 0;

            for (int j = 0; j < spacelessText.length(); j++) {
                if (spacelessText.charAt(i) == spacelessText.charAt(j)) {
                    tempCount++;
                }

                if (tempCount > count) {
                    count = tempCount;
                    mostFreqChar = spacelessText.charAt(i);
                }
            }
        }

        /* Creates StringBuilder object and uses 'reverse' method to reverse every character in our string */
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        String reverseText = sb.toString();

        System.out.println(
                "Words: " + wordsCount +
                        "\nCharacters: " + charsCount +
                        "\nMost frequent character: " + mostFreqChar +
                        "\nReversed: " + reverseText
        );
    }
}
