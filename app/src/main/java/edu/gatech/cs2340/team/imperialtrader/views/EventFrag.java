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
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.EventViewModel;


import static edu.gatech.cs2340.team.imperialtrader.entity.Good.NARCOTICS;

public class EventFrag extends Fragment {

    private EventClickListener eventClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            eventClickListener = (EventClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnHeadlineSelectedListener");
        }
    }

    private PlayerViewModel playerViewModel;
    private Player player;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event,
                container, false);
        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = playerViewModel.getPlayer();
        EventViewModel eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        TextView eventMessage = view.findViewById(R.id.eventMessage);

        Button proceedButton = view.findViewById(R.id.proceedButton);
        String returnMessage = eventViewModel.randomEvent();

        if (returnMessage != "Police") {
            // not a police event
            eventMessage.setText(returnMessage);

        } else {
            // POLICE EVENT
            eventMessage.setText("You have been approached by the police. "
                    + "They want to check your bags.");

            Button fightButton = view.findViewById(R.id.fightButton);
            Button obligeButton = view.findViewById(R.id.obligeButton);
            TextView resultMessage = view.findViewById(R.id.resultMessage);
            proceedButton.setVisibility(View.INVISIBLE);

            fightButton.setText("Fight!");
            fightButton.setVisibility(View.VISIBLE);
            fightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    player.setMoney(player.getMoney() + 300);
                    player.getShip().setHealth(player.getShip().getHealth() - 20);
                    playerViewModel.updatePlayer(player);
                    resultMessage.setText("You defeated the police and stole $300 "
                            + "but your ship lost health.");
                    resultMessage.setVisibility(View.VISIBLE);
                    proceedButton.setVisibility(View.VISIBLE);
                }
            });

            obligeButton.setText("Oblige.");
            obligeButton.setVisibility(View.VISIBLE);
            obligeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (player.getInventory().hasGood(NARCOTICS)) {
                        // confiscate narcotics and fine player
                        player.getInventory().subtract(NARCOTICS,
                                player.getInventory().getCount(NARCOTICS));
                        player.setMoney(player.getMoney() - 1000);
                        playerViewModel.updatePlayer(player);
                        resultMessage.setText("The police confiscated your narcotics "
                                + "and fined you $1000!");
                    } else {
                        resultMessage.setText("The police didn't find anything.");
                    }
                    resultMessage.setVisibility(View.VISIBLE);
                    proceedButton.setVisibility(View.VISIBLE);
                }
            });
        }


        proceedButton.setText("Proceed");
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventClickListener.travelClicked();
            }
        });

        return view;
    }
}