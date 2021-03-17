package com.example.hello.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ExportedService;

import java.util.concurrent.CompletableFuture;

import com.example.hello.api.HelloAsyncService;

@Component(property = "osgi.basic.timeout=10000") // Timeout of 10s=10000ms
//The following will export using the ecf.generic.server distribution provider
@ExportedService(service_exported_interfaces = HelloAsyncService.class, 
service_exported_configs = "ecf.generic.server", 
service_exported_intents = { "osgi.basic", "osgi.async" })
//Note that that the provider identified by the service exported config value must be
//present in the runtime (bndrun) at the time of service registration for it to be
//exported
public class HelloAsyncServiceImpl implements HelloAsyncService {

	public CompletableFuture<String> hello(String from) {
	    CompletableFuture<String> cf = new CompletableFuture<String>();
	    cf.complete("Hello "+from);
	    return cf;
	}

}
