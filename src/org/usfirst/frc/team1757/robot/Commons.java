package org.usfirst.frc.team1757.robot;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;

public class Commons {
	
	//void function designed to read all lines from a .txt file and return them to a string array
	public static String[] readLines(String path)
	{
		try {
    		Scanner filescan = new Scanner(path);
    		 List<String> outList = Arrays.asList(); //Safe empty declaration
    		while (filescan.hasNextLine())
    		{
    			outList.add(filescan.nextLine());
    		}
    		filescan.close();
    		return (String[]) outList.toArray(); // Possibly dangerous type casting
    	}
    	catch (Exception e)
    	{
    		System.out.println("Error opening button layout file, will use defaults\n" + e.toString());
    		return new String[] {};
    	}
	}

	public static void smartDashboard_log(String key, String message){
		System.out.println(key + ": " + message);
		SmartDashboard.putString(key, message);
	}
	
	public static void compressor_Toggle()
	{
		//Enable the spikeRelay associated with the Compressor port number; 
		//likely will need to be appended depending on hardware implementation
		
	}
}