package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class ButtonConstants {
    public static final Joystick controller = new Joystick(0);
    
    public static final JoystickButton SPIN_VOLTAGE_BUTTON = new JoystickButton(controller, 1);
    public static final JoystickButton SPIN_VELOCITY_BUTTON = new JoystickButton(controller, 2);
}
