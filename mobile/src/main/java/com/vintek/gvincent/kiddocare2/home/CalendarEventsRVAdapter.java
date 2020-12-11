package com.vintek.gvincent.kiddocare2.home;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.github.florent37.singledateandtimepicker.dialog.DoubleDateAndTimePickerDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.satsuware.usefulviews.LabelledSpinner;
import com.vintek.gvincent.kiddocare2.DatabaseHandler;
import com.vintek.gvincent.kiddocare2.R;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.joda.time.LocalDateTime;

import static com.vintek.gvincent.kiddocare2.home.HomeFragment.dateFormatter;

/**
 * Created by: gvincent on 4/14/17.
 */

class CalendarEventsRVAdapter extends RecyclerView.Adapter<CalendarEventsRVAdapter.EventsViewHolder> {

  private final Context context;
  private List<CalendarEventsData> cards;
  private int position;

  CalendarEventsRVAdapter(Context context, List<CalendarEventsData> cards){
    this.cards = cards;
    this.context = context;
  }

  @Override public EventsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calendar_event_layout, viewGroup, false);
    return new EventsViewHolder(v);
  }

  @Override public void onBindViewHolder(final EventsViewHolder holder, int position) {
    holder.cv.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        holder.editButton.setVisibility(View.VISIBLE);
      }
    });

    holder.editButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        showEditCalendarEventDialog(cards.get(holder.getAdapterPosition()).getEventStartDateTime(),
            cards.get(holder.getAdapterPosition()).getEventStartDateTime());

        holder.editButton.setVisibility(View.INVISIBLE);
      }
    });

    holder.eventImage.setImageResource(cards.get(position).getEventImage());
    holder.eventTitle.setText(cards.get(position).getEventTitle());
    holder.eventDescription.setText(cards.get(position).getEventDescription());

    LocalDateTime start = cards.get(position).getEventStartDateTime();
    String startStr = dateFormatter.format(start.toDate());

    LocalDateTime stop = cards.get(position).getEventEndDateTime();
    String stopStr = dateFormatter.format(stop.toDate());

    holder.eventStartTime.setText(startStr);
    holder.eventEndTime.setText(stopStr);

  }

  void showEditCalendarEventDateTimeDialog() {

    DoubleDateAndTimePickerDialog.Builder doubleBuilder = getDoubleDateandTimeDialog();
    doubleBuilder.display();
  }

  private DoubleDateAndTimePickerDialog.Builder getDoubleDateandTimeDialog() {

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

    return new DoubleDateAndTimePickerDialog.Builder(context).backgroundColor(
        ResourcesCompat.getColor(context.getResources(), R.color.colorWhite, null))
        .mainColor(
            ResourcesCompat.getColor(context.getResources(), R.color.kiddoCareLogoTextColor, null))
        .titleTextColor(
            ResourcesCompat.getColor(context.getResources(), R.color.colorWhite, null))
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

            showEditCalendarEventDialog(LocalDateTime.fromDateFields(dates.get(0)),
                LocalDateTime.fromDateFields(dates.get(1)));
          }
        });
  }

  private void showEditCalendarEventDialog(final LocalDateTime localDateTimeStart,
      final LocalDateTime localDateTimeEnd) {

    final Dialog dialog = new Dialog(context);
    dialog.setContentView(R.layout.calendar_event_dialog);
    dialog.setTitle("Title...");
    final TextInputLayout eventDescription =
        (TextInputLayout) dialog.findViewById(R.id.input_layout_description);
    final LabelledSpinner eventTypeSpinner =
        (LabelledSpinner) dialog.findViewById(R.id.event_type_spinner);

    eventTypeSpinner.setItemsArray(EventType.getEventTypes());
    eventTypeSpinner.setOnItemChosenListener(new LabelledSpinner.OnItemChosenListener() {
      @Override
      public void onItemChosen(View labelledSpinner, AdapterView<?> adapterView, View itemView,
          int position, long id) {

        if (position == 0) {
          eventDescription.setHint("Scheduled Child's Name");
        } else {
          eventDescription.setHint("Event Description");
        }
        eventDescription.setEnabled(true);
        setPosition(position);
      }

      @Override public void onNothingChosen(View labelledSpinner, AdapterView<?> adapterView) {
        eventDescription.setEnabled(false);
      }
    });

    final Button cancelButton = (Button) dialog.findViewById(R.id.dialog_cancel);
    Button saveButton = (Button) dialog.findViewById(R.id.dialog_save);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        EventType eventType = EventType.getEventType(getPosition());

        CalendarEventsData calendarEventsData =
            new CalendarEventsData(eventType.getType(), eventType.getImage(), eventType.getTitle(),
                eventDescription.getEditText().getText().toString(), localDateTimeStart,
                localDateTimeEnd);

        cards.add(calendarEventsData);
        DatabaseHandler db = new DatabaseHandler(context);
        db.addCalendarEvent(calendarEventsData);
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

  private int getPosition() {
    return this.position;
  }

  private void setPosition(int position) {
    this.position = position;
  }

  @Override
  public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @Override public int getItemCount() {
    return cards.size();
  }

  static class EventsViewHolder extends RecyclerView.ViewHolder {
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
