package com.jiqunar.pi.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 树莓派控制器
 *
 * @author jieguang.wang
 * @date 2020/9/8 20:37
 */
@RestController
@RequestMapping("pi")
public class PiController {
    final GpioController gpio = GpioFactory.getInstance();
    GpioPinDigitalOutput pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLed", PinState.LOW);

    /**
     * test
     *
     * @return
     */
    @GetMapping("test")
    public LocalDateTime test() {
        return LocalDateTime.now();
    }

    /**
     * led
     *
     * @return
     */
    @GetMapping("led")
    public String led(Integer state) {
        String result = "";
        if (state == 0) {
            pin11.setState(PinState.LOW);
        } else {
            pin11.setState(PinState.HIGH);
        }
        if (pin11.isHigh()) {
            result = "已开启";
        }
        if (pin11.isLow()) {
            result = "已关闭";
        }
        return result;
    }
}
