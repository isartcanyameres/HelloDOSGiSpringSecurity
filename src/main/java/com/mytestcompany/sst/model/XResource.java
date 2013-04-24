package com.mytestcompany.sst.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XResource extends Resource {

	long	id;

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
