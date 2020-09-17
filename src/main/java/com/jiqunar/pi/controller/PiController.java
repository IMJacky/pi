package com.jiqunar.pi.controller;

import com.pi4j.io.gpio.*;
import lombok.SneakyThrows;
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
    final GpioPinDigitalOutput pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);

    final GpioPinDigitalOutput pin35 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.LOW);
    final GpioPinDigitalOutput pin36 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.LOW);
    final GpioPinDigitalOutput pin37 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, PinState.LOW);
    final GpioPinDigitalOutput pin38 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.LOW);

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

    /**
     * uln2003点击转动
     *
     * @return
     */
    @SneakyThrows
    @GetMapping("uln")
    public void led() {
        for (int i = 0; i < 2048; i++) {
            setPinHighLow(PinState.LOW, PinState.LOW, PinState.LOW, PinState.HIGH);
            Thread.sleep(2);
            setPinHighLow(PinState.LOW, PinState.LOW, PinState.HIGH, PinState.LOW);
            Thread.sleep(2);
            setPinHighLow(PinState.LOW, PinState.HIGH, PinState.LOW, PinState.LOW);
            Thread.sleep(2);
            setPinHighLow(PinState.HIGH, PinState.LOW, PinState.LOW, PinState.LOW);
            Thread.sleep(2);
        }
        setPinHighLow(PinState.LOW, PinState.LOW, PinState.LOW, PinState.LOW);
    }

    private void setPinHighLow(PinState pinState35, PinState pinState36, PinState pinState37, PinState pinState38) {
        pin35.setState(pinState35);
        pin36.setState(pinState36);
        pin37.setState(pinState37);
        pin38.setState(pinState38);
    }
}
