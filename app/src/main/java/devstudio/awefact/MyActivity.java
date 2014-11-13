package devstudio.awefact;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.melnykov.fab.FloatingActionButton;

public class MyActivity extends Activity {

    public static ListView listoffact;
    public static ArrayAdapter<String> listoffactadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ActionBar mActionBar = getActionBar();
        assert mActionBar != null;
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.actionbar, null);
        //TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        //mTitleTextView.setText("Awefact");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.bringToFront();
        fab.setColorNormal(Color.parseColor("#ff8167"));
        fab.setColorPressed(Color.parseColor("#FFFF8C61"));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listoffactadapter.clear();
                splash.rq.add(splash.jsonRequestdate);
                splash.rq.add(splash.jsonRequesttrivia);
                splash.rq.add(splash.jsonRequestmath);
                splash.rq.add(splash.jsonRandomYear);
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        listoffact = (ListView) findViewById(R.id.listView);
        listoffactadapter = new ArrayAdapter<String>(this, R.layout.mobile);
        listoffact.setAdapter(listoffactadapter);

        fab.attachToListView(listoffact);
        /*listoffact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                // int itemPosition = position;
                // ListView Clicked item value
                String  itemValue    = (String) listoffact.getItemAtPosition(position);
                // Show Alert
                ClipboardManager clipboard =
                        (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                clipboard.setText(itemValue);
                Toast.makeText(getApplicationContext(),
                        "Fact has been copied to clipboard", Toast.LENGTH_LONG)
                        .show();
            }
        });*/


        listoffact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String  itemValue    = (String) listoffact.getItemAtPosition(position);
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, itemValue+" via @AwefactApp");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                return false;
            }
        });
        /*copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard =
                        (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                clipboard.setText(textfromjson.getText());
                Toast.makeText(context, "Fact has been copied.", Toast.LENGTH_SHORT).show();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rq.add(jsonRequest);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       /* if (id == R.id.action_search) {
            listoffactadapter.clear();
            splash.rq.add(splash.jsonRequestdate);
            splash.rq.add(splash.jsonRequesttrivia);
            splash.rq.add(splash.jsonRequestmath);
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }
}
