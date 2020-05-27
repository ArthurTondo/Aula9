package com.example.exercicioaula5;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity{
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.meumenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.Lista:
                Intent intent = new Intent(this, Nomes.class);
                startActivity(intent);
                return true;
        }
        return false;
    }


}
