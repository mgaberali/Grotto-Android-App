package com.java.grotto;

import java.util.ArrayList;
import java.util.List;
import com.java.grotto.pojo.Neighbor;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EmergencyList extends Activity {

	private ListView emergencyList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_list);
		
		// get action bar   
        ActionBar actionBar = getActionBar();
        
        // hide action bar icon
        getActionBar().setIcon(
        		   new ColorDrawable(getResources().getColor(android.R.color.transparent)));    
		
		// link list_emergency with UI component
		emergencyList = (ListView) findViewById(R.id.list_emergency);
		
		// create emergency array list
		List<Neighbor> neighbors = new ArrayList<Neighbor>();
		
		// test data
		neighbors.add(new Neighbor());
		neighbors.add(new Neighbor());
		neighbors.add(new Neighbor());
		neighbors.add(new Neighbor());
		
		
		// set list of emergency data
		setEmergencyListData(this, neighbors);
		
	}
	
	/**
	 * create custom adapter by list of emergency and set this adapter to neighbors list view
	 * @param context
	 * @param list of emergency contacts
	 */
	private void setEmergencyListData(Context context, List<Neighbor> emergencyContacts){
		
		// create custom adapter
		NeighborsCustomAdapter adapter = new NeighborsCustomAdapter(context, R.layout.item_emergency, emergencyContacts);
		
		// set list adapter
		emergencyList.setAdapter(adapter);
		
	}
	
	private class NeighborsCustomAdapter extends ArrayAdapter<Neighbor>{

		private Context context;
		
		public NeighborsCustomAdapter(Context context, int textViewResourceId,
				List<Neighbor> objects) {
			super(context, textViewResourceId, objects);
			
			this.context = context;
			
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			// get layout infalter
			LayoutInflater inflator = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			// get item_neighbor layout
			View neighborItem = inflator.inflate(R.layout.item_emergency, parent, false);
			
			return neighborItem;
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.emergency_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
