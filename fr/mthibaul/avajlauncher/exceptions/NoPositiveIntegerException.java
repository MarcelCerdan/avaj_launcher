package fr.mthibaul.avajlauncher.exceptions;

public class NoPositiveIntegerException extends Exception {

	public NoPositiveIntegerException() {
		super("The first line of the scenario contains a negative number, please input a positive integer number.");
	}

}
