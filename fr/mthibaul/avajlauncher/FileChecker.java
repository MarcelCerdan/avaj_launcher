package fr.mthibaul.avajlauncher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.mthibaul.avajlauncher.exceptions.*;

public class FileChecker {

	private List<String> linesList = new ArrayList<>();
	private static String[] aircraftTypes = {"Helicopter", "Baloon", "JetPlane"};

	FileChecker() {}

	private static void checkFirstLine(String line) {
		try {
			int firstLine = Integer.parseInt(line);
			if (firstLine <= 0)
				throw new NoPositiveIntegerException();
		}
		catch (NoPositiveIntegerException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		catch (NumberFormatException e) {
			System.out.println("The first line of the scenario file must be a positive integer number.");
			System.exit(1);
		}
	}

	private static void checkAircraftType(String type, int lineNb) {
		try {
			for (String validType : aircraftTypes) {
				if (validType.equalsIgnoreCase(type))
					return;
			}
			throw new WrongAircraftTypeException(type, lineNb);
		}
		catch (WrongAircraftTypeException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	private static void checkCoordinates(String coord, int lineNb) {
		try {
			int coordValue = Integer.parseInt(coord);

			if (coordValue < 0)
				throw new NoPositiveIntegerException();
		}
		catch (NumberFormatException | NoPositiveIntegerException e) {
			System.out.println("The coordinates of the aircrafts must be positive integer numbers at line " + lineNb);
			System.exit(1);
		}
	}

	private static void checkAircrafts(String line, int lineNb) {
		try {
			String[] splitedLine = line.split(" ");
	
			if (splitedLine.length != 5)
				throw new WrongParametersNumberException(lineNb);
	
			for (int i = 0; i < splitedLine.length; i++) {
				if (i == 0)
					checkAircraftType(splitedLine[i], lineNb);
				if (i >= 2)
					checkCoordinates(splitedLine[i], lineNb);
			}
		}
		catch (WrongParametersNumberException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	private void checkLineValidity(String line, int lineNb) {
		if (linesList.isEmpty())
			checkFirstLine(line);
		else
			checkAircrafts(line, lineNb);
	}

	List<String> checkFile(String fileName) {
		try {
			int lineNb = 1;

			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				checkLineValidity(line, lineNb);
				linesList.add(line);
				lineNb++;
			}
			reader.close();
			return (linesList);
		}
		catch (FileNotFoundException e) {
			System.out.println("Can't open file \"" + fileName + "\"");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return (null);
	}
}
