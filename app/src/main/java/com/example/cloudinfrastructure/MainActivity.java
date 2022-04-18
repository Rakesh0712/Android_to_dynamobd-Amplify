package com.example.cloudinfrastructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.query.Where;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Cryptocycles;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String uid = "a5e9f2d3-2eae-465d-85df-7577906bc876";
    private String str= "Row not created";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDB();



        Button initialize = (Button) findViewById(R.id.init);
        initialize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeDB();
            }
        });

        EditText username= (EditText) findViewById(R.id.create);
        Button create = (Button) findViewById(R.id.crt);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = create(username.getText().toString());
            }
        });

        EditText updateVal = (EditText) findViewById(R.id.val);
        Button update = (Button) findViewById(R.id.updt);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                update(updateVal.getText().toString());
            }
        });

        TextView data = (TextView) findViewById(R.id.data);
        Button pulldata = (Button) findViewById(R.id.rtrv);
        pulldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query();
                Toast toast = Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG);
                toast.show();

            }
        });

    }



    public void initializeDB(){
        try {
            Amplify.addPlugin(new AWSApiPlugin()); // UNCOMMENT this line once backend is deployed
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
            Log.i("Amplify", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("Amplify", "Could not initialize Amplify", error);

        }
    }

    public String create(String userName){
        String id;
        Cryptocycles item = Cryptocycles.builder()
            .username(userName)
           // .password(1020)
          //  .cyclestatus(true)
          //  .testfield("Lorem ipsum dolor sit amet")
            .build();
        Amplify.DataStore.save(
                item,
                success -> Log.i("Amplify", "Saved item: " + success.item().getId()),
                error -> Log.e("Amplify", "Could not save item to DataStore", error)
        );
       id=item.getId().toString();
        Toast toast = Toast.makeText(getApplicationContext(),"Id: " + item.getId() + " Username: " + item.getUsername() + " test field value: " + item.getTestfield(),Toast.LENGTH_LONG);
                       toast.show();
                       return id;
    }

    public void update(String value){
        Cryptocycles updatedItem =Cryptocycles.builder()
                .username("Luffy")
                .id("a5e9f2d3-2eae-465d-85df-7577906bc876")
              //  .cyclestatus()
              //  .password()
                .testfield(value)
                .build();

        Amplify.DataStore.save(
                updatedItem,
                success -> Log.i("Amplify", "Item updated: " + success.item().getId()),
                error -> Log.e("Amplify", "Could not save item to DataStore", error)
        );
    }


    public void queryid(){
        String st;
        Cryptocycles item = Cryptocycles.builder()
                .username("Luffy")
                .id("a5e9f2d3-2eae-465d-85df-7577906bc876")
                // .password(1020)
                //  .cyclestatus(true)
                //  .testfield("Lorem ipsum dolor sit amet")
                .build();
        Amplify.DataStore.query(
                Cryptocycles.class,
                Where.id("a5e9f2d3-2eae-465d-85df-7577906bc876"),
                items -> {
                    if (items.hasNext()) {
                        items.next();
                        Log.i("Amplify", "Id: " + item.getId() + " Username: " + item.getUsername() + " test field value: " + item.getTestfield());
//                       Toast toast = Toast.makeText(getApplicationContext(),"Id: " + item.getId() + " Username: " + item.getUsername() + " test field value: " + item.getTestfield(),Toast.LENGTH_LONG);
//                        toast.show();
                    }
                },
                failure -> Log.e("Amplify", "Could not query DataStore", failure)

        );
       // st = item.getId();
        Toast toast = Toast.makeText(getApplicationContext(),"Id: " + item.getId() + " Username: " + item.getUsername() + " test field value: " + item.getTestfield(),Toast.LENGTH_LONG);
        toast.show();
        }

        public void query(){
            ArrayList<String> mylist = new ArrayList<String>();
            mylist.add("hey");
        String[] vals = {"hi","Hello"};
            Amplify.DataStore.query(
                    Cryptocycles.class,
                    items -> {
                        while (items.hasNext()) {
                            Cryptocycles item = items.next();
                            Log.i("Amplify", "Id " + item.getId());
                           

                        }
                    },
                    failure -> Log.e("Amplify", "Could not query DataStore", failure)
            );
            String s = mylist.get(1);
            Toast toast = Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG);
            toast.show();
        }

}