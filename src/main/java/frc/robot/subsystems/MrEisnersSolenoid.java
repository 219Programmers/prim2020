/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class MrEisnersSolenoid extends SubsystemBase {

  public static TalonSRX solenoid;
  public boolean closed = true;
  /**
   * Creates a new MrEisnersSolenoid.
   */
  public MrEisnersSolenoid() {
    solenoid = new TalonSRX(7);
  }

  public void open()
  {
    solenoid.set(ControlMode.PercentOutput, 1);
  }

  public void close()
  {
    solenoid.set(ControlMode.PercentOutput, -1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
