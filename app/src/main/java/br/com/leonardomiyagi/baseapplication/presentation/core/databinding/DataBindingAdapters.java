package br.com.leonardomiyagi.baseapplication.presentation.core.databinding;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * Created by lmiyagi on 27/07/17.
 */

public class DataBindingAdapters {

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageResource, @DrawableRes int resource) {
        imageResource.setImageResource(resource);
    }
}
