import javax.print.attribute.standard.MediaSize.Engineering;

public class Driver {
    public static void main(String[] args) {

        EnigmaMachine machine = new EnigmaMachine();

        Rotor I = new Rotor("I", 'A', "EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        Rotor II = new Rotor("II", 'A', "AJDKSIRUXBLHWTMCQGZNPYFVOE");
        Rotor III = new Rotor("III", 'A', "BDFHJLCPRTXVZNYEIWGAKMUSQO");

        machine.insertRotor(I);
        machine.insertRotor(II);
        machine.insertRotor(III);

        Reflector reflectorB = new Reflector("Reflector B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");

        machine.insertReflector(reflectorB);
    }
}
