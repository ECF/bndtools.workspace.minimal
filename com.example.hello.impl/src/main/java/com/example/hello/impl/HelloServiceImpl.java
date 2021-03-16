package com.example.hello.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ExportedService;
import com.example.hello.api.HelloService;

@Component(enabled=false,name="HelloServiceImpl")
@ExportedService(service_exported_interfaces = HelloService.class, service_exported_configs = "ecf.generic.server")
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}


}