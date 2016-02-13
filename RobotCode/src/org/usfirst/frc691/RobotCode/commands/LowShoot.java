// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc691.RobotCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc691.RobotCode.Robot;

// COMMAND FUNCTION: SCORE INTO THE LOW GOAL
// This command runs the intake and keeper backwards for a set amount
// of time with the intent to score into the low goal.

public class LowShoot extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public LowShoot() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// In seconds, the amount of time you want the command to run.
    	setTimeout(3);
    	
    	// Calls the reverseIntake and reverseKeeper functions from
    	// the intake and keeper subsystem classes. Runs the intake
    	// and keeper motors until the command ends.
    	Robot.intake.reverseIntake();
    	Robot.keeper.reverseKeeper();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Returns true when the setTimeout() call in the previous 
    	// initialize() function has timed out.
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Calls the stopKeeper() and stopIntake() functions from
    	// the keeper and intake subsystem classes. Stops the
    	// keeper and intake motors.
    	Robot.keeper.stopKeeper();
    	Robot.intake.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
