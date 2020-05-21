/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Purpose:Better format of the list this kind of modification has been done for
 * list.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@JacksonXmlRootElement(localName = "doctorList")
public class DoctorBeanList {

	@JacksonXmlProperty(localName = "doctor")
	@JacksonXmlElementWrapper(useWrapping = false) // Not set the <doctor>-><doctor> will apear
	private List<DoctorXMLBean> doctorList;

	public List<DoctorXMLBean> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<DoctorXMLBean> doctorList) {
		this.doctorList = doctorList;
	}

}
