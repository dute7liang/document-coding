package com.duteliang.webbase.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author: zl
 * @Date: 2019-12-27 15:09
 */
//@SpringBootConfiguration
public class CuratorConfig {

    @Bean
    public RetryPolicy retryPolicy(){
        return new ExponentialBackoffRetry(1000,3);
    }

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework(RetryPolicy retryPolicy){
        return CuratorFrameworkFactory.newClient(
                "192.168.72.253:2181,192.168.72.253:2182,192.168.72.253:2183",
                10000, 5000, retryPolicy);
    }


    public static void main(String[] args) throws Exception {
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework framework = CuratorFrameworkFactory.newClient(
                "192.168.72.253:2181,192.168.72.253:2182,192.168.72.253:2183",
                10000, 5000, retry);
        framework.start();

        CuratorFramework namespace = framework.usingNamespace("zltest");

        InterProcessMutex interProcessMutex = new InterProcessMutex(framework,"/lockTest");

        try {
            interProcessMutex.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            interProcessMutex.release();
        }

        System.out.println("name");

    }

}
