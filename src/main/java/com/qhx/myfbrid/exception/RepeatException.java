/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.exception;

public class RepeatException extends CommonException{

	/**
	 * @param state
	 * @param message
	 */
	public RepeatException(int state, String message) {
		super(message);
	}
	
	public RepeatException(String message){
		super(message);
	}
}
