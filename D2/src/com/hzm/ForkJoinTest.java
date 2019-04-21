package com.hzm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class ForkJoinTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		long time1 = System.currentTimeMillis();

		ForkJoinPool fp = new ForkJoinPool();
		Ass a = new Ass(0L, 501001010L);
		ForkJoinTask<Long> task = fp.submit(a);
		Long long1 = task.get();
		System.out.println(long1);
		long time2 = System.currentTimeMillis();
		System.out.println(Math.abs(time1 - time2));// 2318 2122
		fp.shutdown();
	}

	@Test
	public void test1() {

		int[][] number = { { 5, 3 }, { 1, 1, 2, 3 }, { 4, 4, 3 } };

		long time1 = System.currentTimeMillis();

		long sum = LongStream.rangeClosed(0, 501001010L).sum();
		System.out.println(sum);
		long time2 = System.currentTimeMillis();
		System.out.println(Math.abs(time1 - time2));// 815 811
	}

	@Test
	public void test2() {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));) {
			for (int i = 0; i < 10000; i++) {

				bw.write("你你你ii你`您的方法对付");
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test3() {

		try (BufferedReader bw = new BufferedReader(new FileReader("a.txt"));) {
			String s = null;
			while ((s = bw.readLine()) != null) {
				System.out.println(s);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test4() {
		System.out.println(get(30));
	}

	@Test
	public void test9() {

		List<String> l = Arrays.asList("123", "22", "3333");

		l.stream().filter((t) -> t.length() == 2).forEach((t) -> {
			System.out.println(t);
			System.out.println(t);

		});
	}

	@Test
	public void test8() {
		delete(new File("e://新建文件夹"));
	}

	public void delete(File f) {
		File[] files = f.listFiles();
		for (File ff : files) {

			if (ff.isFile()) {

				ff.delete();
			} else {

				delete(ff);

			}
		}
		f.delete();
	}

	@Test
	public void test7() {

		File f = new File("E:\\图片2");
		File[] listFiles = f.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				boolean b = pathname.isFile() ? true : false;
				// return pathname.getName().endsWith(".jpg") ? true : false;
				return b ? (pathname.getName().endsWith(".jpg") ? true : false) : false;
			}
		});

		for (File ff : listFiles) {
			System.out.println(ff.getName());
		}
	}

	@Test
	public void test6() {

		try (BufferedReader br = new BufferedReader(new FileReader("E:\\test\\哇哈哈spring.txt"));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			String s = null;
			while ((s = br.readLine()) != null) {
				bw.write(s);
				bw.flush();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Test
	public void test5() throws IOException {

		InputStream in = System.in;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while ((i = in.read()) > 0) {
			if (i == '\r') {
				continue;
			} else if (i == '\n') {

				if ("over".equalsIgnoreCase(sb.toString())) {
					break;
				} else {

					System.out.println(sb.toString().toUpperCase());
					sb.delete(0, sb.length());
				}

			} else {
				sb.append((char) i);
			}

		}

	}

	public int get(int i) {

		if (i == 1 || i == 2) {
			return 1;
		} else {

			return get(i - 1) + get(i - 2);
		}
	}

}

class Ass extends RecursiveTask<Long> {

	private long start;
	private long end;
	private long critical = 100l;

	public Ass(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Long compute() {

		if (end - start <= critical) {
			long sum = 0L;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		} else {

			long mid = (start + end) / 2;
			Ass a1 = new Ass(start, mid);
			Ass a2 = new Ass(mid + 1, end);
			a1.fork();
			a2.fork();
			return a1.join() + a2.join();

		}

		// TODO Auto-generated method stub
	}

}
