package redbacks.arachne.ext.ctre.controllers;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * A TalonSRX motor controller that can be used by Arachne classes.
 * Currently identical to {@link WPI_TalonSRX}. This class exists to:
 * a) Make it clear to Arachne users that this controller should be used instead of TalonSRX, as the SpeedController interface is required
 * b) Allow us to make further modifications to standard Talon SRX behaviour should the CTRE libraries change again.
 * 
 * @author Sean Zammit
 */
public class CtrlCANTalon extends WPI_TalonSRX implements SpeedController
{
	public CtrlCANTalon(int deviceNumber) {
		super(deviceNumber);
	}
}
