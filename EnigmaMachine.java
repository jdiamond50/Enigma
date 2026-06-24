import java.util.ArrayList;

public class EnigmaMachine {
    ArrayList<Rotor> rotors;
    Reflector reflector;

    public EnigmaMachine() {
        rotors = new ArrayList<Rotor>();
    }

    public char translate(char input) {
        
        int curr = Character.toUpperCase(input) - 'A';
        
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