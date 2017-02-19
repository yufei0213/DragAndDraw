package com.draganddraw.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.draganddraw.R;

/**
 * Created by yufei0213 on 2017/2/19.
 */
public class DragAndDrawFragment extends Fragment {

    public static DragAndDrawFragment newInstance() {

        Bundle bundle = new Bundle();

        DragAndDrawFragment fragment = new DragAndDrawFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_drag_and_draw, container, false);

        return view;
    }
}
