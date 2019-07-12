package com.yangchunbo.common.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testCloseAll() {
		
	}

	@Test
	public void testReadTextFileInputStream() throws IOException {
		
		FileInputStream inputStream = new FileInputStream(new File("E:/1.txt"));
		
		String string = StreamUtil.readTextFile(inputStream);
		System.out.println(string);
		
	}

	@Test
	public void testReadTextFileFile() throws FileNotFoundException, IOException {
		
		String string = StreamUtil.readTextFile(new File("e:/1.txt"));
		System.out.println(string);
	}

}
