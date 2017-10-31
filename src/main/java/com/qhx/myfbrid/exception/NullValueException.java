/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.exception;

public class NullValueException extends CommonException{
	public NullValueException(String message){
		super(message);
	}
	
	public NullValueException(int state,String message){
		super(message);
	}
}
