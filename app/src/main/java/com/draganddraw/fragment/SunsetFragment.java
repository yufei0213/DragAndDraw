package com.draganddraw.fragment;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.draganddraw.R;

/**
 * Created by yufei0213 on 2017/2/19.
 */
public class SunsetFragment extends Fragment {

    private View sceneView;
    private View sunView;
    private View skyView;

    private int blueSkyColor;
    private int sunsetSkyColor;
    private int nightSkyColor;

    public static SunsetFragment newInstance() {

        Bundle bundle = new Bundle();

        SunsetFragment fragment = new SunsetFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sunset_fragment, container, false);

        sceneView = view;
        sunView = view.findViewById(R.id.sun);
        skyView = view.findViewById(R.id.sky);

        Resources resource = getResources();
        blueSkyColor = resource.getColor(R.color.blue_sky);
        sunsetSkyColor = resource.getColor(R.color.sunset_sky);
        nightSkyColor = resource.getColor(R.color.night_sky);

        sceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startAnimation();
            }
        });

        return view;
    }

    private void startAnimation() {

        float sunYStart = sunView.getTop();
        float sunYEnd = skyView.getHeight();

        ObjectAnimator heightAnimator = ObjectAnimator
                .ofFloat(sunView, "y", sunYStart, sunYEnd)
                .setDuration(3000);
        heightAnimator.setInterpolator(new AccelerateInterpolator());

        ObjectAnimator sunsetSkyAnimator = ObjectAnimator
                .ofInt(skyView, "backgroundColor", blueSkyColor, sunsetSkyColor)
                .setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

        ObjectAnimator nightSkyAnimator = new ObjectAnimator()
                .ofInt(skyView, "backgroundColor", sunsetSkyColor, nightSkyColor)
                .setDuration(3000);
        nightSkyAnimator.setEvaluator(new ArgbEvaluator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(heightAnimator)
                .with(sunsetSkyAnimator)
                .before(nightSkyAnimator);
        animatorSet.start();
    }
}
