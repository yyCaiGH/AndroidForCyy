package org.cyy.view.dialog;


import org.cyy.R;
import org.cyy.view.dialog.spots.AnimatedView;
import org.cyy.view.dialog.spots.AnimatorPlayer;
import org.cyy.view.dialog.spots.HesitateInterpolator;
import org.cyy.view.dialog.spots.ProgressLayout;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SpotsDialog extends AlertDialog {

    private static final int DELAY = 150;
    private static final int DURATION = 1500;

    private int size;
    private AnimatedView[] spots;
    private AnimatorPlayer animator;
    private String message;

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SpotsDialog(Context context) {
        this(context, R.style.SpotsDialogDefault);
    }

    public SpotsDialog(Context context, String message) {
        this(context);
        this.message = message;
    }

    public SpotsDialog(Context context, int theme) {
        super(context, theme);
    }

    public SpotsDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_spots_loding);
        setCanceledOnTouchOutside(false);

        initMessage();
        initProgress();
    }

    @Override
    protected void onStart() {
        super.onStart();

        animator = new AnimatorPlayer(createAnimations());
        animator.play();
    }

    @Override
    protected void onStop() {
        super.onStop();

        animator.stop();
    }

    //~

    private void initMessage() {
    	TextView tvLoading=(TextView) findViewById(R.id.spots_tv_title);
        if (message != null && message.length() > 0&&!message.equals("")) {
        	tvLoading.setVisibility(View.VISIBLE);
        	tvLoading.setText(getMessage());
		}
    }

    private void initProgress() {
        ProgressLayout progress = (ProgressLayout) findViewById(R.id.spots_pl_progress);
        size = progress.getSpotsCount();

        spots = new AnimatedView[size];
        int size = getContext().getResources().getDimensionPixelSize(R.dimen.spots_size);
        int progressWidth = getContext().getResources().getDimensionPixelSize(R.dimen.spots_progress_width);
        for (int i = 0; i < spots.length; i++) {
            AnimatedView v = new AnimatedView(getContext());
            v.setBackgroundResource(R.drawable.spot);
            v.setTarget(progressWidth);
            v.setXFactor(-1f);
            progress.addView(v, size, size);
            spots[i] = v;
        }
    }

    @SuppressLint("NewApi")
	private Animator[] createAnimations() {
        Animator[] animators = new Animator[size];
        for (int i = 0; i < spots.length; i++) {
            Animator move = ObjectAnimator.ofFloat(spots[i], "xFactor", 0, 1);
            move.setDuration(DURATION);
            move.setInterpolator(new HesitateInterpolator());
            move.setStartDelay(DELAY * i);
            animators[i] = move;
        }
        return animators;
    }
}
