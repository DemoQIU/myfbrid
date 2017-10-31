/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.exception;

public class CommonException extends Exception{
	public CommonException(String message){
		super(message);
	}
	public CommonException(int state, String message){
		this(message);
	}
}
