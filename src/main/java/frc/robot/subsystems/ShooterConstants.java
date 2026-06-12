package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public abstract class ShooterConstants {
    public static final int MOTOR_ID = 11;
    public static final int CANCODER_ID = 10;

    public static final TalonFXConfiguration MOTOR_CONFIG = new TalonFXConfiguration()
        .withMotorOutput(
            new MotorOutputConfigs()
                .withInverted(InvertedValue.Clockwise_Positive)
                .withNeutralMode(NeutralModeValue.Coast));

    public static final double SPIN_VOLTAGE = 3;
    public static final double SPIN_VELOCITY_RPS = 5;
}
