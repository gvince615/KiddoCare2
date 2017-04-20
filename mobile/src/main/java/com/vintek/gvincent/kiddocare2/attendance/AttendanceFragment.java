package com.vintek.gvincent.kiddocare2.attendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vintek.gvincent.kiddocare2.R;

/**
 * Created by gvincent on 4/14/17.
 */

public class AttendanceFragment extends Fragment {
  private static AttendanceFragment instance = null;

  public static AttendanceFragment newInstance() {
    if (instance == null) {
      // new instance
      instance = new AttendanceFragment();
      // sets data to bundle
      Bundle bundle = new Bundle();
      //bundle.putSerializable("CARDS", cards);

      // set data to fragment
      instance.setArguments(bundle);
      return instance;
    } else {
      return instance;
    }
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(getString(R.string.app_name) + " | " + getString(R.string.title_attendance));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_attendance, container, false);
  }
}
