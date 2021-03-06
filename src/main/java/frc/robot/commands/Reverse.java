/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Reverse extends CommandBase {
  /**
   * Creates a new Reverse.
   */
  public Reverse() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // flips the motors so the robot will go the other way yeye
    RobotContainer.m_driveTrain.reverse = !RobotContainer.m_driveTrain.reverse;
    // if(RobotContainer.m_driveTrain.reverse)
    // {
    //   Robot.cameraSelection.setString(Robot.backCam.getName());
    // }
    // if(!RobotContainer.m_driveTrain.reverse)
    // {
    //   // Robot.cameraSelection.setString(Robot.frontCam.getName());
    // }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
