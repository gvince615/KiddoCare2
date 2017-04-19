package com.vintek.gvincent.kiddocare2.home;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.vintek.gvincent.kiddocare2.R;
import java.util.List;

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

  @Override public void onBindViewHolder(final EventsViewHolder holder, int position) {
    holder.cv.setOnLongClickListener(new View.OnLongClickListener() {
      @Override public boolean onLongClick(View v) {

        holder.editButton.setVisibility(View.VISIBLE);
        return false;
      }
    });

    holder.editButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {


        showEditCalendarEventDialog();
      }
    });

    holder.eventImage.setImageResource(cards.get(position).getEventImage());
    holder.eventTitle.setText(cards.get(position).getEventTitle());
    holder.eventDescription.setText(cards.get(position).getEventDescription());
    holder.eventStartTime.setText(cards.get(position).getEventStartDateTime().toString());
    holder.eventEndTime.setText(cards.get(position).getEventEndDateTime().toString());
  }

  void showEditCalendarEventDialog() {
    // custom dialog
    final Dialog dialog = new Dialog(context);
    dialog.setContentView(R.layout.edit_calendar_event_dialog);
    dialog.setTitle("Title...");

    // set the custom dialog components - text, image and button
    //TextView text = (TextView) dialog.findViewById(R.id.text);
    //text.setText("Android custom dialog example!");
    //ImageView image = (ImageView) dialog.findViewById(R.id.image);
    //image.setImageResource(R.mipmap.ic_launcher_new);

    Button dialogButton = (Button) dialog.findViewById(R.id.dialog_close);
    // if button is clicked, close the custom dialog
    dialogButton.setOnClickListener(new View.OnClickListener() {
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
