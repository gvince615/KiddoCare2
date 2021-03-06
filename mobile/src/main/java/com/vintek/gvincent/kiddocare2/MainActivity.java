package com.vintek.gvincent.kiddocare2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
    transaction.commitNowAllowingStateLoss();
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
          default:
            selectedFragment = HomeFragment.newInstance();
            break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.content, selectedFragment);
        transaction.commitNowAllowingStateLoss();
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
