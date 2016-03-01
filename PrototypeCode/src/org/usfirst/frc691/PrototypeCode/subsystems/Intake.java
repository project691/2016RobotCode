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
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    // This function runs the intake motor at a set speed.
    public void runIntake() {
    	intakeMotor.set(-0.8);
    }
    
    // This function runs the intake motor reversely at a set speed.
    public void reverseIntake() {
    	intakeMotor.set(0.8);
    }
    
    // This function runs the intake motor reversely and slowly at
    // a set speed. Was created for the PushIntake command.
    public void slowIntake() {
    	intakeMotor.set(-0.5);
    }
    
    // This function stops the intake motor.
    public void stopIntake() {
    	intakeMotor.set(0);
    } 
}

