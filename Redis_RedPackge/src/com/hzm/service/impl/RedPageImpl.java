package com.hzm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.hzm.dao.RedImpl;
import com.hzm.domain.Customer;
import com.hzm.domain.Red;
import com.hzm.service.JedisClient;
import com.hzm.service.RedPageService;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class RedPageImpl implements RedPageService {
	@Autowired
	private RedImpl ri;
	@Autowired
	private JedisClient jc;
	@Autowired
	private Gson g;

	
	public int getNumber(Red r) {

		try {
			String value = null;
			if ((value = jc.lpop("test")) != null) {

				Customer c = new Customer();
				c.setTime(new Date());
				String string = g.toJson(c);
				jc.lpush("customer", string);
				// ri.update(c);
				return 1;
			} else {

				return 0;

			}
		} finally {

			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String customer = null;
					while ((customer = jc.lpop("customer")) != null) {
						Customer fromJson = g.fromJson(customer, Customer.class);
						ri.update(fromJson);
					}

				}
			}).start();

		}
	}

	@Override
	public int getNumber(Red r, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
