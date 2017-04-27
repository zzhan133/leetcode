package com.mv.leetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SumRootToLeafNumbersTest {

	@Test
	public void testSumNumbersWithParent() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strLine = null;
		while ((strLine = br.readLine()) != null) {
			String[] strs = strLine.split(" ");
			System.out.println(new ArrayList<>(Arrays.asList(strs)));
		}
		br.close();
	}

}
