package eu.fse.notz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    //private String [] myDataset = { "nota1", "nota 2", "fai la spesa","paga bolletta luca", "dadsadasa", "dsasdasd", "dassad"};
      private ArrayList<Note>myDataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.notes_rv);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset =new ArrayList<>();
        Note spesa =new Note(title:"PIN, ");
        myDataset.add(spesa);
        mAdapter = new NotesAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);



    }
}
