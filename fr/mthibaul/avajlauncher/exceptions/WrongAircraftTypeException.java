package fr.mthibaul.avajlauncher.exceptions;

public class WrongAircraftTypeException extends Exception {

	public WrongAircraftTypeException(String wrongType, int lineNb) {
		super("Wrong type of aircraft : \"" + wrongType + "\" at line " + lineNb);
	}

}
