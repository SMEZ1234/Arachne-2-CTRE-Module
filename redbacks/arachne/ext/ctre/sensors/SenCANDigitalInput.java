package redbacks.arachne.ext.ctre.sensors;

import redbacks.arachne.ext.ctre.controllers.CANTalon;
import redbacks.arachne.lib.motors.CtrlMotor;
import redbacks.arachne.lib.sensors.BinarySensor;

/**
 * A generic digital sensor attached to a Talon SRX CAN controller.
 *
 * @author Sean Zammit
 */
public class SenCANDigitalInput extends BinarySensor
{
	private final CANTalon talon;
	private final boolean isForwardSwitch;

	/**
	 * Constructor for a generic digital sensor attached to a Talon SRX CAN controller.
	 * 
	 * @param talon The controller the sensor is attached to.
	 * @param isForwardSwitch Whether the sensor is attached to the forward switch ports on the controller.
	 */
	public SenCANDigitalInput(CANTalon talon, boolean isForwardSwitch) {
		this.talon = talon;
		this.isForwardSwitch = isForwardSwitch;
	}

	/**
	 * Constructor for a generic digital sensor attached to a Talon SRX CAN controller.
	 * 
	 * @param talon The {@link CtrlMotor} instance holding the controller the sensor is attached to.
	 * @param isForwardSwitch Whether the sensor is attached to the forward switch ports on the controller.
	 */
	public SenCANDigitalInput(CtrlMotor talon, boolean isForwardSwitch) {
		this.talon = (CANTalon) talon.controller;
		this.isForwardSwitch = isForwardSwitch;
	}

	public boolean getSenVal() {
		return isForwardSwitch ? talon.isFwdLimitSwitchClosed() : talon.isRevLimitSwitchClosed();
	}
}
