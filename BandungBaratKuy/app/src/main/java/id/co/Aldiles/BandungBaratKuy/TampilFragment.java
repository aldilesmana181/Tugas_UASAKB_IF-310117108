package id.co.Aldiles.BandungBaratKuy;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
* * Created by Aldi Lesmana 10117108 IF3 on 11-Agustus-20.
 */

@SuppressLint("ValidFragment")
public class TampilFragment extends Fragment {

    int layout;

    public TampilFragment(int layout){
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(layout, container, false);
    }
}
