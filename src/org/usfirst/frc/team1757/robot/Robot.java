
package org.usfirst.frc.team1757.robot;

//Class imports from the WPILibj library
import java.io.Console;

import edu.wpi.first.wpilibj.IterativeRobot;

//Added WPI Library imports

import edu.wpi.first.wpilibj.SpeedController;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Importing functions from Commons class
import org.usfirst.frc.team1757.robot.DriveTrain;

/**
 * WPI GENERATED COMMENT
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
		
	//TODO REMOVE --- Class reference variables
		//I don't understand why we use these, you generally aren't supposed to have null declarations. Safer?
		//See SpeedController instantiations for alternative examples
	Gamepad gamepad;
	DriveTrain driveTrain;
	SpeedController leftDrive;
	SpeedController rightDrive;
	
    public void robotInit() {
    	gamepad = new Gamepad(Constants.Gamepad.PORT_N);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	/**
    	 * In this branch of the project support for a loop & if maze based system of controller input; however,
    	 * future branches should utilize event based input for the sake of a cleaner project and better programming practice.
    	 * 
    	 * Note the structure of the code: the buttons are detected sequentially with priority those placed the highest
    	 * 
    	 * */
        while(isEnabled() && isOperatorControl()){
        	//Loops during FRC safe operator control time
            
        	//All controls involving the drive train
        	//driveTrain.MecanumDrive(gamepad);
        	
        	
            if (gamepad.getButton_A()) {
            	System.out.println("Test");
            	SmartDashboard.putString("A", "True");
            }
            
            else if (gamepad.getButton_B()){
            	
            }
            
            else if (gamepad.getButton_X()){
            	
            }
            
            else if (gamepad.getButton_Y()){
            	
            }
            
            else if (gamepad.getButton_START()){
            	
            }
            
            else if (gamepad.getButton_BACK()) {
            	
            }
            
            else if (gamepad.getTrigger_Left()){
            	
            }
            
            else if (gamepad.getTrigger_Right()){
            	Cannon.prepare_Fire();
            	Cannon.fire();
            	Cannon.reload();
            }
            
			Cannon.tilt(0);
            
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
