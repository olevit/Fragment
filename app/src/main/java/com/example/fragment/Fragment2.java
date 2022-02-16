package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

public class Fragment2 extends Fragment {

    // Имя для аргумента
    public static final String BUTTON_INDEX = "button_index";
    // Значение по умолчанию
    private static final int BUTTON_INDEX_DEFAULT = -1;
    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray = {"Просто кот", "Рыжик - рыжий кот", "Барсик болеет за Барселону",
            "Мурзик выписывает"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment2, container, false);

        mInfoTextView = (TextView) rootView.findViewById(R.id.textView);
        mCatImageView = (ImageView) rootView.findViewById(R.id.imageView);


        // Получим индекс, если имеется
        Bundle args = getArguments();
        int buttonIndex = args != null ? args.getInt(BUTTON_INDEX,
                BUTTON_INDEX_DEFAULT) : BUTTON_INDEX_DEFAULT;
        // Если индекс обнаружен, то используем его
        if (buttonIndex != BUTTON_INDEX_DEFAULT)
            setDescription(buttonIndex);

        return rootView;
    }
    public void setDescription(int buttonIndex) {
        String catDescription = mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescription);

        switch (buttonIndex) {
            case 1:
                mCatImageView.setImageResource(R.drawable.ic_launcher_background);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.ic_launcher_background);
                break;

            default:
                break;
        }
    }
}
