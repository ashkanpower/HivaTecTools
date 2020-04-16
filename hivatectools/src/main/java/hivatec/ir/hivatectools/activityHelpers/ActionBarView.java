package hivatec.ir.hivatectools.activityHelpers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hivatec.ir.hivatectools.R;


public class ActionBarView extends RelativeLayout {




    public ToolBarContentView contentView;

    public TextView titleTextView;
    public ImageButton leftButton;
    public ImageButton rightButton1;
    public ImageButton rightButton2;
    private Toolbar toolbar;

    private int backgroundColor = 0;
    private int tintColor = 0;

    private String title = "عنوان";
    private int leftButtonType = 0;
    private int leftDrawable = 0;
    private int right1Drawable = 0;
    private int right2Drawable = 0;

    public ActionBarView(Context context) {
        super(context);
        init();
    }

    public ActionBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ActionBarView, 0, 0);

        backgroundColor = a.getColor(R.styleable.ActionBarView_backgroundColor, getContext().getResources().getColor(R.color.colorPrimary));
        tintColor = a.getColor(R.styleable.ActionBarView_tintColor, Color.WHITE);
        title = a.getString(R.styleable.ActionBarView_title);

        leftButtonType = a.getInt(R.styleable.ActionBarView_leftButton, 0);
        int defLeft = 0;

        switch (leftButtonType){
            case 0 : defLeft = R.drawable.ic_arrow_back; break;
            case 1 : defLeft = R.drawable.ic_menu; break;
            default: defLeft = 0;
        }

        leftDrawable = a.getResourceId(R.styleable.ActionBarView_leftDrawable, defLeft);
        right1Drawable = a.getResourceId(R.styleable.ActionBarView_right1Drawable, right1Drawable);
        right2Drawable = a.getResourceId(R.styleable.ActionBarView_right2Drawable, right2Drawable);

        a.recycle();

        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_action_bar, this);

        this.contentView = findViewById(R.id.toolbar_content);
        this.toolbar = findViewById(R.id.theToolbar);

        toolbar.setBackgroundColor(backgroundColor);
        contentView.setTintColor(tintColor);

        this.titleTextView = contentView.titleTextView;
        this.leftButton = contentView.leftButton;
        this.rightButton1 = contentView.rightButton1;
        this.rightButton2 = contentView.rightButton2;


        this.titleTextView.setText(title);
        leftButton.setImageResource(leftDrawable);
        rightButton1.setImageResource(right1Drawable);
        rightButton2.setImageResource(right2Drawable);

        if(leftDrawable == 0){
            leftButton.setVisibility(GONE);
        }
        if(right1Drawable == 0){
            rightButton1.setVisibility(GONE);
        }
        if(right2Drawable == 0){
            rightButton2.setVisibility(GONE);
        }
    }
    public Toolbar getToolbar(){

        return this.toolbar;
    }
}