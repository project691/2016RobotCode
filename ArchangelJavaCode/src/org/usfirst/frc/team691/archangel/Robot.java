package org.usfirst.frc.team691.archangel;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;

public class Robot extends IterativeRobot {
	
	private Spark fl;
	private Spark bl;
	private Spark fr;
	private Spark br;
	private Spark intake;
	private Spark gatekeeper;
	private Spark shooter;
	private Victor arm;
	private DigitalInput driveMode;
	private DigitalInput gateLimit;
	private DigitalInput autoType2;
	private DigitalInput autoType3;
	private RobotDrive rd;
	private Joystick rJoy;
	private Joystick lJoy;
	private boolean autoArm;
	private boolean autoDrive;
	private long autoTime;
	private boolean shootFlag;
	private boolean dautoArm;
	private long shootTime;
	CameraServer server;
	
    public void robotInit() {
    	fr = new Spark(2);
		fl = new Spark(0);
		br = new Spark(3);
		bl = new Spark(1);
		intake = new Spark(4);
		gatekeeper = new Spark(5);
		shooter = new Spark(6);
		arm = new Victor(7);
		driveMode = new DigitalInput(0);
		gateLimit = new DigitalInput(3);
		rJoy = new Joystick(0);
		lJoy = new Joystick(1);
		rd = new RobotDrive(fr, br, fl, bl);
		autoArm = false;
		autoDrive = false;
		dautoArm = false;
		autoTime = System.currentTimeMillis();
		shootFlag = false;
		shootTime = System.currentTimeMillis();
		autoType2 = new DigitalInput(1);
		autoType3 = new DigitalInput(2);
		
		fr.setInverted(false);
		fl.setInverted(false);
		br.setInverted(false);
		bl.setInverted(false);
		rd.setSafetyEnabled(false);
		
		server = CameraServer.getInstance();
        server.setQuality(50);
        // The camera name (ex "cam0") can be found through the roborio web interface.
        server.startAutomaticCapture("cam0");
    }
    
	public void autonomousInit() {
		autoArm = false;
		autoDrive = false;
		autoTime = System.currentTimeMillis();
    }

    public void autonomousPeriodic() {
	    if(autoType2.get() && autoType3.get()) // digital inputs default to true with no jumper in
	    {
    		if(System.currentTimeMillis() < autoTime + 5000 && !(System.currentTimeMillis() > autoTime + 7000 && System.currentTimeMillis() > autoTime + 7000)) {
				autoArm = true;
			}
	    	else {
				autoArm = false;
			}
	
	    	if((System.currentTimeMillis() > autoTime + 7000 && System.currentTimeMillis() > autoTime + 7000)) {
				dautoArm = true;
			} else {
				dautoArm = false;
			}
	    	
			if(System.currentTimeMillis() < autoTime + 9000 && System.currentTimeMillis() - autoTime > 5000) {
				autoDrive = true;
			} else {
				autoDrive = false;
			}
	
			if(autoArm && !dautoArm) {
				arm.set(-0.7);
			}else if(dautoArm)
			{
				arm.set(1.0);
			}
			
			else {
				arm.set(0.0);
			}
			
			
			if(autoDrive) {
				fr.set(-1.0);
				fl.set(1.0);
				br.set(-1.0);
				bl.set(1.0);
			} else {
				fr.set(0.0);
				fl.set(0.0);
				br.set(0.0);
				bl.set(0.0);
			}
	    }
	    else if(!autoType2.get())
	    {
	    	{
	    		if(System.currentTimeMillis() < autoTime + 5000 && !(System.currentTimeMillis() > autoTime + 7000 && System.currentTimeMillis() > autoTime + 7000)) {
					autoArm = true;
				}
		    	else {
					autoArm = false;
				}
		
		    	if((System.currentTimeMillis() > autoTime + 7000 && System.currentTimeMillis() > autoTime + 7000)) {
					dautoArm = true;
				} else {
					dautoArm = false;
				}
		    	
				if(System.currentTimeMillis() < autoTime + 9000 && System.currentTimeMillis() - autoTime > 5000) {
					autoDrive = true;
				} else {
					autoDrive = false;
				}
		
						
				if(autoDrive) {
					fr.set(-1.0);
					fl.set(1.0);
					br.set(-1.0);
					bl.set(1.0);
				} else {
					fr.set(0.0);
					fl.set(0.0);
					br.set(0.0);
					bl.set(0.0);
				}
	    	}
	    }
	    else
	    {
			fr.set(0.0);
			fl.set(0.0);
			br.set(0.0);
			bl.set(0.0);
		}
    }
    
    public void teleopInit() {
    	shootFlag = false;
    	shootTime = System.currentTimeMillis();
    }

    public void teleopPeriodic() {
    	if(driveMode.get()) {
			rd.arcadeDrive(lJoy, true);
		} else {
			rd.tankDrive(rJoy, lJoy);
		}

		if(rJoy.getRawButton(1) /*&& !gateLimit.get()*/) {
			intake.set(1.0);
		} else if(rJoy.getRawButton(2)) {
			intake.set(-1.0);
		} else {
			intake.set(0.0);
		}

		if((rJoy.getRawButton(5) /* && !gateLimit.get()) */ )|| (rJoy.getRawButton(3) && shootFlag && System.currentTimeMillis() - shootTime > 1000) || rJoy.getRawButton(1)) {
			gatekeeper.set(1.0);
		} else if(rJoy.getRawButton(4)) {
			gatekeeper.set(-1.0);
		} else {
			gatekeeper.set(0.0);
		}
		
		if(rJoy.getRawButton(3)) {
			shooter.set(-1.0);
			if(!shootFlag) {
				shootTime = System.currentTimeMillis();
				shootFlag = true;
			}
		} else {
			shooter.set(0.0);
			shootTime = System.currentTimeMillis();
			shootFlag = false;
		}

		if(lJoy.getRawButton(3)) {
			arm.set(1.0);
		} else if(lJoy.getRawButton(2)) {
			arm.set(-1.0);
		} else {
			arm.set(0.0);
		}
	}
}
