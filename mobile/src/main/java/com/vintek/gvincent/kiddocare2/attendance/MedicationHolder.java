package com.vintek.gvincent.kiddocare2.attendance;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vintek.gvincent.kiddocare2.R;

public class MedicationHolder extends RecyclerView.ViewHolder {

  //private ImageView ivExample;
  private CardView cv;
  private TextView medicationTime;
  private TextInputLayout medicationDescription_label;
  private TextInputEditText medicationDescription;

  public MedicationHolder(View v) {
    super(v);
    cv = (CardView) itemView.findViewById(R.id.medicineDataCardView);

    //        cv.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                Snackbar.make(v, "Tapped a Medication Card", Snackbar.LENGTH_LONG)
    //                        .setAction("Action", null).show();
    //            }
    //        });

    medicationTime = (TextView) itemView.findViewById(R.id.et_medication_time);
    medicationDescription_label = (TextInputLayout) itemView.findViewById(R.id.tv_medicine_name);

    medicationDescription = (TextInputEditText) itemView.findViewById(R.id.et_medicine_name);
  }

  public CardView getCv() {
    return cv;
  }

  public void setCv(CardView cv) {
    this.cv = cv;
  }

  public TextView getMedicationTime() {
    return medicationTime;
  }

  public void setMedicationTime(TextView medicationTime) {
    this.medicationTime = medicationTime;
  }

  public TextInputLayout getMedicationDescription_label() {
    return medicationDescription_label;
  }

  public void setMedicationDescription_label(TextInputLayout medicationDescription_label) {
    this.medicationDescription_label = medicationDescription_label;
  }

  public EditText getMedicationDescription() {
    return medicationDescription;
  }

  public void setMedicationDescription(TextInputEditText medicationDescription) {
    this.medicationDescription = medicationDescription;
  }
}
