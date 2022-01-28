package com.rtslabs.homecoding.GeneralUtilityi;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import com.rtslabs.homecoding.GeneralUtility;
import com.rtslabs.homecoding.Position;

@RunWith(value = Parameterized.class)
public class AboveBelowTest {
	GeneralUtility gu;

	@Parameter(value = 0)
	public List<Integer> list;
	
	@Parameter(value = 1)
	public Integer comparison;
	
    @Parameter(value = 2)
    public Long expectedAbove;
    
    @Parameter(value = 3)
    public Long expectedBelow;
    
    @Parameters(name = "{index}: in {0} has {3} element Below {1} and {2} element Above it")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            	{Arrays.asList(1, 5, 2, 1, 10), 6, 1l ,4l},
                {Arrays.asList(9,-10,16,1, 5, 2, 1, 10, 12), 9, 3l, 5l},
                {Arrays.asList(1,2,3,4,5,6,7), 2, 5l, 1l},
                {Arrays.asList(1,2,3,4,5,6,7), 9, null, 7l},
                {Arrays.asList(1,2,3,4,5,6,7), 0, 7l, null},
                {Arrays.asList(), 5, null, null},
        });
    }
    
    @Before
    public void initialTets() {
    	this.gu= new GeneralUtility();
    }
	
	@Test
	public void testAboveBelow( ){
		
		Map<Position, Long> map= gu.aboveBelow(list, comparison);
		assertEquals(map.get(Position.Above), expectedAbove);
		assertEquals(map.get(Position.Below), expectedBelow);
		
	}
	

}
