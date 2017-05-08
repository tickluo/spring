package com.tickluo.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final Logger logger = Logger.getLogger(getClass());

    private final DiscoveryClient client;

    private final EurekaClient discoveryClient;

    @Autowired
    public UserController(DiscoveryClient client, EurekaClient discoveryClient) {
        this.client = client;
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        //client.getInstances()
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("STORES", false);
        int r = a + b;

        logger.info("/add, host:" + instance.getHomePageUrl() + ", service_id:" + instance.getId() + ", result:" + r);
        return r;
    }
}
