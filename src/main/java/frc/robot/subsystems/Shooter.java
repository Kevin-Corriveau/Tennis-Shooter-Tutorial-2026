package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final TalonFX motor = new TalonFX(ShooterConstants.MOTOR_ID);
    private final CANcoder CANcoder = new CANcoder(ShooterConstants.CANCODER_ID);

    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0).withSlot(0);

    public Shooter() {
        this.CANcoder.getConfigurator().apply(ShooterConstants.CAN_CONFIG);
        this.motor.getConfigurator().apply(ShooterConstants.MOTOR_CONFIG);
        
        this.setDefaultCommand(this.run(this::stop));
    }

    public void stop() {
        this.motor.stopMotor();
    }

    public void spinVoltage() {
        this.motor.setVoltage(
            ShooterConstants.SPIN_VOLTAGE);
    }

    public void spinVelocity() {
        this.motor.setControl(this.velocityVoltage
            .withVelocity(ShooterConstants.SPIN_VELOCITY));
    }

    public Command stopCmd() {
        return this.runOnce(this::stop);
    }

    public Command velocityVoltageCmd() {
        return this.run(this::spinVelocity);
    }

    public Command voltageSpinCmd() {
        return this.run(this::spinVoltage);
    }
}
