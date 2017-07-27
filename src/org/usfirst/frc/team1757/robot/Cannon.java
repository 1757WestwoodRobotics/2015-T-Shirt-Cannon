package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.Timer;

/** 
 * @author Loading
 *
 *Class defines all elements related to the cannon
 *
 *
 */

public class Cannon {
    
    private volatile boolean firing = false;
    private volatile static boolean disabled = false;

    private final DigitalInput stopSwitch = new DigitalInput(Constants.DIO_.STOPSWITCH);
    private final Potentiometer stringPot = new AnalogPotentiometer(Constants.AIO_.STRINGPOT);
    
    private static final Timer reloadTimer = new Timer();
    private static final Timer chargeTimer = new Timer();
    
    private volatile int shotsFired = 0;

    private Cannon() {};
    
    public static Cannon getInstance() {
        return new Cannon();
    }
    
    public double getPotVoltage() {
        return 0;
    }

    public boolean isFiring() {
        return firing;
    }
    
    public int getShotCount() {
        return shotsFired;
    }
    
    public void resetShotCount() {
        shotsFired = 0;
        
    }
    
	
	//Abstracted cannon functions
	public static void charge(){
		Solenoid cacheFill = new Solenoid(Constants.PCM_.SOLENOID_TANKSELECT);
		
		cacheFill.set(Constants.Piston.PISTON_OUT);
		Timer.delay(Constants.Cannon.CACHEDELAY);
		cacheFill.set(Constants.Piston.PISTON_IN);
	}
    
	public static void toggle_Seal(String direction) {
		disabled = true;
		
		Solenoid cannonSeal = new Solenoid(Constants.PCM_.SOLENOID_PISTON_CANNON_SEAL);
		
		if (direction.toLowerCase() == "open" && (cannonSeal.get() == Constants.Piston.PISTON_IN)){
			cannonSeal.set(Constants.Piston.PISTON_OUT);
		}
		
		else if (direction.toLowerCase() == "close" && (cannonSeal.get() == Constants.Piston.PISTON_OUT)){
			cannonSeal.set(Constants.Piston.PISTON_IN);
		}
		disabled = false;
	}
	
	public static void eject(){
		disabled = true;
		Solenoid canEjector = new Solenoid(Constants.PCM_.SOLENOID_PISTON_CANNON_CANISTER);
		
		canEjector.set(Constants.Piston.PISTON_OUT);
		Timer.delay(Constants.Piston.EJECTDELAY);
		canEjector.set(Constants.Piston.PISTON_IN);
		
		disabled = false;
	}
	
	public static void open(){
		disabled = true;
		Solenoid canEjector = new Solenoid(Constants.PCM_.SOLENOID_PISTON_CANNON_SEAL);
		
		if (canEjector.get() == Constants.Piston.PISTON_IN)
			canEjector.set(Constants.Piston.PISTON_OUT);
		disabled = false;
	}
	
	public static void close(){
		disabled = true;
		Solenoid canEjector = new Solenoid(Constants.PCM_.SOLENOID_PISTON_CANNON_SEAL);
		
		if (canEjector.get() == Constants.Piston.PISTON_OUT)
			canEjector.set(Constants.Piston.PISTON_IN);
		disabled = false;
	}
	
    public static void tilt(int coeffecicient) {
    	//coefficient should be 1 for upward, -1 for downward, 0 for no tilt
    	
        SpeedController tiltControl = new CANTalon(Constants.CAN_.CANNON);
        tiltControl.set(Constants.Cannon.TILT_SPEED * coeffecicient);
    }

    public static void reload(){
		reloadTimer.start();
    	
    	open();
    	eject();
    	close();
    	
    	reloadTimer.stop();
    	reloadTimer.reset();
    }
    
    public static void prepare_Fire() {
    	// Complete firing process: report pressure
    	//Wherever this is called should also call the compressor charge method (which has its own timer) and after the reload method
    	if (!disabled) {
    		charge();
    		close();
    		
    	}
    }
    
    public static void fire() {
    	//firing = true;
    	Solenoid sprinklerValve = new Solenoid(Constants.PCM_.SPRINKLERVALVE);
    	
    	sprinklerValve.set(true);
    	sprinklerValve.set(false);
    	
    	//firing = false;
    	//++shotsFired;
    }
}