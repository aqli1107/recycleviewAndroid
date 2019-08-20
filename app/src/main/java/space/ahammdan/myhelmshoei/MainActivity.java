package space.ahammdan.myhelmshoei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import space.ahammdan.myhelmshoei.adapter.HelmAdapter;
import space.ahammdan.myhelmshoei.model.HelmShoei;
import space.ahammdan.myhelmshoei.model.HelmShoeiData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_helm;
    private ArrayList<HelmShoei> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_helm = findViewById(R.id.rv_item);
        rv_helm.setHasFixedSize(true);

        list.addAll(HelmShoeiData.getListData());

        showListRv();
    }

    private void showListRv() {
        rv_helm.setLayoutManager(new LinearLayoutManager(this));
        HelmAdapter heroAdapter = new HelmAdapter(list, this);
        rv_helm.setAdapter(heroAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {

    }
}
