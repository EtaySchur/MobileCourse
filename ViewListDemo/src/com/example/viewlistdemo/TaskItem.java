package com.example.viewlistdemo;

import java.util.Calendar;
import java.util.Date;

import android.widget.CheckBox;

public class TaskItem {
	private String taskTitle;
	private String TaskDisc;
	private boolean checked = false;
	private CheckBox checkBox;
	Date onCreateDate;
	Calendar endDate;
	
	public Date getOnCreateDate() {
		return onCreateDate;
	}
	public void setOnCreateDate(Date onCreateDate) {
		this.onCreateDate = onCreateDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDisc() {
		return TaskDisc;
	}
	public void setTaskDisc(String taskDisc) {
		TaskDisc = taskDisc;
	}
	public void toggleCheckBoxOn()
	{
		checked = true;
	}
	public void toggleCheckBoxOff()
	{
		checked = false;
	}
	public boolean isChecked()
	{
		if(this.checked==true) 
		{
			return true;
		}
		return false;
	}
	public CheckBox getCheckBox()
	{
		return checkBox;
	}
	
}
