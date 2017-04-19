package com.vintek.gvincent.kiddocare2.reports;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vintek.gvincent.kiddocare2.R;

/**
 * Created by gvincent on 4/14/17.
 */

public class ReportsFragment extends Fragment {
  public static ReportsFragment newInstance() {
    ReportsFragment fragment = new ReportsFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(getString(R.string.app_name) + " | " + getString(R.string.title_report));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_reports, container, false);
  }
}
