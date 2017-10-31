/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.exception;

public class NotUniqueException extends CommonException{

	/**
	 * @param state
	 * @param message
	 */
	public NotUniqueException(int state, String message) {
		super(message);
	}
	
	public NotUniqueException(String message){
		super(message);
	}
}
