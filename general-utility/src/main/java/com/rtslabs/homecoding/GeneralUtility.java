package com.rtslabs.homecoding;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GeneralUtility{
	

	public  <T extends Comparable<T>> Map<Position, Long> aboveBelow(List<T> values, T comparison) {
		validateaboveBelowRequest(values,comparison);
		Function<T, Position> f= t -> comparison.compareTo(t) < 0 ? Position.Above : Position.Below ;
		Map<Position, Long> result;
		result= values.stream()
		.filter(t -> ! t.equals(comparison))
		.collect(Collectors.groupingBy(f ,Collectors.counting()));
		
		return result;
	}
	
	
	private <T> void validateaboveBelowRequest(List<T> values, T comparison){
		validateList(values);
		validateComparison(comparison);
	}
	
	private <T> void validateList(List<T> values) {
		if( values== null )
			throw new IllegalArgumentException("The List aregument should not be null");
	}

	private <T> void validateComparison(T comparison) {
		if( comparison== null )
			throw new IllegalArgumentException("comparison argument should not be null");
	}
	
	
	public String stringRotation(String input, int shift) {
		stringRotationValidator(input,shift);
		if(shift>= input.length())
			shift %= input.length() ; 
		if("".equals(input) || shift== 0) {
			return input;
		}
		  
		return  input.substring(input.length() -shift) + input.substring(0,input.length()-shift); 
		
	}

	private void stringRotationValidator(String input, int shift) {
		String message= null;
		if(input== null) {
			message="The List aregument should not be null";
		}else if(shift < 0) {
			message= "shift can not be negetive";
		}
			
		if(message!= null) {
			throw new IllegalArgumentException(message);
		}
		
	}
}
