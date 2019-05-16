package com.lanswon.confg;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * swagger配置
 * @author GU-YW
 *
 */
//@Component
//@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

	@Autowired
	ZuulProperties zuulProperties;
	
	@Override
	public List<SwaggerResource> get() {
		Set<String> routeKeys = zuulProperties.getRoutes().keySet();
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		for (String service : routeKeys) {
			resources.add(swaggerResource(service,"/"+service+"/v2/api-docs","1.0"));
			resources.add(swaggerResource(service,"/"+service+"/v2/api-docs","1.0"));
		}
		return resources;
	}
	
	 private SwaggerResource swaggerResource(String name, String location, String version) {
          SwaggerResource swaggerResource = new SwaggerResource();
          swaggerResource.setName(name);
          swaggerResource.setLocation(location);
          swaggerResource.setSwaggerVersion(version);
          return swaggerResource;
      }

}
