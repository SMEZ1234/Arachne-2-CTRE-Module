package redbacks.arachne.ext.ctre.controllers;

import com.ctre.phoenix.MotorControl.CAN.TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import redbacks.arachne.lib.motors.CtrlMotor;

/**
 * As of the CTRE update for 2018, the CANTalon class was renamed to TalonSRX, and no longer implements the SpeedController interface, despite overriding all its methods.
 * This class extends the TalonSRX class while implementing SpeedController, so that it can be used in {@link CtrlMotor}.
 *
 * @author Sean Zammit
 */
public class CANTalon extends TalonSRX implements SpeedController
{
	public CANTalon(int deviceNumber) {
		super(deviceNumber);
	}
}
