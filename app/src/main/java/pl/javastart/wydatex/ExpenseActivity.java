package pl.javastart.wydatex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ExpenseActivity extends Activity{

    private EditText titleEditText;
    private EditText priceEditText;
    private Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        categorySpinner = (Spinner) findViewById(R.id.expense_category);
        titleEditText = (EditText) findViewById(R.id.expense_name);
        priceEditText = (EditText) findViewById(R.id.expense_price);

        categorySpinner.setAdapter(new CategoryAdapter());

    }

    private void addNewExpense() {
        String title = titleEditText.getText().toString();
        double price = Double.parseDouble(priceEditText.getText().toString());
        ExpenseCategory category = (ExpenseCategory) categorySpinner.getSelectedItem();
        Expense expense = new Expense(title, price, category);
        ExpenseDatabase.addExpense(expense);
        finish();
    }

    private class CategoryAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return ExpenseCategory.values().length;
        }

        @Override
        public ExpenseCategory getItem(int position) {
            return ExpenseCategory.values()[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(android.R.layout.simple_spinner_item, null);
            }

            TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
            textView.setText(getItem(position).getName());
            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.expense_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item){
        switch (item.getItemId()){
            case R.id.save:
                addNewExpense();
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }
}
