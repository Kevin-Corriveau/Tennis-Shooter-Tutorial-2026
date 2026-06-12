package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Shooter {
    private final TalonFX motor = new TalonFX(ShooterConstants.MOTOR_ID);

    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0);

    public Shooter() {    
        this.motor.getConfigurator().apply(Mot);
    }

    public void stop() {
        this.motor.stopMotor();
    }

    public void spinVoltage() {
        this.motor.setVoltage(ShooterConstants.SPIN_VOLTAGE);
    }    

    public void spinVelocity() {
        this.velocityVoltage.Velocity = ShooterConstants.SPIN_VELOCITY_RPS;
        
        this.motor.setControl(this.velocityVoltage);
    }
}
