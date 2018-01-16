package redbacks.arachne.ext.ctre.controllers;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * DOC Talon class
 * 
 * @author Sean Zammit
 */
public class CtrlCANTalon extends WPI_TalonSRX implements SpeedController
{
	public CtrlCANTalon(int deviceNumber) {
		super(deviceNumber);
	}
}
