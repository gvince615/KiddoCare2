package com.vintek.gvincent.kiddocare2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.vintek.gvincent.kiddocare2.attendance.AttendanceFragment;
import com.vintek.gvincent.kiddocare2.home.HomeFragment;
import com.vintek.gvincent.kiddocare2.meal.MealsFragment;
import com.vintek.gvincent.kiddocare2.reports.ReportsFragment;
import com.vintek.gvincent.kiddocare2.settings.SettingsFragment;
import net.danlew.android.joda.JodaTimeAndroid;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    JodaTimeAndroid.init(this);
    setContentView(R.layout.activity_main);

    setupNavigation();
    setupActionBar();



    //Manually displaying the first fragment - one time only
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.content, HomeFragment.newInstance());
    transaction.commit();

    //Used to select an item programmatically
    //bottomNavigationView.getMenu().getItem(2).setChecked(true);
  }



  private void setupActionBar() {
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setLogo(R.mipmap.ic_launcher_new);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
  }

  private void setupNavigation() {
    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
          case R.id.navigation_home:
            selectedFragment = HomeFragment.newInstance();
            break;
          case R.id.navigation_attendance:
            selectedFragment = AttendanceFragment.newInstance();
            break;
          case R.id.navigation_meals:
            selectedFragment = MealsFragment.newInstance();
            break;
          case R.id.navigation_reports:
            selectedFragment = ReportsFragment.newInstance();
            break;
          case R.id.navigation_settings:
            selectedFragment = SettingsFragment.newInstance();
            break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, selectedFragment);

        transaction.commit();
        return true;
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return true;
  }
}
