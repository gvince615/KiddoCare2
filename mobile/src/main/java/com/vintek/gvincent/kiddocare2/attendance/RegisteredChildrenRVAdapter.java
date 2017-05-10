package com.vintek.gvincent.kiddocare2.attendance;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.vintek.gvincent.kiddocare2.R;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * Created by: gvincent on 5/3/17
 */

class RegisteredChildrenRVAdapter
    extends RecyclerView.Adapter<RegisteredChildrenRVAdapter.EventsViewHolder> {

  private final Context context;
  private ArrayList<RegisteredChildrenData> cards;
  private int position;
  private Formatter dateFormatter;

  RegisteredChildrenRVAdapter(Context context, ArrayList<RegisteredChildrenData> cards) {
    this.cards = cards;
    this.context = context;
  }

  @Override
  public RegisteredChildrenRVAdapter.EventsViewHolder onCreateViewHolder(ViewGroup viewGroup,
      int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.attendance_child_data_card, viewGroup, false);
    return new RegisteredChildrenRVAdapter.EventsViewHolder(v);
  }

  @Override public void onBindViewHolder(final RegisteredChildrenRVAdapter.EventsViewHolder holder,
      int position) {
    holder.cv.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

      }
    });

    holder.childImage.setImageResource(cards.get(position).getChildImage());
    holder.childFirstName.setText(cards.get(position).getChildFirstName());
    holder.childLastName.setText(cards.get(position).getChildLastName());
    holder.childAgeBracket.setText(cards.get(position).getChildAgeBracket());
    holder.childDOB.setText(cards.get(position).getChildBirthDate().toString());
    holder.childClockIn.setText(cards.get(position).getChildClockIn().toString());
    holder.childClockOut.setText(cards.get(position).getChildClockOut().toString());
  }

  private int getPosition() {
    return this.position;
  }

  private void setPosition(int position) {
    this.position = position;
  }

  @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @Override public int getItemCount() {
    return cards.size();
  }

  static class EventsViewHolder extends RecyclerView.ViewHolder {
    private final ImageView childImage;
    private final TextView childFirstName;
    private final TextView childLastName;
    private final TextView childDOB;
    private final TextView childClockIn;
    private final TextView childAgeBracket;
    private final TextView childClockOut;
    CardView cv;

    EventsViewHolder(View itemView) {
      super(itemView);
      cv = (CardView) itemView.findViewById(R.id.childDataCardView);

      childImage = (ImageView) itemView.findViewById(R.id.childImage);
      childFirstName = (TextView) itemView.findViewById(R.id.childFirstName);
      childLastName = (TextView) itemView.findViewById(R.id.childLastName);
      childDOB = (TextView) itemView.findViewById(R.id.childDOB);
      childClockIn = (TextView) itemView.findViewById(R.id.childClockIn);
      childAgeBracket = (TextView) itemView.findViewById(R.id.childAgeBracket);
      childClockOut = (TextView) itemView.findViewById(R.id.childClockOut);
    }
  }
}