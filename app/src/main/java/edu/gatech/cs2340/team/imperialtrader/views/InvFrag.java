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
     public void onAttach(Context context) {
        super.onAttach(context);

         try {
             invClickListener = (InvClickListener) context;
         } catch (ClassCastException e) {
             throw new ClassCastException(context.toString() +
                     " must implement OnHeadLineSelectedListener");
         }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inventory,
                container, false);

        PlayerViewModel playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        Player player = playerViewModel.getPlayer();
        Inventory currentInv = player.getInventory();

        Button tradeButton = view.findViewById(R.id.backToTrade);
        TextView currentMoney = view.findViewById(R.id.currentMoney);
        TextView waterQuantity = view.findViewById(R.id.quantityI);
        TextView furQuantity = view.findViewById(R.id.quantityII);
        TextView foodQuantity = view.findViewById(R.id.quantityIII);
        TextView oreQuantity = view.findViewById(R.id.quantityIV);
        TextView gameQuantity = view.findViewById(R.id.quantityV);
        TextView firearmQuantity = view.findViewById(R.id.quantityVI);
        TextView medicineQuantity = view.findViewById(R.id.quantityVII);
        TextView machineQuantity = view.findViewById(R.id.quantityVIII);
        TextView narcoticQuantity = view.findViewById(R.id.quantityIX);
        TextView robotQuantity = view.findViewById(R.id.quantityX);

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