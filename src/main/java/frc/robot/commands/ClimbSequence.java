/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
@SuppressWarnings("all")
public class ClimbSequence extends SequentialCommandGroup {
  /**
   * Creates a new ClimbSequence.
   */
  public ClimbSequence(boolean down) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(climbSeq(down));
    // super(new ClimberPneumGo(true), new ClimbNow(true, 0.2, 0.5, true), new ClimbNow(false, 5000, false, 0.5));
  }

  public static SequentialCommandGroup climbSeq(boolean down)
  {
    if(down)
    {
      return new ClimberPneumGo(false).andThen(new ClimbNow(false, 1000, false, 0.5));
    }
    return new ClimberPneumGo(false).andThen(new ClimbNow(true, 27500, true, 1));
  }

}
