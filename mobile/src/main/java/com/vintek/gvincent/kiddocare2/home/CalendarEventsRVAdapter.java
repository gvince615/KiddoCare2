package com.vintek.gvincent.kiddocare2.home;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.florent37.singledateandtimepicker.dialog.DoubleDateAndTimePickerDialog;
import com.vintek.gvincent.kiddocare2.R;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.joda.time.LocalDate;

/**
 * Created by gvincent on 4/14/17.
 */

class CalendarEventsRVAdapter extends RecyclerView.Adapter<CalendarEventsRVAdapter.EventsViewHolder> {

  private final Context context;
  List<CalendarEventsData> cards;

  CalendarEventsRVAdapter(Context context, List<CalendarEventsData> cards){
    this.cards = cards;
    this.context = context;
  }

  @Override public EventsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calendar_event_layout, viewGroup, false);
    EventsViewHolder holder = new EventsViewHolder(v);
    return holder;
  }

  @Override public void onBindViewHolder(final EventsViewHolder holder, final int position) {
    holder.cv.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        holder.editButton.setVisibility(View.VISIBLE);
      }
    });

    holder.editButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        showEditCalendarEventDialog(cards.get(position));
        holder.editButton.setVisibility(View.INVISIBLE);
      }
    });

    holder.eventImage.setImageResource(cards.get(position).getEventImage());
    holder.eventTitle.setText(cards.get(position).getEventTitle());
    holder.eventDescription.setText(cards.get(position).getEventDescription());
    holder.eventStartTime.setText(cards.get(position).getEventStartDateTime().toString());
    holder.eventEndTime.setText(cards.get(position).getEventEndDateTime().toString());
  }

  void showEditCalendarEventDateTimeDialog() {
    // custom dialog
    final Date now = new Date();
    final Calendar calendarMin = Calendar.getInstance();
    final Calendar calendarMax = Calendar.getInstance();

    calendarMin.setTime(
        new Date(now.getTime() - TimeUnit.DAYS.toMillis(150))); // Set min now - 150 days
    calendarMax.setTime(
        new Date(now.getTime() + TimeUnit.DAYS.toMillis(150))); // Set max now + 150 days

    final Date minDate = calendarMin.getTime();
    final Date maxDate = calendarMax.getTime();

    DoubleDateAndTimePickerDialog.Builder doubleBuilder =
        new DoubleDateAndTimePickerDialog.Builder(context).backgroundColor(
            ResourcesCompat.getColor(context.getResources(), R.color.colorWhite, null))
            .mainColor(
                ResourcesCompat.getColor(context.getResources(), R.color.kiddoCareLogoTextColor,
                    null))
            .titleTextColor(
                ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null))
            .minutesStep(15)
            .minDateRange(minDate)
            .maxDateRange(maxDate)
            .tab0Date(now)
            .tab1Date(new Date(now.getTime() + TimeUnit.HOURS.toMillis(1)))
            .mustBeOnFuture()
            .title("Set Start and End dates")
            .tab0Text("Start")
            .tab1Text("End")
            .buttonOkText("Set Dates")
            .listener(new DoubleDateAndTimePickerDialog.Listener() {
              @Override public void onDateSelected(List<Date> dates) {
                showEditCalendarEventDialog(new CalendarEventsData(EventType.CHILD_SCHEDULED, "",
                    LocalDate.fromDateFields(dates.get(0)),
                    LocalDate.fromDateFields(dates.get(1))));
              }
            });
    doubleBuilder.display();
  }

  private void showEditCalendarEventDialog(final CalendarEventsData calendarEventsData) {

    final Dialog dialog = new Dialog(context);
    dialog.setContentView(R.layout.calendar_event_dialog);
    dialog.setTitle("Title...");
    Button cancelButton = (Button) dialog.findViewById(R.id.dialog_cancel);
    Button saveButton = (Button) dialog.findViewById(R.id.dialog_save);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        cards.add(calendarEventsData);
        notifyDataSetChanged();
        dialog.dismiss();
      }
    });

    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        dialog.dismiss();
      }
    });

    dialog.show();
  }

  @Override
  public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @Override public int getItemCount() {
    return cards.size();
  }

  public static class EventsViewHolder extends RecyclerView.ViewHolder {
    CardView cv;

    LinearLayout infoLayout;
    ImageView eventImage;
    TextView eventTitle;
    TextView eventDescription;
    TextView eventStartTime;
    TextView eventEndTime;
    ImageButton editButton;

    EventsViewHolder(View itemView) {
      super(itemView);
      cv = (CardView)itemView.findViewById(R.id.eventDataCardView);

      infoLayout = (LinearLayout) itemView.findViewById(R.id.infoLayout);
      eventImage = (ImageView)itemView.findViewById(R.id.eventImage);
      eventTitle = (TextView)itemView.findViewById(R.id.eventTitle);
      eventDescription = (TextView)itemView.findViewById(R.id.eventDescription);
      eventStartTime = (TextView)itemView.findViewById(R.id.eventStartTime);
      eventEndTime = (TextView)itemView.findViewById(R.id.eventEndTime);
      editButton = (ImageButton)itemView.findViewById(R.id.editButton);

    }
  }
}
