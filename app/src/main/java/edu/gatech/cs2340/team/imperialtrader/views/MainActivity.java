package edu.gatech.cs2340.team.imperialtrader.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import edu.gatech.cs2340.team.imperialtrader.R;

/**
 * MainActivity class to load fragments
 */

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener, HomeClickListener,
        CreatePlayerClickListener, MapClickListener, RegionClickListener, PortClickListener,
        StatusClickListener, InvClickListener, TradeClickListener, EventClickListener {

    @Override
    /**
     * Method for onCreate
     * @param savedInstanceState Bundle
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFrag());
    }

    /**
     * loadFragment method
     * @param fragment
     * @return t/f
     */
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
    /**
     * onNavigationItemSelected method
     * @param menuItem
     * @return t/f
     */
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
    /**
     * onNPClick method
     */
    public void onNpClick() {
        loadFragment(new CreatePlayerFrag());
    }

    /**
     * onCreateClick method
     */
    @Override
    public void onCreateClick() {
        loadFragment(new MapFrag());
    }

    /**
     * onButtonClicked method
     */
    @Override
    public void onButtonClicked() { loadFragment(new RegionFrag()); }

    @Override
    /**
     * mapClicked method
     */
    public void mapClicked() { loadFragment(new MapFrag()); }

    @Override
    /**
     * travelClicked method
     */
    public void travelClicked() {
        loadFragment(new PortFrag());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.port);
    }

    @Override
    /**
     * toTradeClicked method
     */
    public void toTradeClicked() { loadFragment(new TradeFrag()); }

    @Override
    /**
     * onRefuelClicked method
     */
    public void onRefuelClicked() { loadFragment(new PortFrag()); }

    @Override
    /**
     * onRepairClicked method
     */
    public void onRepairClicked() { loadFragment(new PortFrag()); }

    @Override
    /**
     * toInvClicked method
     */
    public void toInvClicked() { loadFragment(new InvFrag()); }

    @Override
    /**
     * onTradeClicked method
     */
    public void onTradeClicked() { loadFragment(new PortFrag()); }



    @Override
    /**
     * onInventoryClicked method
     */
    public void onInventoryClicked() { loadFragment(new InvFrag()); }

    @Override
    /**
     * toBuyClicked method
     */
    public void toBuyClicked() { loadFragment(new TradeFrag()); }

    @Override
    /**
     * toSellClicked method
     */
    public void toSellClicked() { loadFragment(new TradeFrag()); }

    @Override
    /**
     * toEventClicked method
     */
    public void toEventClicked() { loadFragment(new EventFrag()); }

    @Override
    /**
     * toPortClicked method
     */
    public void toPortClicked() { loadFragment(new PortFrag()); }
}
