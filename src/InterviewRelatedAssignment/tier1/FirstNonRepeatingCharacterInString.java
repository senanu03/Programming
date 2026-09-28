package InterviewRelatedAssignment.tier1;



public class FirstNonRepeatingCharacterInString {

    private static Character findFirstNonRepeating(String str) {

        int count[] = new int[256];
        char c[] = str.toCharArray();

        for(char ch : c){
            count[ch]++;
        }

        for(char ch : c){
            if(count[ch] == 1){
                return ch;
            }
        }

        return null;
    }
    public static void main(String[] args) {

        String str = "Swiss".toLowerCase();

        System.out.println(findFirstNonRepeating(str));

    }


}
