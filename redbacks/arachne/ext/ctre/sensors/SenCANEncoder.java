package redbacks.arachne.ext.ctre.sensors;

import redbacks.arachne.ext.ctre.controllers.CANTalon;
import redbacks.arachne.lib.motors.CtrlMotor;
import redbacks.arachne.lib.sensors.NumericSensor;

/**
 * A generic encoder attached to a Talon SRX CAN controller.
 *
 * @author Sean Zammit
 */
public abstract class SenCANEncoder extends NumericSensor
{
	final CANTalon talon;

	private SenCANEncoder(CANTalon talon) {
		this.talon = talon;
	}

	/**
	 * A generic encoder measuring rate of change, attached to a Talon SRX CAN controller.
	 *
	 * @author Sean Zammit
	 */
	public static class Rate extends SenCANEncoder
	{
		/**
		 * Constructor for a generic encoder measuring rate of change, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The controller the encoder is attached to.
		 */
		public Rate(CANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic encoder measuring rate of change, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the encoder is attached to.
		 */
		public Rate(CtrlMotor talon) {
			super((CANTalon) talon.controller);
		}
		
		protected double getSenVal() {
			return talon.getEncVelocity();
		}
		
		public double pidGet() {
			return get();
		}
	}

	/**
	 * A generic encoder measuring displacement from an initial position, attached to a Talon SRX CAN controller.
	 *
	 * @author Sean Zammit
	 */
	public static class Displacement extends SenCANEncoder
	{
		/**
		 * Constructor for a generic encoder measuring displacement from an initial position, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The controller the encoder is attached to.
		 */
		public Displacement(CANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic encoder measuring displacement from an initial position, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the encoder is attached to.
		 */
		public Displacement(CtrlMotor talon) {
			super((CANTalon) talon.controller);
		}
		
		protected double getSenVal() {
			return talon.getEncPosition();
		}
		
		public double pidGet() {
			return get();
		}
	}
}
