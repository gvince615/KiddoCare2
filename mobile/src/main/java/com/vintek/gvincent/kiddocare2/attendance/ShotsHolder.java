package com.vintek.gvincent.kiddocare2.attendance;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.vintek.gvincent.kiddocare2.R;

public class ShotsHolder extends RecyclerView.ViewHolder {

  private ImageView ivShotRecord;
  private CardView cv;
  private TextView fluShotDate, immunizationDate;

  public ShotsHolder(View v) {
    super(v);
    cv = (CardView) itemView.findViewById(R.id.medicalDataCardView);

    //        cv.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                Snackbar.make(v, "Tapped a Medical Card", Snackbar.LENGTH_LONG)
    //                        .setAction("Action", null).show();
    //            }
    //        });
    ivShotRecord = (ImageView) itemView.findViewById(R.id.iv_shot_record);
    fluShotDate = (TextView) itemView.findViewById(R.id.et_flu_shot_date);
    immunizationDate = (TextView) itemView.findViewById(R.id.et_immunization_date);
  }

  public CardView getCv() {
    return cv;
  }

  public void setCv(CardView cv) {
    this.cv = cv;
  }

  public TextView getFluShotDate() {
    return fluShotDate;
  }

  public void setFluShotDate(TextView fluShotDate) {
    this.fluShotDate = fluShotDate;
  }

  public TextView getImmunizationDate() {
    return immunizationDate;
  }

  public void setImmunizationDate(TextView immunizationDate) {
    this.immunizationDate = immunizationDate;
  }

  public ImageView getIvShotRecord() {
    return ivShotRecord;
  }

  public void setIvShotRecord(ImageView ivShotRecord) {
    this.ivShotRecord = ivShotRecord;
  }
}
