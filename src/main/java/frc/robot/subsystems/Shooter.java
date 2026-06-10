package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final TalonFX motor = new TalonFX(ShooterConstants.MOTOR_ID);
    private final CANcoder CANcoder = new CANcoder(ShooterConstants.CANCODER_ID);

    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0).withSlot(0);

    public Shooter() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        final CANcoderConfiguration CANconfig = new CANcoderConfiguration();

        config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        config.Feedback.withFusedCANcoder(CANcoder);

        CANconfig.MagnetSensor.SensorDirection = SensorDirectionValue.Clockwise_Positive; //TODO

        config.Slot0.kP = ShooterConstants.KP;
        // config.Slot0.kS = ShooterConstants.KS;
        // config.Slot0.kV = ShooterConstants.KV;
        this.CANcoder.getConfigurator().apply(CANconfig);
        this.motor.getConfigurator().apply(config);
        setDefaultCommand(stopCmd());
    }

    public void stop() {
        this.motor.stopMotor();
    }

    public void voltageSpin(Double volts) {
        this.motor.setVoltage(volts);
    }

    public void velocityVoltageSpin(AngularVelocity velocity) {
        this.velocityVoltage.withVelocity(velocity);

        this.motor.setControl(this.velocityVoltage);
    }

    public Command stopCmd() {
        return this.run(() -> stop());
    }

    public Command velocityVoltageCmd(AngularVelocity velocity) {
        return this.run(() -> velocityVoltageSpin(velocity));
    }

    public Command voltageSpinCmd(Double volts) {
        return this.run(() -> voltageSpin(volts));
    }
}
