package com.idunnolol.repeat.app;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.idunnolol.repeat.R;
import com.idunnolol.repeat.app.DemoListActivity.DemoAdapter.Item;

public class DemoListActivity extends ListActivity {

	private DemoAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mAdapter = new DemoAdapter();
		setListAdapter(mAdapter);

		// Demonstrates a bad way of setting up varying layouts where most of the
		// content remains the same.
		mAdapter.addLayoutItem("Headers (Bad Setup)", R.layout.activity_headers_bad);

		// A better version of the headers setup
		mAdapter.addLayoutItem("Headers (Good Setup)", R.layout.activity_headers_good);

		// A version that takes things a bit too far, but shows how you can nest includes
		// inside of other includes to just change the modified parts of a layout
		mAdapter.addLayoutItem("Headers (Nested Setup)", R.layout.activity_headers_nested);

		// Demonstrates how you can change a string between English and French
		mAdapter.addLayoutItem("Resource Qualifiers - Strings", R.layout.activity_strings);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Item item = (Item) mAdapter.getItem(position);
		item.mOnClick.run();
	}

	public class DemoAdapter extends BaseAdapter {

		public class Item {
			public String mLabel;
			public Runnable mOnClick;
		}

		private List<Item> mItems = new ArrayList<Item>();

		public void addItem(String label, Runnable onClick) {
			Item item = new Item();
			item.mLabel = label;
			item.mOnClick = onClick;
			mItems.add(item);
		}

		public void addLayoutItem(String label, final int layoutId) {
			addItem(label, new Runnable() {
				@Override
				public void run() {
					Intent intent = new Intent(DemoListActivity.this, LayoutDemoActivity.class);
					intent.putExtra(LayoutDemoActivity.EXTRA_LAYOUT_ID, layoutId);
					startActivity(intent);
				}
			});
		}

		@Override
		public int getCount() {
			return mItems.size();
		}

		@Override
		public Object getItem(int position) {
			return mItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);
			}

			TextView textView = (TextView) convertView;
			Item item = (Item) getItem(position);
			textView.setText(item.mLabel);

			return convertView;
		}
	}
}
