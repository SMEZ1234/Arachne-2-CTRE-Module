package redbacks.arachne.ext.ctre.sensors;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import redbacks.arachne.ext.ctre.controllers.CtrlCANTalon;
import redbacks.arachne.lib.motors.CtrlMotor;
import redbacks.arachne.lib.sensors.NumericSensor;

/**
 * A generic analog sensor attached to a Talon SRX CAN controller.
 *
 * @author Sean Zammit
 */
public abstract class SenCANAnalog extends NumericSensor
{
	final CtrlCANTalon talon;
	
	private SenCANAnalog(CtrlCANTalon talon) {
		this.talon = talon;
		this.talon.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
	}

	/**
	 * A generic analog sensor measuring rate of change, attached to a Talon SRX CAN controller.
	 *
	 * @author Sean Zammit
	 */
	public static class Rate extends SenCANAnalog
	{
		/**
		 * Constructor for a generic analog sensor measuring rate of change, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The controller the sensor is attached to.
		 */
		public Rate(CtrlCANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic analog sensor measuring rate of change, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the sensor is attached to.
		 */
		public Rate(CtrlMotor talon) {
			super((CtrlCANTalon) talon.controller);
		}
		
		protected double getSenVal() {
			return talon.getSelectedSensorVelocity(0);
		}
		
		public double pidGet() {
			return get();
		}
	}

	/**
	 * A generic analog sensor measuring displacement from an initial position, attached to a Talon SRX CAN controller.
	 *
	 * @author Sean Zammit
	 */
	public static class Displacement extends SenCANAnalog
	{
		/**
		 * Constructor for a generic analog sensor measuring displacement from an initial position, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The controller the sensor is attached to.
		 */
		public Displacement(CtrlCANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic analog sensor measuring displacement from an initial position, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the sensor is attached to.
		 */
		public Displacement(CtrlMotor talon) {
			super((CtrlCANTalon) talon.controller);
		}
		
		protected double getSenVal() {
			return talon.getSelectedSensorPosition(0);
		}
		
		public double pidGet() {
			return get();
		}
	}
}
