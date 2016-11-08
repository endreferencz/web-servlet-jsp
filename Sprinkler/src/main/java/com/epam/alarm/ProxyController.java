package com.epam.alarm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.io.Resources;

@Controller
public class ProxyController {

    @RequestMapping(value = "/alarm-backend", produces="application/javascript")
    @ResponseBody
    public String proxy() throws MalformedURLException, IOException {
        return Resources.toString(new URL("http://192.168.0.5/"), StandardCharsets.UTF_8);
    }
    
    @RequestMapping(value = "/alarm-backend/stop", produces="application/javascript")
    @ResponseBody
    public String proxyStop() throws MalformedURLException, IOException {
        return Resources.toString(new URL("http://192.168.0.5/stop"), StandardCharsets.UTF_8);
    }
    
    @RequestMapping(value = "/alarm-backend/arm", produces="application/javascript")
    @ResponseBody
    public String proxyArm() throws MalformedURLException, IOException {
        return Resources.toString(new URL("http://192.168.0.5/arm"), StandardCharsets.UTF_8);
    }
}
