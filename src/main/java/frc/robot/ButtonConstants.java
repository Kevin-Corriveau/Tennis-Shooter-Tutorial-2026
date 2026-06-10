package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class ButtonConstants {
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final Joystick joystick = new Joystick(1);

    public static final Trigger voltageShoot = new JoystickButton(joystick, A);
    public static final Trigger velocityVoltageShoot = new JoystickButton(joystick, B);
}
