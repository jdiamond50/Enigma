import javax.print.attribute.standard.MediaSize.Engineering;

public class Driver {
    public static void main(String[] args) {

        EnigmaMachine machine = new EnigmaMachine();

        Rotor I = new Rotor("I", 'A', 'Q', 'A', "EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        Rotor II = new Rotor("II", 'A', 'E', 'A', "AJDKSIRUXBLHWTMCQGZNPYFVOE");
        Rotor III = new Rotor("III", 'A', 'V', 'A', "BDFHJLCPRTXVZNYEIWGAKMUSQO");

        machine.insertRotor(I);
        machine.insertRotor(II);
        machine.insertRotor(III);

        Reflector reflectorB = new Reflector("Reflector B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");

        machine.insertReflector(reflectorB);

        String initMessage = "AAAAA";
        String translatedMessage = machine.translate(initMessage);
        String retranslatedMessage = machine.translate(translatedMessage);
        System.out.println("initMessage: " + initMessage);
        System.out.println("translatedMessage: " + translatedMessage);
        System.out.println("retranslatedMessage: " + retranslatedMessage);

        System.out.println("updating rotor settings");
        machine.changeRotorSettings("BBB");

        initMessage = "AAAAA";
        translatedMessage = machine.translate(initMessage);
        retranslatedMessage = machine.translate(translatedMessage);
        System.out.println("initMessage: " + initMessage);
        System.out.println("translatedMessage: " + translatedMessage);
        System.out.println("retranslatedMessage: " + retranslatedMessage);

    }
}
