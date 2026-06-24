run: compile
	java Driver
compile: Driver.class EnigmaMachine.class Rotor.class Reflector.class 
Driver.class: Driver.java
	javac Driver.java
EnigmaMachine.class: EnigmaMachine.java
	javac EnigmaMachine.java
Rotor.class: Rotor.java
	javac Rotor.java
Reflector.class: Reflector.java
	javac Reflector.java
clean:
	rm *.class
