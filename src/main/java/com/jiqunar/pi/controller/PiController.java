package com.jiqunar.pi.controller;

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
    /**
     * test
     *
     * @return
     */
    @GetMapping("test")
    public LocalDateTime test() {
        return LocalDateTime.now();
    }
}
