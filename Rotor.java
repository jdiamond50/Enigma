public class Rotor {
    private String name;
    private int initialPosition;
    private int offset;         // gives current position of rotor
    private int setting;        // gives rotation of internal wiring
    int[] wiring;
    int notch;                  

    /**
     * Constructor for the Rotor class
     * @param name
     * @param setting Rotation of internal wiring of rotor
     * @param notch Location of rotor notch (next rotor will rotate if this rotor rotates from notch to notch+1)
     * @param initialPosition Initial setting of rotor (as appearing in the machine's window)
     * @param wiring 26 character String giving the mapping of each character
     */
    public Rotor(String name, char setting, char notch, char initialPosition, String wiring) {
        this.name = name;
        this.setting = setting - 'A';
        this.notch = notch - 'A';
        this.initialPosition = initialPosition - 'A';
        offset = this.initialPosition;

        wiring = wiring.toUpperCase();
        this.wiring = new int[26];
        for (int i = 0; i < this.wiring.length; i++) {
            this.wiring[i] = wiring.charAt(i) - 'A';
        }
    }

    /**
     * Alternate constructor for the Rotor class
     * @param name
     * @param setting Initial position of the rotor (ex: 1 is a Caesar shift of the wiring by 1)
     * @param wiring mapping for each character
     */
    public Rotor(String name, int setting, int notch, int initialPosition, int[] wiring) {
        this.name = name;
        this.setting = setting;
        this.notch = notch;
        this.initialPosition = initialPosition;
        offset = this.initialPosition;
        this.wiring = wiring.clone();
    }

    // ----- GETTERS -----

    public String getName() { return name; }
    public char getPosition() { return (char) (offset + 'A'); }
    public char getNotch() { return (char) (notch + 'A'); }

    // ----- SETTERS -----

    /**
     * Rotate the rotor's internal wiring to a new setting
     * @param setting
     */
    public void changeSetting(char setting) {
        this.setting = setting - 'A';
    }

    /**
     * Change rotors position to new position
     * @param position
     */
    public void changePosition(char position) {
        offset = position;
    }

    /**
     * Resets the rotor's offset to its initial position
     */
    public void clearOffset() {
        offset = initialPosition;
    }

    // ----- MECHANICAL -----

    /**
     * Rotates the rotor
     */
    public void rotate() {
        offset++;
    }

    // ----- TRANSLATION -----

    /**
     * Rotor output in right to left direction of translation (before reflector)
     * @param input Inputted letter
     * @return Outputted letter
     */
    public int forwardTranslation(int input) {
        int diff = offset - setting;
        return Math.floorMod((wiring[Math.floorMod(input + diff, 26)] - diff), 26);
    }

    /**
     * Rotor output in left to right direction of translation (after reflector)
     * @param input Inputted letter
     * @return Outputted letter
     */
    public int reverseTranslation(int input) {
        int diff = offset - setting;
        for (int i = 0; i < wiring.length; i++) {
            if (wiring[i] == Math.floorMod(input + diff, 26)) return Math.floorMod(i - diff, 26);
        }
        return -1;
    }
}