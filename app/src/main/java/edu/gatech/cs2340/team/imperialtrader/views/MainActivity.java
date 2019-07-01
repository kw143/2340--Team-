package edu.gatech.cs2340.team.imperialtrader.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import edu.gatech.cs2340.team.imperialtrader.R;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener, HomeClickListener, CreatePlayerClickListener, MapClickListener, RegionClickListener, PortClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFrag());
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch(menuItem.getItemId()) {

            case R.id.navigation_home:
                fragment = new HomeFrag();
                break;
            case R.id.map:
                fragment = new MapFrag();
                break;
            case R.id.player_status:
                fragment = new StatusFrag();
                break;
            case R.id.port:
                fragment = new PortFrag();
        }
        return loadFragment(fragment);
    }

    @Override
    public void onNpClick() {
        loadFragment(new CreatePlayerFrag());
    }

    @Override
    public void onCreateClick() {
        loadFragment(new MapFrag());
    }

    @Override
    public void onButtonClicked() { loadFragment(new RegionFrag()); }

    @Override
    public void mapClicked() { loadFragment(new MapFrag()); }

    @Override
    public void tradeClicked() { loadFragment(new PortFrag()); }

    @Override
    public void toTradeClicked() { loadFragment(new TradeFrag()); }
}
