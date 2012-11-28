package com.example.viewlistdemo;

import java.util.ArrayList;

public class TaskList {      // Singleton Task List
    private static TaskList instance = null ;
	private ArrayList<TaskItem> TaskListData = null ;
	private TaskList()
	{
		TaskListData = new ArrayList<TaskItem>();
		 
	}
	public  boolean addTask(TaskItem newTask)
	{
		TaskListData.add(0,newTask);
			return true;
		
	}
	public  boolean delTask(TaskItem Task)
	{
		if(TaskListData.remove(Task))
			return true;
		return false;
		
	}
	
	public static TaskList getInstance()
	{
		if (instance == null) 
		{
			instance = new TaskList();
		}
		return instance;
	}
	public int  getSize()
	{
		return TaskListData.size();
	}
	public  TaskItem getItem(int index)
	{
		return TaskListData.get(index);
	}
}
