public class Rotor {
    private String name;
    private int offset;         // gives current offset of rotor from initial position
    private int setting;    // gives initial position of the rotor
    int[] wiring;

    /**
     * Constructor for the Rotor class
     * @param name
     * @param setting Initial setting of the rotor (ex: 'B' is a Caesar shift of the wiring by 1)
     * @param wiring 26 character String giving the mapping of each character
     */
    public Rotor(String name, char setting, String wiring) {
        this.name = name;
        offset = 0;
        this.setting = setting - 'A';

        wiring = wiring.toUpperCase();
        this.wiring = new int[26];
        for (int i = 0; i < this.wiring.length; i++) {
            this.wiring[i] = wiring.charAt(i) - 'A';
        }
    }

    /**
     * Alternate constructor for the Rotor class
     * @param name
     * @param setting Initial settinf of the rotor (ex: 1 is a Caesar shift of the wiring by 1)
     * @param wiring mapping for each character
     */
    public Rotor(String name, int setting, int[] wiring) {
        this.name = name;
        offset = 0;
        this.setting = setting;
        this.wiring = wiring.clone();
    }

    public void changeSetting(char setting) {
        this.setting = setting - 'A';
    }

    public void clearOffset() {
        offset = 0;
    }

    /**
     * Rotates the rotor
     * @return True if the notch aligns and the next rotor should be rotated
     */
    public boolean rotate() {
        offset = (offset + 1) % 26;
        return false;
    }

    /**
     * Rotor output in right to left direction of translation (before reflector)
     * @param input Inputted letter
     * @return Outputted letter
     */
    public int forwardTranslation(int input) {
        int diff = offset - setting;
        return(wiring[Math.floorMod(input + diff, 26)] - diff) % 26;
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