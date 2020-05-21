/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javarefresh.model.BuildPdf;
import javarefresh.model.DoctorJSONBean;
import javarefresh.model.DoctorXMLBean;
import javarefresh.service.IDoctorService;

/**
 * Purpose: Rest controller having 3 types of methods which return the result in
 * JSON, XML and PDF format.
 * 
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
@RestController
public class DoctorController {

	@Autowired
	IDoctorService doctorService;

	// XML format method start
	@GetMapping(value = "/doctorsInXML", produces = MediaType.APPLICATION_XML_VALUE)
	public List<DoctorXMLBean> findAllDoctorsInXML() {
		return doctorService.findAllDoctorsInXML();
	}

	@GetMapping(value = "/doctorInXML/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public DoctorXMLBean getDoctorByIdInXML(@PathVariable Long id) {
		return doctorService.findDoctorByIdInXML(id);
	}

	// JSON format method start
	// By setting MediaType you can reproduce XML, JSON, PDF many more
	@GetMapping(value = "/doctorsInJSON", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DoctorJSONBean> findAllDoctorsInJSON() {
		List<DoctorJSONBean> list = doctorService.findAllDoctorsInJSON();
		return list;
	}

	// @ResponseBody also produce JSON format output.
	@GetMapping(value = "/doctorJason/{id}")
	@ResponseBody
	public DoctorJSONBean getDoctorByIdInJSON(@PathVariable Long id) {
		return doctorService.findDoctorByIdInJSON(id);
	}

	// PDF format method start
	@GetMapping(value = "/doctorPdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public DoctorJSONBean getDoctorByIdInPdf(@PathVariable Long id) {
		return doctorService.findDoctorByIdInJSON(id);
	}

	@RequestMapping(value = "/doctorsInPdf", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> findAllDoctorsReport() {

		List<DoctorJSONBean> list = doctorService.findAllDoctorsInJSON();

		ByteArrayInputStream bis = BuildPdf.citiesReport(list);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=doctorsList.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
