import javax.print.attribute.standard.MediaSize.Engineering;

public class Driver {
    public static void main(String[] args) {

        EnigmaMachine machine = new EnigmaMachine();

        Rotor I = new Rotor("I", 'B', "EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        Rotor II = new Rotor("II", 'B', "AJDKSIRUXBLHWTMCQGZNPYFVOE");
        Rotor III = new Rotor("III", 'B', "BDFHJLCPRTXVZNYEIWGAKMUSQO");

        machine.insertRotor(I);
        machine.insertRotor(II);
        machine.insertRotor(III);

        Reflector reflectorB = new Reflector("Reflector B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");

        machine.insertReflector(reflectorB);

        String str = "AAAAA";
        for (int i = 0; i < str.length(); i++) {
            System.out.print(machine.translate(str.charAt(i)));
        }
    }
}
