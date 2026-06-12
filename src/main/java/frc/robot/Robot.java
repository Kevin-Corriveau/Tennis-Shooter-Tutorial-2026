// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Shooter;

public class Robot extends TimedRobot {
  private final Shooter shooter = new Shooter();

  @Override
  public void teleopPeriodic() {
      if(ButtonConstants.controller.getRawButton(ButtonConstants.SPIN_VOLTAGE_BUTTON))
        this.shooter.spinVoltage();
      else if(ButtonConstants.controller.getRawButton(ButtonConstants.SPIN_VELOCITY_BUTTON))
        this.shooter.spinVelocity();
      else
        this.shooter.stop();
  }
}
