package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.cs2340.team.imperialtrader.R;
//import edu.gatech.cs2340.team.imperialtrader.entity.Good;
import edu.gatech.cs2340.team.imperialtrader.entity.Inventory;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class TradeFrag extends Fragment {

    private PlayerViewModel playerViewModel;
    private Player player;
    private Inventory availableGoods;
    private Inventory currentInv;
    private int tradePrice;

    private TextView currentGood;
    private TextView currentMoney;
    private TextView portQuantity;
    private TextView playerQuantity;
    // private TextView buyPrice;
    // private TextView sellPrice;
    private TextView tradePriceText;
    private EditText buyQuantField;
    private EditText sellQuantField;

    private Button sellButton;
    private Button buyButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trade,
                container, false);

        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = playerViewModel.getPlayer();
        availableGoods = player.getCurRegion().getGoodsInRegion();
        currentInv = player.getInventory();


        currentGood = view.findViewById(R.id.currentGood);
        currentMoney = view.findViewById(R.id.currentMoney);
        portQuantity = view.findViewById(R.id.portQuantity);
        playerQuantity = view.findViewById(R.id.playerQuantity);
        //buyPrice = view.findViewById(R.id.buyPrice);
        //sellPrice = view.findViewById(R.id.sellPrice);
        tradePriceText = view.findViewById(R.id.tradePrice);
        buyButton = view.findViewById(R.id.buyButton);
        sellButton = view.findViewById(R.id.sellButton);


        currentGood.setText(String.valueOf(player.getGood()));
        currentMoney.setText(String.valueOf(player.getMoney()));
        portQuantity.setText(String.valueOf(availableGoods.getCount(player.getGood())));
        playerQuantity.setText(String.valueOf(currentInv.getCount(player.getGood())));
        tradePrice = 30;
        tradePriceText.setText(String.valueOf(tradePrice));


        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buyQuantField.getText().toString().equals("")) {
                    int deleteme;
                    //errorEmptyBuyText.setVisibility(View.VISIBLE);
                }
                int buyQuant = Integer.parseInt(buyQuantField.getText().toString());
                if (buyQuant <= 0) {
                    int d;
                    //errorEmptyBuyText
                }
                int cost = buyQuant * tradePrice;
                if (cost > player.getMoney()) {
                    //errorNotEnoughMoney;
                    int deleteme2;
                } else if (player.getInventory().add(player.getGood(), buyQuant) == 0) {
                    //errorNotEnoughSpace;
                    int d3;
                } else {
                    player.setMoney(player.getMoney() - cost);
                }
                // validate - check if have enough money
                // then subtract money and add goods

                //playerViewModel.updatePlayer(player);

            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int profit;
                // validate - check if num is less than good #

                //tradeClickListener.toTradeClicked();
            }
        });


        return view;
    }
}
