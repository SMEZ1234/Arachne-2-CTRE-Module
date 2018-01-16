package redbacks.arachne.ext.ctre.sensors;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import redbacks.arachne.ext.ctre.controllers.CtrlCANTalon;
import redbacks.arachne.lib.motors.CtrlMotor;
import redbacks.arachne.lib.sensors.NumericSensor;

/**
 * A generic encoder attached to a Talon SRX CAN controller.
 *
 * @author Sean Zammit
 */
public abstract class SenCANEncoder extends NumericSensor
{
	final CtrlCANTalon talon;

	private SenCANEncoder(CtrlCANTalon talon) {
		this.talon = talon;
		this.talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
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
		public Rate(CtrlCANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic encoder measuring rate of change, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the encoder is attached to.
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
		public Displacement(CtrlCANTalon talon) {
			super(talon);
		}
		
		/**
		 * Constructor for a generic encoder measuring displacement from an initial position, attached to a Talon SRX CAN controller.
		 * 
		 * @param talon The {@link CtrlMotor} instance holding the controller the encoder is attached to.
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
