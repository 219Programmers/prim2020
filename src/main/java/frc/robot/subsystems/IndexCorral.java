/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.PulseCorral;
import frc.robot.commands.RevCor;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IndexCorral extends SubsystemBase {
  /**
   * Creates a new IndexCorral.
   */
  public CANSparkMax beltMoto;
 
  public static int ballAmount = 5;
  
  public IndexCorral() {
    
    beltMoto = new CANSparkMax(Constants.BELT, MotorType.kBrushless);
    beltMoto.setOpenLoopRampRate(0.5);
    beltMoto.setClosedLoopRampRate(0.5);
  }

  public void runIndCor() // run corral and indexer system
  {
    beltMoto.set(Constants.BELTSPEED);
    ballAmount = 0;
  }


  public void stopCor() // run just indexer
  {
    beltMoto.set(0);  
  }

  public void runCor() // rrun just corral
  {
    beltMoto.set(-Constants.BELTSPEED);
  }

  public void revCor() // rrun just corral
  {
    beltMoto.set(Constants.BELTSPEED);
  }

  public void runCor(double s) // rrun just corral
  {
    beltMoto.set(-s);
  }

  public void revCor(double s) // rrun just corral
  {
    beltMoto.set(s);
  }

  public void stopIndCor() // run just indexer
  {
    beltMoto.set(0);  
  }



  public static boolean isLimited = false;
  @Override
  public void periodic() {
    try
    {
    // This method will be called once per scheduler run
   // ballAmount = (int) SmartDashboard.getNumber("Ball Amount", 5);
    if(!RevCor.isReverse && !PulseCorral.limitSwitch.get())
    {
      isLimited = true;
    }
    SmartDashboard.putBoolean("isLimited", isLimited);
    }catch(Exception e){}//Just in case the limit switch is null
  }
}
