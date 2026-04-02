package ai.palsoft.androidcourse;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ai.palsoft.androidcourse.Classes.Contact;
import ai.palsoft.androidcourse.dataAccess.ContactDA;

public class MainActivity extends AppCompatActivity {
    private ListView lvContacts;
    private ArrayAdapter<Contact> contactsAdapter;
    private SearchView svContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        loadContacts();
        lvListener();
        searchListener();

    }

    public void initViews(){
        lvContacts = findViewById(R.id.lvContacts);
        svContact = findViewById(R.id.svContact);
    }

    public void searchListener(){
        svContact.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                contactsAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
    public void loadContacts(){
        ContactDA contactDA = new ContactDA();
        contactsAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                contactDA.getContactsList()
        );
        lvContacts.setAdapter(contactsAdapter);
    }

    public void lvListener(){
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectedContact = (Contact) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        "Contact Name : " + selectedContact.getName()+
                                "\nContact Phone: " + selectedContact.getPhoneNo(),
                        Toast.LENGTH_SHORT).show();
            }

        });


    }
}