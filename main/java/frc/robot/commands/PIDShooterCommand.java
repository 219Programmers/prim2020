/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IndexCorral;

public class PIDShooterCommand extends CommandBase {
  /**
   * Creates a new PIDShooterCommand.
   */
  public double setVal;
  public double seconds;
  boolean timed;
  Timer time = new Timer();
  public PIDShooterCommand(double setMe) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.sPID);
    setVal = setMe;
    timed = false;
  }

  public PIDShooterCommand(double seconds, double setMe) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.sPID);
    setVal = setMe;
    timed = true;
    this.seconds = seconds;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    IndexCorral.isLimited = false;
    time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    // sets the setpoint for how fast the motors should go with the PID working. 
    RobotContainer.sPID.setPIDVal(setVal);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // stops the motors and PIDs if interrupted. 
    RobotContainer.sPID.stopMotors();
    IndexCorral.isLimited = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timed && time.get() > seconds;
  }
}
