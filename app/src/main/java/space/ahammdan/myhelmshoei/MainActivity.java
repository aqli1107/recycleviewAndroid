package space.ahammdan.myhelmshoei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

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
        HelmAdapter heroAdapter = new HelmAdapter(list);
        rv_helm.setAdapter(heroAdapter);
    }

    private void showCardRv(){
        rv_helm.setLayoutManager(new LinearLayoutManager(this));
        CardHelmAdapter cardHeroAdapter = new CardHelmAdapter(list);
        rv_helm.setAdapter(cardHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_list:
            showListRv();
            break;
            case R.id.action_cardview:
            showCardRv();
            break;
        }
    }
}
