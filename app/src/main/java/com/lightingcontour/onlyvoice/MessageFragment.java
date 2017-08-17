package com.lightingcontour.onlyvoice;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    public MessageFragment() {
        // Required empty public constructor
    }

    private static final String TAG = "MessageFragment";

    Button test_to_delete;
    Button test_to_add;
    TextView test_message_number;

    int messageNumber = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        ConstraintLayout constraintLayout = (ConstraintLayout)view.findViewById(R.id.constraintLayout);

        test_to_delete = (Button) constraintLayout.findViewById(R.id.test_to_delete);
        test_to_add = (Button) constraintLayout.findViewById(R.id.test_to_add);
        test_message_number = (TextView) constraintLayout.findViewById(R.id.test_message_number);

        test_to_add.setOnClickListener(onClickListener);
        test_to_delete.setOnClickListener(onClickListener);

        return view;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == test_to_add)
            {
                if (messageNumber < 10)
                {
                    test_message_number.setText(Integer.toString(++messageNumber));
                }else
                {
                    Toast.makeText(getContext(),"超出最大值",Toast.LENGTH_SHORT).show();
                }
            }else if (v == test_to_delete)
            {
                if (messageNumber > 1)
                {
                    test_message_number.setText(Integer.toString(--messageNumber));
                }else
                {
                    Toast.makeText(getContext(),"超出最小值",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    private void setAvatars()
    {
        switch (messageNumber)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
