public class Reflector {
    private String name;
    private int[] wiring;

    /**
     * Constructor for the Reflector class
     * @param name
     * @param wiring 26 character String giving the mapping of each character
     */
    public Reflector(String name, String wiring) {
        this.name = name;

        wiring = wiring.toUpperCase();
        this.wiring = new int[26];
        for (int i = 0; i < this.wiring.length; i++) {
            this.wiring[i] = wiring.charAt(i) - 'A';
        }
    }

    /**
     * Alternate constructor for the Reflector class
     * @param name
     * @param wiring mapping for each character
     */
    public Reflector(String name, int[] wiring) {
        this.name = name;
        this.wiring = wiring.clone();
    }

    /**
     * Reflector output
     * @param input Inputted letter
     * @return Outputted letter
     */
    public int translation(int input) {
        return wiring[input];
    }
}
