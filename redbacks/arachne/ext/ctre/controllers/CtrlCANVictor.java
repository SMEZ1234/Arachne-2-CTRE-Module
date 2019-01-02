package redbacks.arachne.ext.ctre.controllers;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * A VictorSPX motor controller that can be used by Arachne classes.
 * Currently identical to {@link WPI_VictorSPX}. This class exists to:
 * a) Make it clear to Arachne users that this controller should be used instead of VictorSPX, as the SpeedController interface is required
 * b) Allow us to make further modifications to standard Victor SPX behaviour should the CTRE libraries change again.
 * 
 * @author Sean Zammit
 */
public class CtrlCANVictor extends WPI_VictorSPX
{
	public CtrlCANVictor(int deviceNumber) {
		super(deviceNumber);
	}
}
