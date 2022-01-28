package com.rtslabs.homecoding.GeneralUtilityi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rtslabs.homecoding.GeneralUtility;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class StringRotationTest {


	GeneralUtility gu;
	
	@Before
	public void init() {
		gu= new GeneralUtility();
	}
	@Test
	@Parameters({
		"MyString, 0, MyString",
		"MyString, 1, gMyStrin",
		"MyString, 2, ngMyStri",
		"MyString, 4, ringMySt",
		"MyString, 8, MyString",
		"MyString, 9 , gMyStrin",
		"MyString, 10, ngMyStri",
		"MyString, 16, MyString"
			})
	public void  testRotation(String str, int shifts, String expected) {
		String result =  gu.stringRotation(str, shifts);
		Assert.assertEquals(expected+ " but find " +result,expected, result);
	}
	
}
