package com.diaoxinqiang.bookapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cengalabs.flatui.views.FlatButton;
import com.diaoxinqiang.bookapp.R;
import com.diaoxinqiang.bookapp.activities.MainActivity_;
import com.diaoxinqiang.bookapp.utils.LogUtil;


public class RippleFragment extends Fragment {


    public RippleFragment() {
        // Required empty public constructor
    }

    private boolean isFirstTouch = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ripple, container, false);

        FlatButton flatButton = (FlatButton) view.findViewById(R.id.fb);
        flatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity_.class);
                getActivity().finish();
                startActivity(intent);
                LogUtil.i("gotoMainActivity");
            }
        });

        return view;
    }


}
