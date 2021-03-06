/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

@SuppressWarnings("all")
public class ScanClosestColor extends CommandBase {
  /**
   * Creates a new ScanClosestColor.
   */
  public ScanClosestColor() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_robotContainer.m_cs);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Gets the closest color and displays it to dashboard
    final Color detected = Robot.m_robotContainer.m_cs.getClosest();
    SmartDashboard.putString("Closest Color RGB", detected.red + " " + detected.green + " " + detected.blue);
    //Displays what rgb to color sensor is seeing
    Robot.m_robotContainer.m_cs.displayRGB();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
