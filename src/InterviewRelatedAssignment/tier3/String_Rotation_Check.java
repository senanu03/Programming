package InterviewRelatedAssignment.tier3;

public class String_Rotation_Check {
    public static boolean isRotation(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        return (a + a).contains(b);
    }

    public static void main(String[] args) {
        String a1 = "ABCD";
        String b1 = "CDAB";

        String a2 = "hello";
        String b2 = "llohe";

        String a3 = "ABCD";
        String b3 = "ACBD";

        System.out.println(a1 + " and " + b1 + " -> " + isRotation(a1, b1));
        System.out.println(a2 + " and " + b2 + " -> " + isRotation(a2, b2));
        System.out.println(a3 + " and " + b3 + " -> " + isRotation(a3, b3));
    }
}
