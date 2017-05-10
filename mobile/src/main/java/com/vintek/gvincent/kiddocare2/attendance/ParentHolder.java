package com.vintek.gvincent.kiddocare2.attendance;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import com.vintek.gvincent.kiddocare2.R;

public class ParentHolder extends RecyclerView.ViewHolder {

  private CardView cv;
  private TextInputEditText parentFirstName, parentLastName, parentAddressLn1, parentAddressLn2,
      parentAddressCity, parentAddressState, parentAddressZip, parentEmail, parentPhoneNumber;
  private TextInputLayout parentFirstName_layout, parentLastName_layout, parentAddressLn1_layout,
      parentAddressLn2_layout, parentAddressCity_layout, parentAddressState_layout,
      parentAddressZip_layout, parentPhone_number_layout, parentEmail_layout;
  private CheckBox isAddressSameAsChild;
  private Spinner guardianType;

  public ParentHolder(View v) {
    super(v);
    cv = (CardView) itemView.findViewById(R.id.parentDataCardView);

    //        cv.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //
    //                Snackbar.make(v, "Tapped a Parent Card", Snackbar.LENGTH_LONG)
    //                        .setAction("Action", null).show();
    //            }
    //        });

    guardianType = (Spinner) itemView.findViewById(R.id.spinner_guardian_type);
    parentFirstName_layout = (TextInputLayout) itemView.findViewById(R.id.tv_parentFname);
    parentLastName_layout = (TextInputLayout) itemView.findViewById(R.id.tv_parentLname);
    parentEmail_layout = (TextInputLayout) itemView.findViewById(R.id.tv_guardians_email_address);
    parentPhone_number_layout =
        (TextInputLayout) itemView.findViewById(R.id.tv_guardian_phone_number);

    isAddressSameAsChild = (CheckBox) itemView.findViewById(R.id.c_address_same_as_child);

    parentAddressLn1_layout =
        (TextInputLayout) itemView.findViewById(R.id.tv_et_guardian_address_ln_1_layout);
    parentAddressLn2_layout =
        (TextInputLayout) itemView.findViewById(R.id.tv_et_guardian_address_ln_2_layout);
    parentAddressCity_layout =
        (TextInputLayout) itemView.findViewById(R.id.tv_guardian_address_city_layout);
    parentAddressState_layout =
        (TextInputLayout) itemView.findViewById(R.id.tv_guardian_address_state_layout);
    parentAddressZip_layout =
        (TextInputLayout) itemView.findViewById(R.id.tv_child_address_zip_layout);

    parentFirstName = (TextInputEditText) itemView.findViewById(R.id.et_parentFname);
    parentLastName = (TextInputEditText) itemView.findViewById(R.id.et_parentLname);
    parentAddressLn1 = (TextInputEditText) itemView.findViewById(R.id.et_guardian_address_ln_1);
    parentAddressLn2 = (TextInputEditText) itemView.findViewById(R.id.et_guardian_address_ln_2);
    parentEmail = (TextInputEditText) itemView.findViewById(R.id.et_guardians_email_address);
    parentPhoneNumber = (TextInputEditText) itemView.findViewById(R.id.et_guardian_phone_number);
    parentAddressCity = (TextInputEditText) itemView.findViewById(R.id.et_guardian_address_city);
    parentAddressState = (TextInputEditText) itemView.findViewById(R.id.et_guardian_address_state);
    parentAddressZip = (TextInputEditText) itemView.findViewById(R.id.et_guardian_address_zip);
  }

  public CardView getCv() {
    return cv;
  }

  public void setCv(CardView cv) {
    this.cv = cv;
  }

  public Spinner getGuardianType() {
    return guardianType;
  }

  public void setGuardianType(Spinner guardianType) {
    this.guardianType = guardianType;
  }

  public CheckBox getIsAddressSameAsChild() {
    return isAddressSameAsChild;
  }

  public void setIsAddressSameAsChild(CheckBox isAddressSameAsChild) {
    this.isAddressSameAsChild = isAddressSameAsChild;
  }

  public EditText getParentAddressLn2() {
    return parentAddressLn2;
  }

  public void setParentAddressLn2(TextInputEditText parentAddressLn2) {
    this.parentAddressLn2 = parentAddressLn2;
  }

  public TextInputLayout getParentAddressLn2_layout() {
    return parentAddressLn2_layout;
  }

  public void setParentAddressLn2_layout(TextInputLayout parentAddressLn2_layout) {
    this.parentAddressLn2_layout = parentAddressLn2_layout;
  }

  public EditText getParentFirstName() {
    return parentFirstName;
  }

  public void setParentFirstName(TextInputEditText parentFirstName) {
    this.parentFirstName = parentFirstName;
  }

  public EditText getParentLastName() {
    return parentLastName;
  }

  public void setParentLastName(TextInputEditText parentLastName) {
    this.parentLastName = parentLastName;
  }

  public EditText getParentAddressLn1() {
    return parentAddressLn1;
  }

  public void setParentAddressLn1(TextInputEditText parentAddressLn1) {
    this.parentAddressLn1 = parentAddressLn1;
  }

  public EditText getParentAddressCity() {
    return parentAddressCity;
  }

  public void setParentAddressCity(TextInputEditText parentAddressCity) {
    this.parentAddressCity = parentAddressCity;
  }

  public EditText getParentAddressState() {
    return parentAddressState;
  }

  public void setParentAddressState(TextInputEditText parentAddressState) {
    this.parentAddressState = parentAddressState;
  }

  public EditText getParentAddressZip() {
    return parentAddressZip;
  }

  public void setParentAddressZip(TextInputEditText parentAddressZip) {
    this.parentAddressZip = parentAddressZip;
  }

  public EditText getParentEmail() {
    return parentEmail;
  }

  public void setParentEmail(TextInputEditText parentEmail) {
    this.parentEmail = parentEmail;
  }

  public EditText getParentPhoneNumber() {
    return parentPhoneNumber;
  }

  public void setParentPhoneNumber(TextInputEditText parentPhoneNumber) {
    this.parentPhoneNumber = parentPhoneNumber;
  }

  public TextInputLayout getParentFirstName_layout() {
    return parentFirstName_layout;
  }

  public void setParentFirstName_layout(TextInputLayout parentFirstName_layout) {
    this.parentFirstName_layout = parentFirstName_layout;
  }

  public TextInputLayout getParentLastName_layout() {
    return parentLastName_layout;
  }

  public void setParentLastName_layout(TextInputLayout parentLastName_layout) {
    this.parentLastName_layout = parentLastName_layout;
  }

  public TextInputLayout getParentAddressLn1_layout() {
    return parentAddressLn1_layout;
  }

  public void setParentAddressLn1_layout(TextInputLayout parentAddressLn1_layout) {
    this.parentAddressLn1_layout = parentAddressLn1_layout;
  }

  public TextInputLayout getParentAddressCity_layout() {
    return parentAddressCity_layout;
  }

  public void setParentAddressCity_layout(TextInputLayout parentAddressCity_layout) {
    this.parentAddressCity_layout = parentAddressCity_layout;
  }

  public TextInputLayout getParentAddressState_layout() {
    return parentAddressState_layout;
  }

  public void setParentAddressState_layout(TextInputLayout parentAddressState_layout) {
    this.parentAddressState_layout = parentAddressState_layout;
  }

  public TextInputLayout getParentAddressZip_layout() {
    return parentAddressZip_layout;
  }

  public void setParentAddressZip_layout(TextInputLayout parentAddressZip_layout) {
    this.parentAddressZip_layout = parentAddressZip_layout;
  }

  public TextInputLayout getParentPhone_number_layout() {
    return parentPhone_number_layout;
  }

  public void setParentPhone_number_layout(TextInputLayout parentPhone_number_layout) {
    this.parentPhone_number_layout = parentPhone_number_layout;
  }

  public TextInputLayout getParentEmail_layout() {
    return parentEmail_layout;
  }

  public void setParentEmail_layout(TextInputLayout parentEmail_layout) {
    this.parentEmail_layout = parentEmail_layout;
  }

  //    public ImageView getImageView() {
  //        return ivExample;
  //    }
  //
  //    public void setImageView(ImageView ivExample) {
  //        this.ivExample = ivExample;
  //    }
}
