package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
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
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

    /*private int priceCalc(RadicalPriceEvent event, TechLevel tech, int quantity, Good type) {

    }*/

    private TextView curregion;
    private TextView curEvent;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;

    private TextView waterPrice;
    private TextView furPrice;
    private TextView foodPrice;
    private TextView orePrice;
    private TextView gamePrice;
    private TextView firearmPrice;
    private TextView medicinePrice;
    private TextView machinePrice;
    private TextView narcoticPrice;
    private TextView robotPrice;

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

    private PlayerViewModel playerViewModel;
    private Player player;
    private Inventory availableGoods;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.port,
                container, false);

        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = playerViewModel.getPlayer();
        availableGoods = player.getCurRegion().getGoodsInRegion();

        curregion = view.findViewById(R.id.currentRegionTrade);
        curEvent = view.findViewById(R.id.curRadicalEvent);

        curregion.setText(player.getCurRegion().getName());
        curEvent.setText(player.getCurRegion().getCurEvent().toString());

        button1 = view.findViewById(R.id.tradeButton1);
        button2 = view.findViewById(R.id.tradeButton2);
        button3 = view.findViewById(R.id.tradeButton3);
        button4 = view.findViewById(R.id.tradeButton4);
        button5 = view.findViewById(R.id.tradeButton5);
        button6 = view.findViewById(R.id.tradeButton6);
        button7 = view.findViewById(R.id.tradeButton7);
        button8 = view.findViewById(R.id.tradeButton8);
        button9 = view.findViewById(R.id.tradeButton9);
        button10 = view.findViewById(R.id.tradeButton10);

        waterPrice = view.findViewById(R.id.priceI);
        furPrice = view.findViewById(R.id.priceII);
        foodPrice = view.findViewById(R.id.priceIII);
        orePrice = view.findViewById(R.id.priceIV);
        gamePrice = view.findViewById(R.id.priceV);
        firearmPrice = view.findViewById(R.id.priceVI);
        medicinePrice = view.findViewById(R.id.priceVII);
        machinePrice = view.findViewById(R.id.priceVIII);
        narcoticPrice = view.findViewById(R.id.priceIX);
        robotPrice = view.findViewById(R.id.priceX);

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

        waterQuantity.setText(String.valueOf(availableGoods.getCount(Good.WATER)));
        furQuantity.setText(String.valueOf(availableGoods.getCount(Good.FURS)));
        foodQuantity.setText(String.valueOf(availableGoods.getCount(Good.FOOD)));
        oreQuantity.setText(String.valueOf(availableGoods.getCount(Good.ORE)));
        gameQuantity.setText(String.valueOf(availableGoods.getCount(Good.GAMES)));
        firearmQuantity.setText(String.valueOf(availableGoods.getCount(Good.FIREARMS)));
        medicineQuantity.setText(String.valueOf(availableGoods.getCount(Good.MEDICINCE)));
        machineQuantity.setText(String.valueOf(availableGoods.getCount(Good.MACHINES)));
        narcoticQuantity.setText(String.valueOf(availableGoods.getCount(Good.NARCOTICS)));
        robotQuantity.setText(String.valueOf(availableGoods.getCount(Good.ROBOTS)));



        button1.setText("Trade");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button2.setText("Trade");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button3.setText("Trade");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button4.setText("Trade");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button5.setText("Trade");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button6.setText("Trade");
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button7.setText("Trade");
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button8.setText("Trade");
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button9.setText("Trade");
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        button10.setText("Trade");
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portClickListener.toTradeClicked();
            }
        });

        return view;
    }
}
