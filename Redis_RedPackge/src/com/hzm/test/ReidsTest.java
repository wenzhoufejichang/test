package com.hzm.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzm.service.JedisClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicaltion_*.xml")
public class ReidsTest {
	@Resource(name = "jedisClientPool")
	private JedisClient jc;

	@Test
	public void t1() {

		// System.out.println(jc == null);
		jc.set("red", "1000");

	}

	@Test
	public void t2() {

		// System.out.println(jc == null);
		String string = jc.get("red");
		System.out.println(string);

	}

	@Test
	public void t3() {
		String[] arr = new String[1000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = String.valueOf(i);

		}

		jc.lpush("test", arr);

	}

	@Test
	public void t4() {

		String s = null;
		while ((s = jc.lpop("test")) != null) {
			System.out.println(s);
		}

	}

}