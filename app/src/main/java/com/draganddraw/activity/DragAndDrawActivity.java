package com.draganddraw.activity;

import android.support.v4.app.Fragment;

import com.draganddraw.fragment.DragAndDrawFragment;

/**
 * Created by yufei0213 on 2017/2/19.
 */
public class DragAndDrawActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return DragAndDrawFragment.newInstance();
    }
}
