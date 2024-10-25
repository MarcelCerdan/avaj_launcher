package fr.mthibaul.avajlauncher.exceptions;

public class WrongParametersNumberException extends Exception {

	public WrongParametersNumberException(int lineNb) {
		super("Wrong number of parameters to describe the aircraft at line " + lineNb + ".\nThe line must be this format : TYPE NAME LONGITUDE LATITUDE HEIGHT.");
	}
}
