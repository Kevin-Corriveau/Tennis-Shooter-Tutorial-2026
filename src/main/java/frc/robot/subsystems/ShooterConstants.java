package frc.robot.subsystems;

import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.units.measure.AngularVelocity;

public abstract class ShooterConstants {
    public static final int MOTOR_ID = 0;
    public static final int CANCODER_ID = 0;

    public static final double SPIN_VOLTAGE = 3;
    public static final AngularVelocity SPIN_VELOCITY_RPS = RotationsPerSecond.of(10);
    public static final double KP =1;
    public static final double KS =0;
    public static final double KV =0;
}
