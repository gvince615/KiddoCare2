package com.vintek.gvincent.kiddocare2.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.github.gfranks.collapsible.calendar.CollapsibleCalendarView;
import com.github.gfranks.collapsible.calendar.model.CollapsibleState;
import com.vintek.gvincent.kiddocare2.DatabaseHandler;
import com.vintek.gvincent.kiddocare2.R;
import icepick.Icepick;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.LocalDate;

/**
 * Created by: gvincent on 4/14/17.
 */

public class HomeFragment extends Fragment implements CollapsibleCalendarView.Listener<Event>{

  // Format for output
  @SuppressLint("SimpleDateFormat") static SimpleDateFormat dateFormatter =
      new SimpleDateFormat("dd MMM yyyy hh:mm a");
  static ArrayList<CalendarEventsData> cards = new ArrayList<>();
  private static HomeFragment instance = null;
  CoordinatorLayout coordinatorLayout;
  CollapsibleCalendarView calendarView;
  CalendarEventsRVAdapter adapter;
  //2017-04-14 format from CCV
  @SuppressLint("SimpleDateFormat")
  SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd");
  private ImageButton calImageButton;
  private FloatingActionButton addEventFab;

  public static HomeFragment newInstance() {

    if (instance == null) {
      // new instance
      instance = new HomeFragment();
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

    getActivity().setTitle(getString(R.string.app_name) + " | " + getString(R.string.title_home));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    DatabaseHandler db = new DatabaseHandler(getContext());
    cards = (ArrayList<CalendarEventsData>) db.getAllCalendarEvents();
    db.close();

    return inflater.inflate(R.layout.fragment_home, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);
    addEventFab = (FloatingActionButton) view.findViewById(R.id.add_event_fab);
    addEventFab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        adapter.showEditCalendarEventDateTimeDialog();
        adapter.notifyDataSetChanged();
      }
    });
    calendarView = (CollapsibleCalendarView) view.findViewById(R.id.calendar);
    calendarView.setListener(this);

    calendarView.addEvents(getEvents());

    calImageButton = (ImageButton) view.findViewById(R.id.cal_button);
    calImageButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        updateArrow(calImageButton);
      }
    });
    setUpRecyclerView(view);
  }

  private void updateArrow(ImageButton calImageButton) {
    if (calendarView.getState().equals(CollapsibleState.WEEK)) {
      calImageButton.setImageResource(R.drawable.ic_arrow_up_bold_hexagon_outline_white_48dp);
    }else{
      calImageButton.setImageResource(R.drawable.ic_arrow_down_bold_hexagon_outline_white_48dp);
    }
    calendarView.toggle();
  }

  private List<Event> getEvents() {
    List<Event> events = new ArrayList<>();
    for (int i=0; i<20; i++) {
      events.add(new Event(System.currentTimeMillis() + (86400000 * i)));
    }
    return events;
  }

  private void setUpRecyclerView(View view) {

    RecyclerView calEventsRecyclerView = (RecyclerView) view.findViewById(R.id.cal_events);

    RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext());
    calEventsRecyclerView.setLayoutManager(llm);

    calEventsRecyclerView.setItemAnimator(new DefaultItemAnimator());

    adapter = new CalendarEventsRVAdapter(this.getContext(), cards);
    calEventsRecyclerView.setAdapter(adapter);
  }

  @Override public void onDateSelected(LocalDate localDate, List<Event> list) {

    // Parsing the date
    Date date = localDate.toDate();
    try {
      date = dateParser.parse(String.valueOf(date));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    // Printing the date

    Snackbar snackbar = Snackbar
        .make(coordinatorLayout, dateFormatter.format(date), Snackbar.LENGTH_LONG);
    snackbar.show();
  }

  @Override public void onMonthChanged(LocalDate localDate) {

  }

  @Override public void onHeaderClick() {
    updateArrow(calImageButton);
  }

  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Icepick.saveInstanceState(this, outState);
  }

}
