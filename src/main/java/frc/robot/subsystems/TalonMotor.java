/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TalonMotor extends SubsystemBase {

  TalonSRX motor;
  CANSparkMax s_motor;
  /**
   * Creates a new TalonMotor.
   */
  public TalonMotor(int can, boolean isTalon) {
    if(isTalon)
    {
      motor = new TalonSRX(can);
    }
    else
    {
      s_motor = new CANSparkMax(can, MotorType.kBrushless);
    }
  }

  public TalonMotor(int can) {
    motor = new TalonSRX(can);
  }
  public void move(double a)
  {
    try
    {
    motor.set(ControlMode.PercentOutput, a);
    }
    catch(Exception e)
    {
      s_motor.set(a);
    }
  }

  public void stop()
  {
    try
    {
    motor.set(ControlMode.PercentOutput, 0);
    }
    catch(Exception e)
    {
      s_motor.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
