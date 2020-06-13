package com.sample.platform.services.epbi.hr.conf;

import com.ebpi.sample.services.platform.resource.HrIml;
import com.google.common.collect.Sets;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.DynamicFeature;

@Component
public class JerseyApplicationContext extends ResourceConfig {

    public JerseyApplicationContext(){
        super(Sets.newHashSet(DynamicFeature.class));
        register(HrIml.class);
    }
}
