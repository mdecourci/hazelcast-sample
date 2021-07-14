package com.sample.hazelcast.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazlecastClientConfiguration {
    @Bean
    public HazelcastInstance hazelcastInstance(ClientConfig clientConfig){
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
    @Bean
    public ClientConfig clientConfig(){
        ClientConfig clientConfig= new ClientConfig();
        MemberGroupConfig groupConfig = clientConfig.get;
        groupConfig.setName("dev");
        groupConfig.setPassword("dev-pass");
        return clientConfig;
    }
}
