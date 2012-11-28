
package com.example.viewlistdemo;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;



@TargetApi(9)
public class CreateTaskActivity extends Activity {
	private TaskList taskListInstance = TaskList.getInstance();
	private DatePicker datePicker;
	private TaskListBaseAdaptor adapter;
	private int year;
	private int month;
	private int day;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task); 
        adapter = new TaskListBaseAdaptor(this);
        
	
    	
     
     }

@SuppressWarnings("deprecation")
public void Create(final View v)
{
	
	// TODO Auto-generated method stub
	
	EditText descText = (EditText) findViewById(R.id.task_desc_text1);	
    EditText titleText = (EditText) findViewById(R.id.task_title_text1);
    DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
	String taskDisc = descText.getText().toString();
	String taskTitle = titleText.getText().toString();
	if (taskTitle.isEmpty())
	{
		DialogInterface.OnClickListener listenerReturn = new DialogInterface.OnClickListener() {
			 
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(v.getContext(), CreateTaskActivity.class);
		    	startActivity(intent);				
			}
		};
	 
		DialogInterface.OnClickListener listenerExit = new DialogInterface.OnClickListener() {
	 
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		};
		Builder builder = new AlertDialog.Builder(CreateTaskActivity.this);
		AlertDialog dialog = builder.create();
		dialog.setTitle("No Title");
		dialog.setMessage("You must enter task's title");
		dialog.setButton("Return", listenerReturn);
		dialog.setButton2("Exit", listenerExit);
		dialog.setCancelable(false);
		dialog.show();
		
	 
	}
	TaskItem newTask = new TaskItem();
	newTask.setTaskDisc(taskDisc);
	newTask.setTaskTitle(taskTitle);
	newTask.setOnCreateDate(new Date(System.currentTimeMillis()));
	newTask.setEndDate(new  GregorianCalendar(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth()));
	adapter.addTask(newTask);
	finish();
}

public void Cancel(View v)
{
	finish();
}
public void setCurrentDateOnView() 
{
	 
	
	long now;
	final Calendar cal = Calendar.getInstance();
	now = cal.getTimeInMillis();
	cal.setTimeInMillis(now);
	year = cal.get(Calendar.YEAR);
	month = cal.get(Calendar.MONTH);
	day = cal.get(Calendar.DAY_OF_MONTH);
	// set current date into date picker
	datePicker.init(year, month, day, null);

}

private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() 
{
	
	
	public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) 
	{
		year = selectedYear;
		month = selectedMonth;
		day = selectedDay;
		datePicker.init(year, month, day, null);

	}
};


}
			

        
	
