package com.demo;

import cn.hutool.core.util.HashUtil;
import com.demo.model.ModeA;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author dot
 * @date 2025/11/3 21:21
 */
@Component
public class Initail implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("初始化");
        ModeA modeA = new ModeA();
        modeA.setName("dot");
        modeA.setAge("18");
        modeA.setSex("男");
        modeA.setAddress("中国");
        modeA.setPhone("12345678901");
        System.out.println(HashUtil.hfHash(modeA.toString()));
    }
}
