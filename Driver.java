public class Driver {
    public static void main(String[] args) {
        Rotor left = new Rotor("I", 'B', "EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        Rotor middle = new Rotor("II", 'B', "AJDKSIRUXBLHWTMCQGZNPYFVOE");
        Rotor right = new Rotor("III", 'B', "BDFHJLCPRTXVZNYEIWGAKMUSQO");
        Rotor[] rotors = {left, middle, right};
        int curr = 0;
        System.out.println("current Letter: " + ((char)(curr + 'A')));
        right.rotate();
        curr = right.forwardTranslation(curr);
        System.out.println("current Letter: " + ((char)(curr + 'A')));
        curr = middle.forwardTranslation(curr);
        System.out.println("current Letter: " + ((char)(curr + 'A')));
        curr = left.forwardTranslation(curr);
        System.out.println("current Letter: " + ((char)(curr + 'A')));
        curr = 18;
        System.out.println("manually updated current letter to S");
        curr = left.reverseTranslation(curr);
        System.out.println("current Letter: " + ((char)(curr + 'A')));
        curr = middle.reverseTranslation(curr);
        System.out.println("current Letter: " + ((char)(curr + 'A')));
        curr = right.reverseTranslation(curr);
        System.out.println("current Letter: " + ((char)(curr + 'A')));
    }
}
