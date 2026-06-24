import java.util.ArrayList;

public class EnigmaMachine {
    ArrayList<Rotor> rotors;
    Reflector reflector;

    public EnigmaMachine() {
        rotors = new ArrayList<Rotor>();
    }

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
}