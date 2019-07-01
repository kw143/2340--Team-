package edu.gatech.cs2340.team.imperialtrader.views;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.port,
                container, false);

        button1 = view.findViewById(R.id.tradeButton1);
        button2 = view.findViewById(R.id.tradeButton2);
        button3 = view.findViewById(R.id.tradeButton3);
        button4 = view.findViewById(R.id.tradeButton4);
        button5 = view.findViewById(R.id.tradeButton5);
        button6 = view.findViewById(R.id.tradeButton6);
        button7 = view.findViewById(R.id.tradeButton7);
        button8 = view.findViewById(R.id.tradeButton8);
        button9 = view.findViewById(R.id.tradeButton9);


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

        return view;
    }
}
