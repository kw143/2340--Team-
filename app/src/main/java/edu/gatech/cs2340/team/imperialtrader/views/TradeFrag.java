package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Good;
import edu.gatech.cs2340.team.imperialtrader.entity.Inventory;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.RadicalPriceEvent;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.entity.Resource;
import edu.gatech.cs2340.team.imperialtrader.entity.TechLevel;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class TradeFrag extends Fragment {

    private TradeClickListener tradeClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            tradeClickListener = (TradeClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

    private PlayerViewModel playerViewModel;
    private Player player;
    private Inventory availableGoods;
    private Inventory currentInv;
    private int tradePrice;
    private Good curGood;

    private TextView currentGoodText;
    private TextView currentMoney;
    private TextView portQuantity;
    private TextView playerQuantity;
    private TextView tradePriceText;
    private EditText buyQuantityField;
    private EditText sellQuantityField;
    private TextView errorAvailable;
    private TextView errorEmptyText;
    private TextView errorNotEnoughMoney;
    private TextView errorNotEnoughSpace;
    private TextView errorNotEnoughGoods;
    private TextView errorNumberFormat;
    private TextView errorNegative;

    private Button sellButton;
    private Button buyButton;
    private Button invButton;

    /** calculate price for the good */
    private int priceCalc(Region Re, double quantity, Good type) {
        double price = type.getBasePrice();
        TechLevel tech = Re.getTechLevel();
        RadicalPriceEvent event = Re.getCurEvent();
        Resource res = Re.getResource();
        price += type.getIPL() * (tech.ordinal() - type.getMLTP().ordinal()); //price change based on tech level
        if (event.ordinal() == type.getIE().ordinal()) {
            price *= 2;
        }
        if((type.getCR() != null) && (res.ordinal() == type.getCR().ordinal())) {
            price *= 0.7;
        }
        if((type.getER() != null) && (res.ordinal() == type.getER().ordinal())) {
            price *= 1.3;
        }
        if ((quantity / 1000) > 1) {
            price /= (quantity / 1000 / 50) + 1;
        } else {
            price *= ((1000 - quantity) / 100) + 1;
        }
        if (price > (price * (1 + (0.01 * type.getVar())))) {
            price = price * (1 + (0.01 * type.getVar()));
        }
        if (price < (price * (1 - (0.01 * type.getVar())))) {
            price = price * (1 - (0.01 * type.getVar()));
        }
        return (int) price;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trade,
                container, false);

        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = playerViewModel.getPlayer();
        availableGoods = player.getCurRegion().getGoodsInRegion();
        currentInv = player.getInventory();
        curGood = player.getGood();


        currentGoodText = view.findViewById(R.id.currentGood);
        currentMoney = view.findViewById(R.id.currentMoney);
        portQuantity = view.findViewById(R.id.portQuantity);
        playerQuantity = view.findViewById(R.id.playerQuantity);
        tradePriceText = view.findViewById(R.id.tradePrice);
        buyQuantityField = view.findViewById(R.id.buyQuantField);
        sellQuantityField = view.findViewById(R.id.sellQuantField);
        buyButton = view.findViewById(R.id.buyButton);
        sellButton = view.findViewById(R.id.sellButton);
        errorAvailable = view.findViewById(R.id.errorAvailable);
        errorEmptyText = view.findViewById(R.id.errorEmptyText);
        errorNotEnoughMoney = view.findViewById(R.id.errorNotEnoughMoney);
        errorNotEnoughSpace = view.findViewById(R.id.errorNotEnoughSpace);
        errorNotEnoughGoods = view.findViewById(R.id.errorNotEnoughGoods);
        errorNumberFormat = view.findViewById(R.id.errorNumberFormat);
        errorNegative = view.findViewById(R.id.errorNegative);
        invButton = view.findViewById(R.id.toInventory);

        currentGoodText.setText("Trading for: " + curGood);
        currentMoney.setText("Money: $" + player.getMoney());
        portQuantity.setText("Available to buy: " + availableGoods.getCount(curGood));
        playerQuantity.setText("Available to sell: " + currentInv.getCount(curGood));
        tradePrice = priceCalc(player.getCurRegion(), availableGoods.getCount(curGood), curGood);
        tradePriceText.setText("Trade price: $" + tradePrice);


        buyButton.setOnClickListener(v -> {
            if ("".equals(buyQuantityField.getText().toString())) {
                // no input
                Log.d("Error", "No input provided.");
                errorEmptyText.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorEmptyText.setVisibility(View.INVISIBLE),
                        2000);
                return;
            }
            int buyQuantity = 0;
            try {
                buyQuantity = Integer.parseInt(buyQuantityField.getText().toString());
            } catch (NumberFormatException e) {
                Log.d("Error", "Input not a number");
                errorNumberFormat.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorNumberFormat.setVisibility(View.INVISIBLE),
                        2000);
                return;
            }
            if (availableGoods.getCount(curGood) == 0) {
                // if there is no good to be bought
                Log.d("Error", "No good available");
                errorAvailable.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorAvailable.setVisibility(View.INVISIBLE),
                        2000);
                return;
            }
            if (buyQuantity <= 0) {
                // if input is a negative number
                Log.d("Error", "Quantity cannot be negative.");
                errorNegative.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorNegative.setVisibility(View.INVISIBLE),
                        2000);
                return;
            } else if (buyQuantity >= availableGoods.getCount(curGood)) {
                // if the player wants to buy more goods than there are
                // set the number of goods equal to the max available amount
                buyQuantity = availableGoods.getCount(curGood);
            }
            int cost = buyQuantity * tradePrice;
            if (cost > player.getMoney()) {
                Log.d("Error", "Player does not have enough money.");
                errorNotEnoughMoney.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorNotEnoughMoney.setVisibility(View.INVISIBLE),
                        2000);
            } else if (currentInv.add(curGood, buyQuantity) == 0) {
                Log.d("Error", "Player does not have enough space in inventory.");
                errorNotEnoughSpace.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorNotEnoughSpace.setVisibility(View.INVISIBLE),
                        2000);
            } else {
                // set inventory to the new inventory
                player.setInventory(currentInv);
                player.setMoney(player.getMoney() - cost);
                // subtract goods from the inventory at the region
                availableGoods.subtract(curGood, buyQuantity);
                // DO WE NEED AN UPDATE REGION??
                player.getCurRegion().setGoodsInRegion(availableGoods);
                playerViewModel.updatePlayer(player);
                tradeClickListener.toBuyClicked();
            }
            // validate - check if have enough money
            // then subtract money and add goods
        });

        sellButton.setOnClickListener(v -> {
            // validate - check if num is less than good #
            if ("".equals(sellQuantityField.getText().toString())) {
                Log.d("Error", "No input provided.");
                errorEmptyText.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorEmptyText.setVisibility(View.INVISIBLE),
                        2000);
                return;
            }
            int sellQuantity = 0;
            try {
                sellQuantity = Integer.parseInt(sellQuantityField.getText().toString());
            } catch (NumberFormatException e) {
                Log.d("Error", "Input not a number");
                errorNumberFormat.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorNumberFormat.setVisibility(View.INVISIBLE),
                        2000);
                return;
            }
            if (currentInv.getCount(curGood) == 0) {
                // if there is no good to be bought
                Log.d("Error", "No good available");
                errorAvailable.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorAvailable.setVisibility(View.INVISIBLE),
                        2000);
                return;
            }
            if (sellQuantity <= 0) {
                Log.d("Error", "Quantity cannot be negative.");
                errorNegative.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorNegative.setVisibility(View.INVISIBLE),
                        2000);
                return;
            } else if (sellQuantity >= currentInv.getCount(curGood)) {
                // if the player wants to sell more goods than there are
                // set the number of goods equal to the max available amount
                sellQuantity = currentInv.getCount(curGood);
            }
            int profit = sellQuantity * tradePrice;
            if (currentInv.subtract(curGood, sellQuantity) == 0) {
                Log.d("Error", "Cannot sell more than the player has.");
                errorNotEnoughGoods.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        () -> errorNotEnoughGoods.setVisibility(View.INVISIBLE),
                        2000);
            } else {
                // set inventory to the new inventory
                player.setInventory(currentInv);
                player.setMoney(player.getMoney() + profit);
                // subtract goods from the inventory at the region
                availableGoods.add(curGood, sellQuantity);
                // DO WE NEED AN UPDATE REGION??
                player.getCurRegion().setGoodsInRegion(availableGoods);
                playerViewModel.updatePlayer(player);
                tradeClickListener.toSellClicked();
            }
        });

        invButton.setOnClickListener(v -> tradeClickListener.onInventoryClicked());


        return view;
    }
}
