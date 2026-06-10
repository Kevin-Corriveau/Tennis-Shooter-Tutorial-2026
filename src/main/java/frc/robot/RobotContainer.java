// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterConstants;

public class RobotContainer {

public static final Shooter shooter = new Shooter();

  public RobotContainer() {

    configureBindings();

    ButtonConstants.velocityVoltageShoot.whileTrue(shooter.velocityVoltageCmd(ShooterConstants.SPIN_VELOCITY_RPS));
    
    ButtonConstants.voltageShoot.whileTrue(shooter.voltageSpinCmd(ShooterConstants.SPIN_VOLTAGE));
  }


  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
