/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * Purpose: Repository having CRUD operation only.
 *
 * Description:
 *
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
@Repository
public interface IDoctorRepository extends CrudRepository<Doctor, Long> {
	
	
}
