package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

public class Shooter {
    private final TalonFX motor = new TalonFX(ShooterConstants.MOTOR_ID);
    private final CANcoder cancoder = new CANcoder(ShooterConstants.CANCODER_ID);

    private final VelocityVoltage velocityVoltage = new VelocityVoltage(0);

    public Shooter() {    
        this.motor.getConfigurator().apply(ShooterConstants.MOTOR_CONFIG);
        this.cancoder.getConfigurator().apply(ShooterConstants.CANCODER_CONFIG);
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
