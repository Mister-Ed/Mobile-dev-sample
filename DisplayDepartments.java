/*
 * @author: Mister Ed
 * For: Final Project Part 1
 * Course:
 * Date: February 2016
 *
 * Displays list of departments in Acme store.
 *
 * Departments are fixed or hard coded list in content_display_departments.xml
 *
 * Lists of Departments would be displayed from database call and looping through the result set
 * or looping through an static/fixed array in the real product.
 *
 * Bottom two rows of icons would have text under each one, if more time.
 *
 * See content XML files for additional comments
 *
 */

package pixelmode.mister.ed;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DisplayDepartments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Override drawer slider, now becomes a back button at same location that MainActivity.java displays
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_departments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Search", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        // controls the back button tap action and drawer activity
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the department name buttons */
    public void viewProductsByDepartment(View view) {
        Intent intent = new Intent(this, DisplayDepartmentsProducts.class);
        startActivity(intent);
    }

    /** Called when the user clicks the 'refine search bar / spy glass' button */
    public void viewProductSearch(View view) {
        Intent intent = new Intent(this, DisplayProductSearch.class);
        startActivity(intent);
    }

}
