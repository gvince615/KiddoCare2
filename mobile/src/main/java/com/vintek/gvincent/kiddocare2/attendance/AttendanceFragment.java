package com.vintek.gvincent.kiddocare2.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vintek.gvincent.kiddocare2.R;
import java.util.ArrayList;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 * Created by: gvincent on 4/14/17.
 */

public class AttendanceFragment extends Fragment {
  static ArrayList<RegisteredChildrenData> cards = new ArrayList<>();
  private static AttendanceFragment instance = null;
  private CoordinatorLayout coordinatorLayout;
  private FloatingActionButton addChildFab;
  private RegisteredChildrenRVAdapter adapter;

  public static AttendanceFragment newInstance() {
    if (instance == null) {
      // new instance
      instance = new AttendanceFragment();
      // sets data to bundle
      Bundle bundle = new Bundle();
      bundle.putSerializable("CARDS", cards);
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

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);
    addChildFab = (FloatingActionButton) view.findViewById(R.id.add_child_fab);
    addChildFab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        openNewRegistrationActivity();
        adapter.notifyDataSetChanged();
      }
    });
    setUpRecyclerView(view);
  }

  private void openNewRegistrationActivity() {
    Intent intent = new Intent(getContext(), NewRegistrationScrollingActivity.class);
    startActivity(intent);
  }

  private void setUpRecyclerView(View view) {
    cards.clear();
    cards.add(new RegisteredChildrenData(R.drawable.boy2, "Jeremiah", "Vincent",
        AgeBracket.SCHOOL_AGE.name(), new LocalDate(), new LocalDateTime(), new LocalDateTime()));
    cards.add(new RegisteredChildrenData(R.drawable.girl2, "EmmaLeeAnne", "Vincent",
        AgeBracket.TODDLER.name(), new LocalDate(), new LocalDateTime(), new LocalDateTime()));

    RecyclerView registered_children_rv =
        (RecyclerView) view.findViewById(R.id.registered_children);

    RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext());
    registered_children_rv.setLayoutManager(llm);

    registered_children_rv.setItemAnimator(new DefaultItemAnimator());

    adapter = new RegisteredChildrenRVAdapter(this.getContext(), cards);
    registered_children_rv.setAdapter(adapter);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_attendance, container, false);
  }
}
