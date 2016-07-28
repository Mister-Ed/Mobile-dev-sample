/*
 * @author: Mister Ed
 * For: Final Project Part 1
 * Course:
 * Date: February 2016
 *
 * Displays products from selected department (simulated)
 *
 * Real product would access database for products from the department.
 * It would also display the the name of the department in the title.
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DisplayDepartmentsProducts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Override drawer slider, now becomes a back button at same location that MainActivity.java displays
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_departments_products);
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


    /** Called when the user clicks the department name buttons */
    public void addToCart(View view) {
        Intent intent = new Intent(this, ViewCart.class);
        startActivity(intent);
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
