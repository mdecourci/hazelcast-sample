package com.sample.hazelcast;

import com.hazelcast.map.MapLoader;
import com.hazelcast.map.MapLoaderLifecycleSupport;
import com.hazelcast.spring.context.SpringAware;
import com.sample.hazelcast.repository.ProductRepository;
import com.sample.hazelcast.repository.domain.Product;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringAware
public class ProductLoader implements MapLoader<Long, Product>, MapLoaderLifecycleSupport {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product load(Long key){
        return productRepository.findById(key).get();
    }

    @Override
    public Map<Long, Product> loadAll(Collection<Long> keys){
        Map<Long, Product> productMap= new HashMap<>();
        for(Long key: keys){
            Product product=this.load(key);
            if(product!=null){
                productMap.put(key, product);
            }
        }
        return productMap;
    }

    @Override
    public Iterable<Long> loadAllKeys(){
        return productRepository.findAllId();
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        productRepository= appContext.getBean(ProductRepository.class);
    }
}
