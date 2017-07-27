package org.usfirst.frc.team1757.robot;

public final class Constants {
    
    // Makes this class uninstantiable
    private Constants(){}

    /** 
     * INCOMPLETE: append for hardware implementation
     * 
     * Structure: hardware elements are organized by class, values are public members. Classes should be uninstantiatable
     * 
     * Purpose: list of all constants for use throughout project
     * */
    public static final class CAN_ {
    	private CAN_(){};
    	
    	public static final int 
    	FRONTLEFT = 0, FRONTRIGHT = 1, BACKLEFT = 2, BACKRIGHT = 3, CANNON = 4;
    }
    
    public static final class PCM_ {
    	private PCM_(){};
    	
    	public static final int 
    	SOLENOID_TANKSELECT = 4, //Changes between high and medium pressure;; loads the firing cache
    	SOLENOID_PISTON_CANNON_SEAL = 6, //Opens and closes the cannon bolt
    	SOLENOID_PISTON_CANNON_CANISTER = 7, //Ejects the canister
    	SPRINKLERVALVE = 5; //Fires the cannon
    }
    
    public static final class AIO_{
    	private AIO_(){};
    	
    	public static final int 
    	STRINGPOT = 0;
    }
    
    public static final class DIO_{
    	private DIO_(){};
    	
    	public static final int 
    	GYRO = 0, PRESSUREGAUGELOW = 0, PRESSUREGAUGEHIGH = 0, STOPSWITCH = 0;
    }
    
    public static final class PWM_ {
    	public static final int
    	COMPRESSOR_CANNON = 0, COMPRESSOR_SOLENOID = 1;
    }
    
    public static final class Gamepad {
        private Gamepad(){}
        public static final int PORT = 1;
        public static final int PORT_N = 2;
        public static final float DEADZONE = 0.08f;
        public static final float INVERTED = 0.0f;
        public static final float TRIGGERZONE = 0.8f;
        public static final String MODE = "NINTENDO";

    	// Constant variables for the button codes on the F310 gamepad
        //TODO: Add in DPAD support
    	public static final int 
    	BUTTON_A = 1, BUTTON_B = 2, BUTTON_X = 3,
    	BUTTON_Y = 4, BUTTON_LB = 5, BUTTON_RB = 6,
    	BUTTON_BACK = 7, BUTTON_START = 8, BUTTON_LS = 9, 
    	BUTTON_RS = 10, AXIS_RTRIGGER = 3, AXIS_LTRIGGER = 2;
    	
    	/**
    	 * Analog (raw)Axis codes
    	 * Left Stick Up/Dn = 2 Axis (Dn+)
    	 * Left Stick L/R = Axis 1 (L-)
    	 * Right Stick Up/Dn = Axis 5 (Dn+)
    	 * Right Stick L/R = Axis 4 (L-)
    	 * Left Trigger = Axis 3 (+)
    	 * Right Trigger = Axis 3 (-)
    	 * Gamepad Up = Axis 2(-)
    	 * Gamepad Dn = Axis 2(+)Gamepad L = Axis 6(-)
    	 * Gamepad R = Axis 6(+)
    	 * 
    	 * NOTE: Mode switch changes Axis 2 between Left Stick Up/Dn and Gamepad Up/Dn 
	*/
    	
    	//Constant variables for the button codes on the Nintendo Gamecube Gamepad
    	public static final int 
    	BUTTON_A_N = 2, BUTTON_B_N = 3, BUTTON_X_N = 1,
    	BUTTON_Y_N = 4, BUTTON_LB_N = 5, BUTTON_RB_N = 6,
    	BUTTON_Z_N = 8, BUTTON_START_N = 10, 
    	AXIS_RTRIGGER_N = 4, AXIS_LTRIGGER_N = 3;
    	
    }
    

    public static final class FlightStick {
        private FlightStick(){}
        public static final int PORT = 2;
        public static final float DEADZONE = 0.08f;
    }
    
    public static final class FlightStick2 {
        private FlightStick2(){}
        public static final int PORT = 3;
        public static final float DEADZONE = 0.08f;
    }
    
    public static final class Safety {
    	private Safety(){};
    	//Should include all safe values for pneumatic or other hardware systems
    	
    
    }
    
    public static final class Piston {
    	private Piston(){};
    	
    	public static final double
    	EJECTDELAY = .3f;
    	
    	public static final boolean
    	PISTON_OUT = true, PISTON_IN = false;
    	
    }
    
    public static final class Cannon {
        private Cannon(){}
        //In the case that a potentiometer is implemented on the cannon for angle measurement, use these values
        
        public static final float TILT_SPEED = 0.075f;
        

    	public static final double
    	CACHEDELAY = .2f;
        
        public static final int 
        INTAKE = 0, SHOOTING = 0, START = 0;
    }
    
}