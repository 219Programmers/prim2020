/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;

@SuppressWarnings("all")
public class Drive extends CommandBase {
  /**
   * Creates a new Drive.
   */
  public double xs, ys;
  
  public Drive()
  {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
   

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    Climb.climberPneum.SetB();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    if(!AutonLime.disableDrive)
    {
      xs = RobotContainer.getLeftSpeed();
      ys = RobotContainer.getRightSpeed();
      if(!RobotContainer.m_driveTrain.reverse)
      {
        RobotContainer.m_driveTrain.regDrive(ys, xs);
      }
      else
      {
        RobotContainer.m_driveTrain.regDrive(-xs, -ys);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
