package frc.robot.subsystems;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Voltage;

public abstract class ShooterConstants {
    public static final int MOTOR_ID = 11;
    public static final int CANCODER_ID = 10;

    public static final double KP = 3;
    ;
    public static final double KS = 0;
    public static final double KV = 0;

    public static final TalonFXConfiguration MOTOR_CONFIG = new TalonFXConfiguration()
        .withMotorOutput(
            new MotorOutputConfigs()
                .withInverted(InvertedValue.Clockwise_Positive)
                .withNeutralMode(NeutralModeValue.Coast))
        .withFeedback(
            new FeedbackConfigs()
                .withFeedbackSensorSource(FeedbackSensorSourceValue.FusedCANcoder)
                .withFeedbackRemoteSensorID(CANCODER_ID))
        .withSlot0(
            new Slot0Configs()
                .withKP(KP)   
                .withKS(KS)
                .withKV(KV));

    public static final CANcoderConfiguration CAN_CONFIG = new CANcoderConfiguration()
        .withMagnetSensor(
            new MagnetSensorConfigs()
                .withSensorDirection(SensorDirectionValue.Clockwise_Positive));
                

    public static final double SPIN_VOLTAGE = 6;
    public static final AngularVelocity SPIN_VELOCITY = RotationsPerSecond.of(100);
}

