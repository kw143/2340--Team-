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
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Good;
import edu.gatech.cs2340.team.imperialtrader.entity.Inventory;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.RadicalPriceEvent;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.entity.Resource;
import edu.gatech.cs2340.team.imperialtrader.entity.TechLevel;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class PortFrag extends Fragment {

    private PortClickListener portClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            portClickListener = (PortClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnHeadlineSelectedListener");
        }
    }

    public static int priceVarianceEnforce(double newPrice, double variance, int base) {
        double actualPrice = newPrice;
        if (newPrice > (base * (1 + (0.01 * variance)))) {
            actualPrice = (base * (1 + (0.01 * variance)));
        }
        if (newPrice < (base * (1 - (0.009 * variance)))) {
            actualPrice = (base * (1 - (0.009 * variance)));
        }
        return (int)actualPrice;
    }

    public static int priceCalc(Region Re, double quantity, Good type) {
        double price = type.getBasePrice();
        TechLevel tech = Re.getTechLevel();
        RadicalPriceEvent event = Re.getCurEvent();
        Resource res = Re.getResource();
        //price change based on tech level
        price += type.getIPL() * (tech.ordinal() - type.getMLTP().ordinal());
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

        return priceVarianceEnforce(price, type.getVar(), type.getBasePrice());
    }

    private PlayerViewModel playerViewModel;
    private Player player;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.port,
                container, false);

        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = playerViewModel.getPlayer();
        Inventory availableGoods = player.getCurRegion().getGoodsInRegion();

        TextView curRegion = view.findViewById(R.id.currentRegionTrade);
        TextView curEvent = view.findViewById(R.id.curRadicalEvent);

        curRegion.setText(player.getCurRegion().getName());
        curEvent.setText(player.getCurRegion().getCurEvent().toString());

        Button button1 = view.findViewById(R.id.tradeButton1);
        Button button2 = view.findViewById(R.id.tradeButton2);
        Button button3 = view.findViewById(R.id.tradeButton3);
        Button button4 = view.findViewById(R.id.tradeButton4);
        Button button5 = view.findViewById(R.id.tradeButton5);
        Button button6 = view.findViewById(R.id.tradeButton6);
        Button button7 = view.findViewById(R.id.tradeButton7);
        Button button8 = view.findViewById(R.id.tradeButton8);
        Button button9 = view.findViewById(R.id.tradeButton9);
        Button button10 = view.findViewById(R.id.tradeButton10);

        Button repairButton = view.findViewById(R.id.repair_button);
        Button refuelButton = view.findViewById(R.id.refuel_button);

        TextView waterPrice = view.findViewById(R.id.priceI);
        TextView furPrice = view.findViewById(R.id.priceII);
        TextView foodPrice = view.findViewById(R.id.priceIII);
        TextView orePrice = view.findViewById(R.id.priceIV);
        TextView gamePrice = view.findViewById(R.id.priceV);
        TextView firearmPrice = view.findViewById(R.id.priceVI);
        TextView medicinePrice = view.findViewById(R.id.priceVII);
        TextView machinePrice = view.findViewById(R.id.priceVIII);
        TextView narcoticPrice = view.findViewById(R.id.priceIX);
        TextView robotPrice = view.findViewById(R.id.priceX);

        waterPrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.WATER), Good.WATER)));
        furPrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.FURS), Good.FURS)));
        foodPrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.FOOD), Good.FOOD)));
        orePrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.ORE), Good.ORE)));
        gamePrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.GAMES), Good.GAMES)));
        firearmPrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.FIREARMS), Good.FIREARMS)));
        medicinePrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.MEDICINE), Good.MEDICINE)));
        machinePrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.MACHINES), Good.MACHINES)));
        narcoticPrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.NARCOTICS), Good.NARCOTICS)));
        robotPrice.setText(String.valueOf(priceCalc(player.getCurRegion(),
                availableGoods.getCount(Good.ROBOTS), Good.ROBOTS)));

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

        waterQuantity.setText(String.valueOf(availableGoods.getCount(Good.WATER)));
        furQuantity.setText(String.valueOf(availableGoods.getCount(Good.FURS)));
        foodQuantity.setText(String.valueOf(availableGoods.getCount(Good.FOOD)));
        oreQuantity.setText(String.valueOf(availableGoods.getCount(Good.ORE)));
        gameQuantity.setText(String.valueOf(availableGoods.getCount(Good.GAMES)));
        firearmQuantity.setText(String.valueOf(availableGoods.getCount(Good.FIREARMS)));
        medicineQuantity.setText(String.valueOf(availableGoods.getCount(Good.MEDICINE)));
        machineQuantity.setText(String.valueOf(availableGoods.getCount(Good.MACHINES)));
        narcoticQuantity.setText(String.valueOf(availableGoods.getCount(Good.NARCOTICS)));
        robotQuantity.setText(String.valueOf(availableGoods.getCount(Good.ROBOTS)));


        refuelButton.setOnClickListener(v -> {
            player.setMoney(player.getMoney()-100);
            player.getShip().setCurrentFuel(player.getShip().getCurrentFuel()+10);
            playerViewModel.updatePlayer(player);
            portClickListener.onRefuelClicked();
        });

        repairButton.setOnClickListener(v -> {
            player.setMoney(player.getMoney()-200);
            player.getShip().setHealth(player.getShip().getHealth()+50);
            playerViewModel.updatePlayer(player);
            portClickListener.onRepairClicked();
        });

        button1.setText("Trade");
        button1.setOnClickListener(v -> {
            player.setGood(Good.WATER);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button2.setText("Trade");
        button2.setOnClickListener(v -> {
            player.setGood(Good.FURS);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button3.setText("Trade");
        button3.setOnClickListener(v -> {
            player.setGood(Good.FOOD);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button4.setText("Trade");
        button4.setOnClickListener(v -> {
            player.setGood(Good.ORE);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button5.setText("Trade");
        button5.setOnClickListener(v -> {
            player.setGood(Good.GAMES);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button6.setText("Trade");
        button6.setOnClickListener(v -> {
            player.setGood(Good.FIREARMS);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button7.setText("Trade");
        button7.setOnClickListener(v -> {
            player.setGood(Good.MEDICINE);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button8.setText("Trade");
        button8.setOnClickListener(v -> {
            player.setGood(Good.MACHINES);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button9.setText("Trade");
        button9.setOnClickListener(v -> {
            player.setGood(Good.NARCOTICS);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        button10.setText("Trade");
        button10.setOnClickListener(v -> {
            player.setGood(Good.ROBOTS);
            playerViewModel.updatePlayer(player);
            portClickListener.toTradeClicked();
        });

        return view;
    }
}
