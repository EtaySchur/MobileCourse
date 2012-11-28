package com.example.viewlistdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.example.viewlistdemo.R.id;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskListBaseAdaptor extends BaseAdapter {
private TaskList taskListInstance = TaskList.getInstance();
private LayoutInflater l_Inflater;


public TaskListBaseAdaptor(Context context) {
	taskListInstance = TaskList.getInstance();
	  l_Inflater = LayoutInflater.from(context);
	
	  
	 }
	@Override
	public int getCount() {
		return taskListInstance.getSize();
	}

	@Override
	public TaskItem getItem(int position) {
		return taskListInstance.getItem(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	public  boolean addTask(TaskItem newTask)
	{
		if(taskListInstance.addTask(newTask))
			return true;
		return false;
	}
	public  boolean delTask(TaskItem Task)
	{
		
		if(taskListInstance.delTask(Task))
			return true;
		return false;
		
	}

	@Override
	  public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		  if (convertView == null) {
		   convertView = l_Inflater.inflate(R.layout.taskitem ,  null);
		  
		   holder = new ViewHolder();
		   holder.task_tiltle = (TextView) convertView.findViewById(R.id.TaskText1);
		  /* holder.task_tiltle.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					protected Dialog onCreateDialog(int id) 
					{
						switch (id) {
						case DATE_DIALOG_ID:
						   // set date picker as current date
						   return new TextPickerDialog(this, datePickerListener, year, month,day);
						}
						return null;
					}	
				}
				   
			   });*/
		   holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
		   holder.endDate = (TextView)  convertView.findViewById(id.endDateText1);
		   holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
		   {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				
				if(arg0.isChecked())
					TaskList.getInstance().getItem(position).toggleCheckBoxOn();
				else
					TaskList.getInstance().getItem(position).toggleCheckBoxOff();
					
			}
			   
		   });
		   
		   holder.onCreateDate = (TextView) convertView.findViewById(R.id.DateText1);
		   convertView.setTag(holder);
		             
		  } else {
		   holder = (ViewHolder) convertView.getTag();
		   
		 
		  }
		  SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.getDefault());
		  holder.checkBox.setChecked(taskListInstance.getItem(position).isChecked());
		  holder.task_tiltle.setText(taskListInstance.getItem(position).getTaskTitle());
		  holder.onCreateDate.setText(simpleDate.format(taskListInstance.getItem(position).getOnCreateDate()));
		  holder.endDate.setText(simpleDate.format(getItem(position).getEndDate().getTime()));
		return convertView;
	}
static class ViewHolder
{
	TextView task_tiltle;
	CheckBox checkBox;
	TextView onCreateDate;
	TextView endDate;
	
}



}


