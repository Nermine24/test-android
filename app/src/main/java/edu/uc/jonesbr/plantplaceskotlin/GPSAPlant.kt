package edu.uc.jonesbr.plantplaceskotlin

import android.os.Bundle

import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import edu.uc.jonesbr.plantplaceskotlin.dto.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GPSAPlant : AppCompatActivity() {

    private var allSpecimens = ArrayList<SpecimenDTO>()

    private val navigasjonen =  BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.page_1 -> {
                Log.i("loghamzasucc", "page1");

                true
            }
            R.id.page_1 -> {
                Log.i("loghamzasucc", "page2");

                true
            }
            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpsaplant)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(navigasjonen)

        val service = RetrofitClientInstance.retrofitInstance?.create(GetPlantService::class.java)
        val call = service?.getAllMatches()
        val getAllTeamsCallback =  service?.getAllTeams()

        call?.enqueue(object : Callback<MatchList> {
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<MatchList>?, response: Response<MatchList>?) {

                val body = response?.body()

                Log.i("loghamzasucc", body.toString());
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<MatchList>?, t: Throwable?) {
                Log.i("loghamza", t.toString());

                Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_LONG).show()
            }

        })
        getAllTeamsCallback?.enqueue(object : Callback<TeamList> {
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<TeamList>?, response: Response<TeamList>?) {

                val body = response?.body()

                Log.i("teams", body.toString());
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<TeamList>?, t: Throwable?) {
                Log.i("loghamza", t.toString());

                Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_LONG).show()
            }

        })



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_gpsaplant, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
