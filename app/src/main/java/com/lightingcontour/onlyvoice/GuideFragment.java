package com.lightingcontour.onlyvoice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * 已弃用Fragment
 */
public class GuideFragment extends Fragment {

    public static final String ARG_OBJECT = "object";

    public GuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);

        Bundle bundle = getArguments();
        int data = bundle.getInt(ARG_OBJECT);

        ImageView imageView = (ImageView) view.findViewById(R.id.guideImage);

        switch (data)
        {
            case 0:
                imageView.setImageResource(R.drawable.pos0);
                break;
            case 1:
                imageView.setImageResource(R.drawable.pos1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.pos2);
                break;
        }

        // Inflate the layout for this fragment
        return view;
    }

}
