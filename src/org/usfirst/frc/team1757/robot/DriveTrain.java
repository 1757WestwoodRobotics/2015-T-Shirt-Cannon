package org.usfirst.frc.team1757.robot;

import java.util.Enumeration;
import java.util.Vector;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Gyro;

public class DriveTrain implements SpeedController {
    //Private members for use throughout
	/**
	 * I'm kind of conflicted here: on the one hand it is bad practice to declare an object with no definition
	 * and on the other it is bad practice to make a null pointer object. 
	 * The only way to do it is just to give an empty definition.
	 * 
	 * Also note that I just declare the private variables at the top (even though they are changed later)
	 * because I want to be able to see exactly what belongs to this class and make sure all are private.
	 */
	private Vector motorControllers = null; //Janky null pointer... Should I use a generic Vector or Vector<SpeedController>?
    private float sign = 1.0f;
    
    /** 
     * INCOMPLETE: append for hardware implementation
     * 
     * Structure: takes an array of SpeedControllers as constructor argument and puts them in a vector
     * for ease of use throughout.
     * 
     * Purpose: facilitates mecanum drive by separating wheel sides and allowing interaction per side
     * Programmers should no longer need to access individual motor CANTalon controllers for the drivetrain
     * */
    public DriveTrain(final SpeedController[] controllerArray) {

    	//The constructor must take an array of SpeedControllers with at least one member. 
    	//
        motorControllers = new Vector(controllerArray.length);
        for (int i = 0; i < controllerArray.length; i++) {
            motorControllers.addElement(controllerArray[i]);
        }
    }
    
    //Setter function for the sign coefficient
    public DriveTrain setInverted(final boolean doInvert) {
        if (doInvert) {
            sign = -1.0f;
        } else {
            sign = 1.0f;
        }
        return this;
    }
    
    //Getter function for the DriveTrain CANTalon value
    public double get() {
    	//Each of the SpeedControllers in the vector should be the same, so we'll use the first one
    	//Outputs the speed value of this SpeedController -1 to 1
        final SpeedController controller = (SpeedController) motorControllers.firstElement();
        return sign * controller.get();
    }
    
    //Setter function for the DriveTrain CANTalon value
    public void set(double value) {
        // Sets the value of each SpeedController to the given double value
        final Enumeration controllers = motorControllers.elements(); //Creates enumeration (temporary class object) for each element
        while (controllers.hasMoreElements()) { //Must be traversed similar to an iterator
            final SpeedController controller = (SpeedController) controllers.nextElement();
            controller.set(sign * value);
        }
    }
    
    //In order to inherit from speedcontroller I have to implement it's abstract disable() function
    public void disable() {
    	final Enumeration controllers = motorControllers.elements(); //Creates enumeration (temporary class object) for each element
        while (controllers.hasMoreElements()) { //Must be traversed similar to an iterator
            final SpeedController controller = (SpeedController) controllers.nextElement();
            controller.disable();
        }
    }
    
    //I also have to implement the overloaded set function. Don't use this
    //This will do the same thing as the original set() because I can't find what syncGroup should be
    public void set(double value, byte syncGroup){ 
    	// Sets the value of each SpeedController to the given double value
        final Enumeration controllers = motorControllers.elements(); //Creates enumeration (temporary class object) for each element
        while (controllers.hasMoreElements()) { //Must be traversed similar to an iterator
            final SpeedController controller = (SpeedController) controllers.nextElement();
            controller.set(sign * value);
        }
    }

	//I also have to implement abstract method pidWrite. I don't fully understand it's purpoe, but this is implemented correctly
	public void pidWrite(double output) {
		// Sets the value of each SpeedController to the given double value
        final Enumeration controllers = motorControllers.elements(); //Creates enumeration (temporary class object) for each element
        while (controllers.hasMoreElements()) { //Must be traversed similar to an iterator
            final SpeedController controller = (SpeedController) controllers.nextElement();
            controller.pidWrite(sign * output); //This is just matching the documentation
        }
	}
	
	public SpeedController getController(int index)
	{
		int i = 0;
        final Enumeration controllers = motorControllers.elements(); //Creates enumeration (temporary class object) for each element
        SpeedController controller = null; //Janky null instantiation
        while (controllers.hasMoreElements() && (i < index)) { //Must be traversed similar to an iterator
            controller = (SpeedController) controllers.nextElement();
            ++index;
        }
        return controller;
	}
	
	public void MecanumDrive(Gamepad gamepad)
	{
        //RobotDrive roboDrive = new RobotDrive((SpeedController leftDrive = (new CANTalon(Constants.CAN_.BACKLEFT))), 
        //		(SpeedController rightDrive = (new CANTalon(Constants.CAN_.BACKRIGHT))));
    	Gyro gyroMeter = new Gyro(Constants.DIO_.GYRO);
		RobotDrive roboDrive = new RobotDrive(getController(0), getController(1), getController(2), getController(3));
		
        roboDrive.mecanumDrive_Cartesian(gamepad.getX(), gamepad.getY(), gamepad.getTwist(), gyroMeter.getAngle());
	}
}
