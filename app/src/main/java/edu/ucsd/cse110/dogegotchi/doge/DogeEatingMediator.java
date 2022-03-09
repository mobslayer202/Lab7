package edu.ucsd.cse110.dogegotchi.doge;

import android.view.View;

import edu.ucsd.cse110.dogegotchi.R;

public class DogeEatingMediator implements IDogeObserver{

    View foodMenu;
    Doge doge;

    public DogeEatingMediator(View foodMenu, Doge doge){

        this.foodMenu = foodMenu;
        this.doge = doge;
        View ham = foodMenu.findViewById(R.id.HamButton);
        View steak = foodMenu.findViewById(R.id.SteakButton);
        View turkey = foodMenu.findViewById(R.id.TurkeyLegButton);

        ham.setOnClickListener((view) -> {

            this.doge.feed();
        });

        steak.setOnClickListener((view) -> {

            this.doge.feed();
        });

        turkey.setOnClickListener((view) -> {

            this.doge.feed();
        });
    }

    @Override
    public void onStateChange(Doge.State newState) {

        // If sad/hungry display menu
        if(newState.equals(Doge.State.SAD)){

            this.foodMenu.setVisibility(View.VISIBLE);
        }
        // If eating
        else if(newState.equals(Doge.State.EATING)){

            this.foodMenu.setVisibility(View.INVISIBLE);
        }
        // If happy
        else if(newState.equals(Doge.State.SLEEPING)){

            this.foodMenu.setVisibility(View.INVISIBLE);
        }
    }
}
