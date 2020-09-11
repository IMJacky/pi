package com.jiqunar.pi.util;

import com.pi4j.io.gpio.*;

/**
 * @author jieguang.wang
 * @date 2020/9/11 23:12
 */
public class PiUtil {
    private static final GpioController gpio = GpioFactory.getInstance();
    private static final GpioPinDigitalOutput pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "MyLed", PinState.HIGH);

    public static GpioController getGpioController() {
        return gpio;
    }

    public static GpioPinDigitalOutput getGpio11() {
        return pin11;
    }
}
