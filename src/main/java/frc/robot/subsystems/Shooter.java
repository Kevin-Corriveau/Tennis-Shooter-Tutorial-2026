package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final TalonFX motor = new TalonFX(ShooterConstants.MOTOR_ID);

    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0);

    public Shooter() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
    
        config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    
        this.motor.getConfigurator().apply(config);
    }

    public void stop() {
        this.motor.stopMotor();
    }

    public void spinVoltage() {
        this.motor.setVoltage(ShooterConstants.SPIN_VOLTAGE);
    }    

    public void spinVelocity() {
        this.velocityVoltage.withVelocity(ShooterConstants.SPIN_VELOCITY_RPS);
        
        this.motor.setControl(this.velocityVoltage);
    }
}
