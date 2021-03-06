// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc691.PrototypeCode.subsystems;

import org.usfirst.frc691.PrototypeCode.RobotMap;
import org.usfirst.frc691.PrototypeCode.commands.*;
import org.usfirst.frc691.PrototypeCode.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController leftFront = RobotMap.driveTrainLeftFront;
    private final SpeedController leftRear = RobotMap.driveTrainLeftRear;
    private final SpeedController rightFront = RobotMap.driveTrainRightFront;
    private final SpeedController rightRear = RobotMap.driveTrainRightRear;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final DigitalInput driveSwitch = RobotMap.driveTrainDriveSwitch;
    private final AnalogInput driveDistance = RobotMap.driveTrainDriveDistance;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new RunDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    // This function determines whether tank drive is enabled and will
    // consequently take joystick input from one or two motors.
    public void takeJoystickInput(Joystick stick1, Joystick stick2) {
    	if (Robot.useTankDrive) {
    		robotDrive.tankDrive(stick1, stick2);
    	} else {	
    		robotDrive.arcadeDrive(stick1);
    	}
    }
    
    // This function stops the drive motors.
    public void stop() {
    	robotDrive.drive(0,0);
    }
    
    // This function inverts the drive motors and theoretically makes
    // the robot drive in the opposite direction. It was sort of working?
    // Not sure what happens if you push the button twice.
    public void invertMotors() {
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
    
    // This function returns the inverted motors to normal. I think it worked?
    public void returnMotors() {
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
    	Robot.driveTrain.robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    }
    
    // This function returns the distance measured by the ultrasonic sensor.
    public double getDistance() {
    	double distance = driveDistance.getVoltage() / 0.0090;
    	return distance;
    }
}

