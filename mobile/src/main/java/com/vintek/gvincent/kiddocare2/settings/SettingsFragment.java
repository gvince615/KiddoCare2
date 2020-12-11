package com.vintek.gvincent.kiddocare2.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.vintek.gvincent.kiddocare2.R;

/**
 * Created by gvincent on 4/14/17.
 */

public class SettingsFragment extends Fragment {
  private static SettingsFragment instance = null;

  public static SettingsFragment newInstance() {
    if (instance == null) {
      // new instance
      instance = new SettingsFragment();
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
    getActivity().setTitle(getString(R.string.title_account_settings));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_settings, container, false);
  }
}
