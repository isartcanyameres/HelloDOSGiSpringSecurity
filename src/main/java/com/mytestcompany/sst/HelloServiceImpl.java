package com.mytestcompany.sst;

import java.util.ArrayList;
import java.util.List;

import com.mytestcompany.sst.model.Resource;
import com.mytestcompany.sst.model.XResource;
import com.mytestcompany.sst.model.YResource;

public class HelloServiceImpl implements HelloService {

	private List<Resource>	resources;

	public HelloServiceImpl() {
		resources = new ArrayList<Resource>(0);
	}

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public String sayBye(String name) {
		return "Bye " + name;
	}

	@Override
	public ListWrapper<Long> generateResources() {
		resources = doGenerateResources();
		return listResources();
	}

	@Override
	public Resource getResource(Long id) {
		for (Resource r : resources) {
			if (r.getId() == id.longValue())
				return r;
		}
		return null;
	}

	@Override
	public ListWrapper<Long> listResources() {
		List<Long> ids = new ArrayList<Long>(resources.size());
		for (Resource r : resources) {
			ids.add(r.getId());
		}
		return new ListWrapper<Long>(ids);
	}

	private List<Resource> doGenerateResources() {
		List<Resource> resources = new ArrayList<Resource>(4);
		for (int i = 0; i < 4; i++) {
			Resource r;
			if (i % 2 == 0) {
				r = new XResource();
				((XResource) r).setId(i);
			} else {
				r = new YResource();
				((YResource) r).setId(i);
			}
			resources.add(r);
		}
		return resources;
	}

}
