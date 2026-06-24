run: compile
	java Driver
compile: Driver.class Rotor.class
Driver.class: Driver.java
	javac Driver.java
Rotor.class: Rotor.java
	javac Rotor.java
