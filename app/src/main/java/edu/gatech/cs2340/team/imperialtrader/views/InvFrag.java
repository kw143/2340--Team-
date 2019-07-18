package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.Button;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Good;
import edu.gatech.cs2340.team.imperialtrader.entity.Inventory;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class InvFrag extends Fragment {

    private InvClickListener invClickListener;

     @Override
     /**
      * Method for onAttach
      * @param context Context
      */
     public void onAttach(Context context) {
        super.onAttach(context);

         try {
             invClickListener = (InvClickListener) context;
         } catch (ClassCastException e) {
             throw new ClassCastException(context.toString() +
                     " must implement OnHeadLineSelectedListener");
         }
    }

    private PlayerViewModel playerViewModel;
    private Player player;
    private Inventory currentInv;
    private TextView currentMoney;

    private TextView waterQuantity;
    private TextView furQuantity;
    private TextView foodQuantity;
    private TextView oreQuantity;
    private TextView gameQuantity;
    private TextView firearmQuantity;
    private TextView medicineQuantity;
    private TextView machineQuantity;
    private TextView narcoticQuantity;
    private TextView robotQuantity;

    private Button tradeButton;

    @Nullable
    @Override
    /**
     * Method for onCreateView
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inventory,
                container, false);

        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = playerViewModel.getPlayer();
        currentInv = player.getInventory();

        tradeButton = view.findViewById(R.id.backToTrade);
        currentMoney = view.findViewById(R.id.currentMoney);
        waterQuantity = view.findViewById(R.id.quantityI);
        furQuantity = view.findViewById(R.id.quantityII);
        foodQuantity = view.findViewById(R.id.quantityIII);
        oreQuantity = view.findViewById(R.id.quantityIV);
        gameQuantity = view.findViewById(R.id.quantityV);
        firearmQuantity = view.findViewById(R.id.quantityVI);
        medicineQuantity = view.findViewById(R.id.quantityVII);
        machineQuantity = view.findViewById(R.id.quantityVIII);
        narcoticQuantity = view.findViewById(R.id.quantityIX);
        robotQuantity = view.findViewById(R.id.quantityX);

        currentMoney.setText(String.valueOf(player.getMoney()));
        waterQuantity.setText(String.valueOf(currentInv.getCount(Good.WATER)));
        furQuantity.setText(String.valueOf(currentInv.getCount(Good.FURS)));
        foodQuantity.setText(String.valueOf(currentInv.getCount(Good.FOOD)));
        oreQuantity.setText(String.valueOf(currentInv.getCount(Good.ORE)));
        gameQuantity.setText(String.valueOf(currentInv.getCount(Good.GAMES)));
        firearmQuantity.setText(String.valueOf(currentInv.getCount(Good.FIREARMS)));
        medicineQuantity.setText(String.valueOf(currentInv.getCount(Good.MEDICINE)));
        machineQuantity.setText(String.valueOf(currentInv.getCount(Good.MACHINES)));
        narcoticQuantity.setText(String.valueOf(currentInv.getCount(Good.NARCOTICS)));
        robotQuantity.setText(String.valueOf(currentInv.getCount(Good.ROBOTS)));

        tradeButton.setOnClickListener(v -> invClickListener.onTradeClicked());

        return view;
    }
}