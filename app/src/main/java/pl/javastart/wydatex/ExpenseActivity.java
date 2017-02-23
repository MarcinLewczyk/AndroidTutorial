package pl.javastart.wydatex;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpenseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        Button newExpenseButton = (Button) findViewById(R.id.add_expense);
        newExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
