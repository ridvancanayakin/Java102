package Locations;

import java.util.Scanner;
import Builds.Build;

public abstract class Location {
	Scanner s= new Scanner(System.in);
	public abstract void onLocation(Build pC);
}
