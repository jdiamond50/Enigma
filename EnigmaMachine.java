import java.util.ArrayList;
import java.lang.StringBuilder;

public class EnigmaMachine {
    ArrayList<Rotor> rotors;
    Reflector reflector;

    public EnigmaMachine() {
        rotors = new ArrayList<Rotor>();
    }

    /**
     * Translate a string
     * @param input String to be translated (all uppercase, no spaces)
     * @return Translated String
     */
    public String translate(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(translate(input.charAt(i)));
        }
        return result.toString();
    }

    /**
     * Translate a character
     * @param input char to be translated (uppercase)
     * @return Translated char
     */
    public char translate(char input) {
        
        int curr = Character.toUpperCase(input) - 'A';
        
        // rotate rotors
        for (int i = rotors.size() - 1; i >= 0; i--) {
            boolean rotateNext = rotors.get(i).rotate();
            if (!rotateNext) break; // if notch isn't aligned
        }
        
        // right to left through rotors
        for (int i = rotors.size() - 1; i >= 0; i--) {
            Rotor currRotor = rotors.get(i);
            curr = currRotor.forwardTranslation(curr);
        }

        // through reflector
        curr = reflector.translation(curr);

        // left to right through rotors
        for (int i = 0; i < rotors.size(); i++) {
            Rotor currRotor = rotors.get(i);
            curr = currRotor.reverseTranslation(curr);
        }

        return (char)(curr + (int)'A');
    }

    // ----- ROTORS -----

    /**
     * Inserts new rotor to the right of existing rotors
     * @param rotor Rotor to be inserted
     */
    public void insertRotor(Rotor rotor) {
        rotors.add(rotor);
    }

    /**
     * Clears the rotors
     */
    public void clearRotors() {
        rotors.clear();
    }



    // ----- REFLECTOR -----

    public void insertReflector(Reflector reflector) {
        this.reflector = reflector;
    }
}