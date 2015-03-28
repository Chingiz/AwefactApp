package devstudio.awefact;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class factsadapter extends ArrayAdapter<facts> {

    Context context;
    int layoutResourceId;
    ArrayList<facts> students = new ArrayList<facts>();

    public factsadapter(Context context, int layoutResourceId,
                          ArrayList<facts> studs) {
        super(context, layoutResourceId, studs);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.students = studs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        StudentWrapper StudentWrapper = null;

        if (item == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            item = inflater.inflate(layoutResourceId, parent, false);
            StudentWrapper = new StudentWrapper();
            StudentWrapper.name = (TextView) item.findViewById(R.id.textName);
            StudentWrapper.edit = (Button) item.findViewById(R.id.sharebut);
            item.setTag(StudentWrapper);
        } else {
            StudentWrapper = (StudentWrapper) item.getTag();
        }

        facts fact = students.get(position);
        StudentWrapper.name.setText(facts.getName());

        StudentWrapper.edit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Edit", Toast.LENGTH_LONG).show();
            }
        });

        return item;

    }

    static class StudentWrapper {
        TextView name;
        Button edit;
    }

}