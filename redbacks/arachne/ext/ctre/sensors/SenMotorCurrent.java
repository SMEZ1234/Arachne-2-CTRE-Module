package redbacks.arachne.ext.ctre.sensors;

import redbacks.arachne.ext.ctre.controllers.CtrlCANTalon;
import redbacks.arachne.lib.motors.CtrlMotor;
import redbacks.arachne.lib.sensors.NumericSensor;

/**
 * A measure of the current passing through a Talon SRX CAN controller, for use as a sensor.
 *
 * @author Sean Zammit
 */
public class SenMotorCurrent extends NumericSensor
{
	CtrlCANTalon talon;
	
	/**
	 * Constructor for a sensor measuring the current passing through a Talon SRX CAN controller.
	 *
	 * @param talon The controller being measured.
	 */
	public SenMotorCurrent(CtrlCANTalon talon) {
		this.talon = talon;
	}
	
	/**
	 * Constructor for a sensor measuring the current passing through a Talon SRX CAN controller.
	 *
	 * @param talon The {@link CtrlMotor} instance holding the controller being measured.
	 */
	public SenMotorCurrent(CtrlMotor talon) {
		this.talon = (CtrlCANTalon) talon.controller;
	}
	
	public double getSenVal() {
		return talon.getOutputCurrent();
	}
}
