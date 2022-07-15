package com.my.flow.dto;

public class Flow {
	private int file_num;
	private String file_extension;
	private String file_check;
	private int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getFile_check() {
		return file_check;
	}
	public void setFile_check(String file_check) {
		this.file_check = file_check;
	}
	public int getFile_num() {
		return file_num;
	}
	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}
	public String getFile_extension() {
		return file_extension;
	}
	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}
	@Override
	public String toString() {
		return "Flow [file_num=" + file_num + ", file_extension=" + file_extension + ", file_check=" + file_check
				+ ", state=" + state + "]";
	}
}
