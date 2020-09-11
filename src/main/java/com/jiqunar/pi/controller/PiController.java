package com.jiqunar.pi.controller;

import com.jiqunar.pi.util.PiUtil;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
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
    final GpioController gpio = PiUtil.getGpioController();
    final GpioPinDigitalOutput pin11 = PiUtil.getGpio11();

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
        pin11.setShutdownOptions(true, PinState.LOW);
        if (state == 0) {
            pin11.low();
        } else {
            pin11.high();
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
