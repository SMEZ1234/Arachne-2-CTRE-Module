package redbacks.arachne.ext.ctre.sensors;

import static com.ctre.phoenix.motorcontrol.LimitSwitchNormal.NormallyOpen;
import static com.ctre.phoenix.motorcontrol.LimitSwitchSource.FeedbackConnector;

import redbacks.arachne.ext.ctre.controllers.CtrlCANTalon;
import redbacks.arachne.lib.motors.CtrlMotor;
import redbacks.arachne.lib.sensors.BinarySensor;

/**
 * A generic digital sensor attached to a Talon SRX CAN controller.
 *
 * @author Sean Zammit
 */
public class SenCANDigitalInput extends BinarySensor
{
	private final CtrlCANTalon talon;
	private final boolean isForwardSwitch;

	/**
	 * Constructor for a generic digital sensor attached to a Talon SRX CAN controller.
	 * 
	 * @param talon The controller the sensor is attached to.
	 * @param isForwardSwitch Whether the sensor is attached to the forward switch ports on the controller.
	 */
	public SenCANDigitalInput(CtrlCANTalon talon, boolean isForwardSwitch) {
		this.talon = talon;
		this.isForwardSwitch = isForwardSwitch;
		if(isForwardSwitch) this.talon.configForwardLimitSwitchSource(FeedbackConnector, NormallyOpen, 0);
		else this.talon.configReverseLimitSwitchSource(FeedbackConnector, NormallyOpen, 0);
	}

	/**
	 * Constructor for a generic digital sensor attached to a Talon SRX CAN controller.
	 * 
	 * @param talon The {@link CtrlMotor} instance holding the controller the sensor is attached to.
	 * @param isForwardSwitch Whether the sensor is attached to the forward switch ports on the controller.
	 */
	public SenCANDigitalInput(CtrlMotor talon, boolean isForwardSwitch) {
		this.talon = (CtrlCANTalon) talon.controller;
		this.isForwardSwitch = isForwardSwitch;
	}

	public boolean getSenVal() {
		return isForwardSwitch ? talon.getSensorCollection().isFwdLimitSwitchClosed() : talon.getSensorCollection().isRevLimitSwitchClosed();
	}
}
