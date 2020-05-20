/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.service;

import java.util.List;

import javarefresh.model.DoctorJSONBean;
import javarefresh.model.DoctorXMLBean;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public interface IDoctorService {
	/**
	 * Get all doctors in XML format.
	 * 
	 * @return
	 */
	public List<DoctorXMLBean> findAllDoctorsInXML();

	/**
	 * Get the Doctor by id in XML format.
	 * 
	 * @param id
	 * @return
	 */
	public DoctorXMLBean findDoctorByIdInXML(Long id);

	public DoctorXMLBean findDoctorByRegisterId(int registerId);

	/**
	 * Get all doctors in JSON format.
	 * 
	 * @return
	 */
	public List<DoctorJSONBean> findAllDoctorsInJSON();

	/**
	 * Get the Doctor by id in JSON format.
	 * 
	 * @param id
	 * @return
	 */
	public DoctorJSONBean findDoctorByIdInJSON(Long id);

}
