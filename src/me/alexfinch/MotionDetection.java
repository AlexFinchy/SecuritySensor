package me.alexfinch;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigital;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class MotionDetection {
	
	
	public static final DeviceType DEVICE_TYPE = DeviceType.MotionSensor;
	
	public void StartBackgroundThread (GpioController controller, GpioPinDigitalInput input1 ) {
		
		Thread thread = new Thread(new Runnable() {
			
			
			
			@Override
			public void run() {
				

				while(true) {
				}
				
			}
		});
		
		thread.start();
		
	}
	
	public MotionDetection() {
		
		
		
		GpioController controller = GpioFactory.getInstance();
		
		GpioPinDigitalInput input = controller.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
		
		StartBackgroundThread(controller,input);
		
		
		
		input.addListener(new GpioPinListenerDigital() {
			
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent e) {
				
				if(e.getState().isHigh()) {
					System.out.println("Motion Detected");
				}
				
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new MotionDetection();
		//When sensor is turned on
		
	}

}
