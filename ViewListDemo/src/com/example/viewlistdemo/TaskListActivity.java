
package com.example.viewlistdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ToggleButton;

public class TaskListActivity extends Activity {
	
	private ListView lv1;
	private TaskList taskListInstance = TaskList.getInstance();
	private TaskListBaseAdaptor adapter;
	private CheckBox checkBox;
	private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	checkBox = (CheckBox) findViewById(R.id.checkbox);
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        context = this;
        lv1 = (ListView) findViewById(R.id.listView1);
        adapter = new TaskListBaseAdaptor(this);
        lv1.setAdapter(adapter);
        
       
    }
    
	public void addTask(View v) 
	{
		Intent intent = new Intent(v.getContext(), CreateTaskActivity.class);
    	startActivity(intent);				
	}
	public void delTasks(View v)
	{
		int i;
		for(i=0;i<taskListInstance.getSize();i++)
		{
			if(taskListInstance.getItem(i).isChecked())
			{
			
				adapter.delTask(taskListInstance.getItem(i));
				i--;
			}
		}
		onResume();
	}
	
	
	
    @Override
    public void onResume()
    {
    	super.onResume();
    	adapter.notifyDataSetChanged();	
    	
    }
}
