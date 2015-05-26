package devstudio.awefact;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MyActivity extends AppCompatActivity {

    public static ListView listoffact;
    public static ArrayAdapter<String> listoffactadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
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

        //mActionBar.setCustomView(mCustomView);
        //mActionBar.setDisplayShowCustomEnabled(true);


        listoffact = (ListView) findViewById(R.id.listView);
        listoffactadapter = new ArrayAdapter<String>(this, R.layout.mobile);
        listoffact.setAdapter(listoffactadapter);
        fab.attachToListView(listoffact);

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
        return super.onOptionsItemSelected(item);
    }
}
