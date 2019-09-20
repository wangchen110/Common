package com.yangchunbo.common.utils;

import org.junit.Test;

import com.wangchen.common.utils.RandomUitl;

public class RandomUitlTest {

	@Test
	public void testRandom() {

		for (int i = 0; i < 10; i++) {
			int x = RandomUitl.random(1, 10);
			System.out.println(x);
		}
	}

	@Test
	public void testSubRandom() {
		int[] is = RandomUitl.subRandom(1, 10, 4);
		for (int i : is) {
			System.out.println(i);
		}
	}

	@Test
	public void testRandomCharacter() {
		for (int i = 0; i < 10; i++) {

			System.out.println(RandomUitl.randomCharacter());
		}
	}

	@Test
	public void testRandomString() {
		for (int i = 0; i < 10; i++) {

			System.out.println(RandomUitl.randomString(4));
		}
	}

}
