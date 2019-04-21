package com.hzm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hzm.dao.RedImpl2;
import com.hzm.domain.Customer;
import com.hzm.domain.Red;
import com.hzm.service.RedPageService;

/**
 * 
 * 
 * 乐观锁
 */
@Service
public class RedPageImpl2 implements RedPageService {
	@Autowired
	private  RedImpl2 ri;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public int getNumber(Red r,String id) {
		for (int y = 0; y < 5; y++) {

			Red red = ri.getNumber(r);

			if (red.getNumber() > 0) {

				int i = ri.updateRedpackge(red);
				if (i == 0) {

					continue;
				} else {
					Customer c = new Customer();
					c.setId(id);
					c.setTime(new Date());
					ri.update(c);

					return 1;
				}

			} else {
				break;
			}

		}
		return 0;

	}

}
