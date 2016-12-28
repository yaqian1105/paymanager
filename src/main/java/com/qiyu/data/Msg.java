package com.qiyu.data;

import com.qiyu.data.enums.ProtocolDepositLogStatus;

import java.io.Serializable;

/**
 * 
 * @kk
 *
 */
@SuppressWarnings("serial")
public class Msg implements Serializable {
	private boolean success;
	private String desc;
	private Object data;
	private int type;
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static Msg createSucMsg() {
		ProtocolDepositLogStatus.APPLY_REFUND.getIndex();
		Msg m = new Msg();
		m.setSuccess(true);
		return m;
	}
	
	public static Msg createSucMsg(int type) {
		return createSucMsg(type,null);
	}
	
	public static Msg createSucMsg(int type,Object data) {
		Msg m = new Msg();
		m.setSuccess(true);
		m.setType(type);
		m.setData(data);
		return m;
	}

	public static Msg createSucMsg(Object data) {
		Msg m = new Msg();
		m.setSuccess(true);
		m.setData(data);
		return m;
	}

	public static Msg createFailMsg(int type, String desc) {
		Msg m = new Msg();
		m.setSuccess(false);
		m.setDesc(desc);
		m.setType(type);
		return m;
	}

	public static Msg createFailMsg(String desc) {
		Msg m = new Msg();
		m.setSuccess(false);
		m.setDesc(desc);
		return m;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
