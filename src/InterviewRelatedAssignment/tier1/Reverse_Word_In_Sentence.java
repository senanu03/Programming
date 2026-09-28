package InterviewRelatedAssignment.tier1;

public class Reverse_Word_In_Sentence {
    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder word = new StringBuilder(words[i]);

            result.append(word.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "Hello world";

        System.out.println(reverseEachWord(input));
    }

}
