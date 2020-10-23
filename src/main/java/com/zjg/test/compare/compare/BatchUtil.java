package com.zjg.test.compare.compare;


public class BatchUtil {
	
	private BatchUtil() {}
	
	public static int  stepIndex(int i, int sourListSize, int subCount, int stopIndex , int batchCount) {
		
		if((i ==(subCount-1))) {
			if(0 == (sourListSize%batchCount))
				stopIndex = stopIndex + batchCount;
			else
				stopIndex=stopIndex + sourListSize%batchCount;
		}else {
			stopIndex = stopIndex + batchCount;
		}
		return  stopIndex;
	}
}
