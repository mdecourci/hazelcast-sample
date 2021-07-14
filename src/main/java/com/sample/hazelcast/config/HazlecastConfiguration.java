package com.sample.hazelcast.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.sample.hazelcast.ProductLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazlecastConfiguration {
    @Bean
    HazelcastInstance hazlecastInstance(){
        Config config= new Config();
        config.addMapConfig(mapProductConfig());
        config.setManagedContext(managedContext());
        return Hazelcast.newHazelcastInstance(config);
    }
    MapConfig mapProductConfig(){
        ProductLoader loader= new ProductLoader();
        MapStoreConfig msc= new MapStoreConfig();
        msc.setEnabled(true).setClassName("com.sample.hazelcast.repository.domain.ProductLoader")
                .setInitialLoadMode(MapStoreConfig.InitialLoadMode.EAGER);
        msc.setImplementation(loader);
        MapConfig mapConfig= new MapConfig("Product");
        mapConfig.setName("Product").setInMemoryFormat(InMemoryFormat.BINARY)
                .setTimeToLiveSeconds(-1)
                .setMapStoreConfig(msc);
        return mapConfig;
    }

    @Bean
    SpringManageContext managedContext(){
        return SpringManagedContext();
    }

}
