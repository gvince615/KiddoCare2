package com.vintek.gvincent.kiddocare2.home;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.github.gfranks.collapsible.calendar.CollapsibleCalendarView;
import com.github.gfranks.collapsible.calendar.model.CollapsibleState;
import com.vintek.gvincent.kiddocare2.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.LocalDate;

/**
 * Created by gvincent on 4/14/17.
 */

public class HomeFragment extends Fragment implements CollapsibleCalendarView.Listener<Event>{

  CoordinatorLayout coordinatorLayout;
  CollapsibleCalendarView calendarView;
  CalendarEventsRVAdapter adapter;

  ArrayList<CalendarEventsData> cards = new ArrayList<>();

  //2017-04-14 format from CCV
  @SuppressLint("SimpleDateFormat")
  SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd");
  // Format for output
  @SuppressLint("SimpleDateFormat")
  SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy");

  public static HomeFragment newInstance() {
    HomeFragment fragment = new HomeFragment();

    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(getString(R.string.app_name) + " | " + getString(R.string.title_home));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_home, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);


    coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);
    calendarView = (CollapsibleCalendarView) view.findViewById(R.id.calendar);
    calendarView.setListener(this);
    calendarView.addEvents(getEvents());
    final ImageButton calImageButton = (ImageButton) view.findViewById(R.id.cal_button);
    calImageButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        if (calendarView.getState().equals(CollapsibleState.WEEK)){
          calImageButton.setImageResource(R.drawable.ic_arrow_up_bold_hexagon_outline_white_48dp);
        }else{
          calImageButton.setImageResource(R.drawable.ic_arrow_down_bold_hexagon_outline_white_48dp);
        }
        calendarView.toggle();
      }
    });


    Configuration config = getResources().getConfiguration();
    if (config.orientation == Configuration.ORIENTATION_LANDSCAPE){
      calendarView.toggle();
    }else{

    }
    setUpRecyclerView(view);
  }

  private List<Event> getEvents() {
    List<Event> events = new ArrayList<>();
    for (int i=0; i<20; i++) {
      events.add(new Event(System.currentTimeMillis() + (86400000 * i)));
    }
    return events;
  }

  private void setUpRecyclerView(View view) {

    cards.add(new CalendarEventsData(EventType.CHILD_SCHEDULED,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));
    cards.add(new CalendarEventsData(EventType.TRIP_SCHEDULED,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));
    cards.add(new CalendarEventsData(EventType.TODO_ITEM,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));
    cards.add(new CalendarEventsData(EventType.GENERIC_REMINDER,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));
    cards.add(new CalendarEventsData(EventType.CHILD_SCHEDULED,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));
    cards.add(new CalendarEventsData(EventType.TRIP_SCHEDULED,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));
    cards.add(new CalendarEventsData(EventType.TODO_ITEM,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));
    cards.add(new CalendarEventsData(EventType.GENERIC_REMINDER,
        "", calendarView.getSelectedDate(), calendarView.getSelectedDate()));

    RecyclerView calEventsRecyclerView = (RecyclerView) view.findViewById(R.id.cal_events);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      calEventsRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

        }
      });
    }

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
    System.out.println(dateFormatter.format(date));

    Snackbar snackbar = Snackbar
        .make(coordinatorLayout, dateFormatter.format(date), Snackbar.LENGTH_LONG);
    snackbar.show();
  }

  @Override public void onMonthChanged(LocalDate localDate) {

  }

  @Override public void onHeaderClick() {
    calendarView.toggle();
  }
}
