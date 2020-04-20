package hivatec.ir.hivatectoolstest.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

import hivatec.ir.hivatectools.activityHelpers.ParentActivity;
import hivatec.ir.hivatectools.adapters.HivaRecyclerAdapter;
import hivatec.ir.hivatectools.views.HivaButton;
import hivatec.ir.hivatectoolstest.R;
import hivatec.ir.hivatectoolstest.model.ButtonModel;

public class ButtonActivity extends ParentActivity {

    HivaButton button,hivaButton,hivaButton2,hivaButton3,hivaButton4;


    @Override
    protected void setContentViewActivity() {

        setContentView(R.layout.activity_button);
    }

    @Override
    protected void getIntentData() {

    }

    @Override
    protected void prepareToolbar() {

    }

    @Override
    protected void instantiateViews() {

    }

    @Override
    protected void setViewListeners() {



        button = findViewById(R.id.hiva_button);
        button.setOnClickListener(clickListener);
        findViewById(R.id.hiva_button2).setOnClickListener(clickListener);
        findViewById(R.id.hiva_button3).setOnClickListener(clickListener);
        findViewById(R.id.hiva_button4).setOnClickListener(clickListener);
        findViewById(R.id.hiva_button_top).setOnClickListener(clickListener);
        findViewById(R.id.hiva_button_bottom).setOnClickListener(clickListener);
        findViewById(R.id.hiva_button_nobg).setOnClickListener(clickListener);
        //findViewById(R.id.circle).setOnClickListener(clickListener);

        findViewById(R.id.hiva_button_nobg).setEnabled(false);
        //findViewById(R.id.circle).setEnabled(false);

        ArrayList buttons = new ArrayList<>();
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        for(int i =0 ; i < 30; i++){
            buttons.add(new ButtonModel(("دکمه شماره #") + i));
        }

        recycler.setAdapter(new HivaRecyclerAdapter(buttons));


        Glide.with(context)
                .asBitmap()
                .load("http://www.otooapp.com/image/200x200/k7k2VjjR.png")
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {

                        button.setIcon(0);
                        button.setIcon(resource);
                    }
                });


    }

    @Override
    protected void setActivityContent() {

    }

    @Override
    protected void refreshContent() {

    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startLoading(v);
        }
    };

    private void startLoading(View button) {


        if(button == this.button){

            ((HivaButton) findViewById(R.id.circle)).toggle();
            return;
        }

        ((HivaButton) button).startLoadingStateInsideIcon();

        button.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((HivaButton) button).stopLoadingState();
            }
        }, 3000);



    }


}
