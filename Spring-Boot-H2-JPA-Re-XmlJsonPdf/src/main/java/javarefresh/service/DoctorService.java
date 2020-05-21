/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javarefresh.dao.Doctor;
import javarefresh.dao.IDoctorRepository;
import javarefresh.model.DoctorJSONBean;
import javarefresh.model.DoctorXMLBean;

/**
 * Purpose:Get the all the doctors as well as based on id etc.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@Service
public class DoctorService implements IDoctorService {

	@Autowired
	private IDoctorRepository repository;

	@Override
	public List<DoctorXMLBean> findAllDoctorsInXML() {

		List<DoctorXMLBean> list = new ArrayList<>();

		List<Doctor> doctorList = (List<Doctor>) repository.findAll();
		doctorList.stream().forEach(x -> {
			DoctorXMLBean bean = new DoctorXMLBean();
			bean.setId(x.getId());
			bean.setName(x.getName());
			bean.setRegisterId(x.getRegisterId());
			list.add(bean);
		});

		return list;
	}

	@Override
	public DoctorXMLBean findDoctorByIdInXML(Long id) {
		Doctor doctor = repository.findById(id).orElse(new Doctor());
		DoctorXMLBean bean = new DoctorXMLBean();
		bean.setId(doctor.getId());
		bean.setName(doctor.getName());
		bean.setRegisterId(doctor.getRegisterId());
		return bean;
	}

	public DoctorXMLBean findDoctorByRegisterId(int registerId) {
		return null;
	}

	@Override
	public List<DoctorJSONBean> findAllDoctorsInJSON() {

		List<DoctorJSONBean> list = new ArrayList<>();
		List<Doctor> doctorList = (List<Doctor>) repository.findAll();

		doctorList.stream().forEach(x -> {
			DoctorJSONBean bean = new DoctorJSONBean();
			bean.setId(x.getId());
			bean.setName(x.getName());
			bean.setRegisterId(x.getRegisterId());
			list.add(bean);
		});
		return list;
	}

	@Override
	public DoctorJSONBean findDoctorByIdInJSON(Long id) {
		Doctor doctor = repository.findById(id).orElse(new Doctor());
		DoctorJSONBean bean = new DoctorJSONBean();
		bean.setId(doctor.getId());
		bean.setName(doctor.getName());
		bean.setRegisterId(doctor.getRegisterId());
		return bean;
	}
}
