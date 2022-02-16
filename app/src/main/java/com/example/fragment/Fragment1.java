package com.example.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

public class Fragment1 extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        Button botton1 = rootView.findViewById(R.id.button1);
        Button botton2 = rootView.findViewById(R.id.button2);
        Button botton3 = rootView.findViewById(R.id.botton3);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        int buttonIndex = translateIdToIndex(v.getId());
        OnSelectedButtonListener listener =  (OnSelectedButtonListener) getActivity();
        listener.onButtonSelected(buttonIndex);
        Toast.makeText(getActivity(), "Ви натиснули на клавішу",
                Toast.LENGTH_LONG).show();
    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.button1:
                index = 1;
                break;
            case R.id.button2:
                index = 2;
                break;
            case R.id.botton3:
                index = 3;
                break;
        }
        return index;
    }

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

}
