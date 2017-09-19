package batch16.android.devf.com.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import batch16.android.devf.com.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    TextView tvTitle;
    String titulo;

    public BlankFragment() {
        // Required empty public constructor
    }

    public BlankFragment(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(titulo);
        return view;
    }

}
