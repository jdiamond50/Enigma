run: compile
	java Driver
compile: Driver.class Rotor.class Reflector.class
Driver.class: Driver.java
	javac Driver.java
Rotor.class: Rotor.java
	javac Rotor.java
Reflector.class: Reflector.java
	javac Reflector.java
clean:
	rm *.class
