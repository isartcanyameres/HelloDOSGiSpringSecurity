package com.mytestcompany.sst.model;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ XResource.class, YResource.class })
public abstract class Resource implements Identified {

}
