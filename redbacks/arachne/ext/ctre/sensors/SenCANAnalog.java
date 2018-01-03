package redbacks.arachne.ext.ctre.sensors;

import redbacks.arachne.ext.ctre.controllers.CANTalon;
import redbacks.arachne.lib.motors.CtrlMotor;
import redbacks.arachne.lib.sensors.NumericSensor;

/**
 * A generic analog sensor attached to a Talon SRX CAN controller.
 *
 * @author Sean Zammit
 */
public abstract class SenCANAnalog extends NumericSensor
{
	final CANTalon talon;
	
	private SenCANAnalog(CANTalon talon) {
		this.talon = talon;
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
		public Rate(CANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic analog sensor measuring rate of change, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the sensor is attached to.
		 */
		public Rate(CtrlMotor talon) {
			super((CANTalon) talon.controller);
		}
		
		protected double getSenVal() {
			return talon.getAnalogInVelocity();
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
		public Displacement(CANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic analog sensor measuring displacement from an initial position, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the sensor is attached to.
		 */
		public Displacement(CtrlMotor talon) {
			super((CANTalon) talon.controller);
		}
		
		protected double getSenVal() {
			return talon.getAnalogInPosition();
		}
		
		public double pidGet() {
			return get();
		}
	}
}
