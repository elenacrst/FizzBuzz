package com.example.elena.fizzbuzz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Object> mResultsList;
    private RecyclerView mRecyclerView;
    private FizzBuzzAdapter mAdapter = new FizzBuzzAdapter();
    private EditText mInputEditText;
    private Button mButton;
    private long mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInputValid()){
                    bindList();
                    setupRecyclerView();
                }else{
                    mRecyclerView.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, getString(R.string.invalid_text),
                            Toast.LENGTH_LONG).show();
                }
                hideKeyboard();
                mInputEditText.clearFocus();

            }

        });
    }

    private void findViews(){
        mInputEditText = (EditText)findViewById(R.id.edit_text_input);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mButton = (Button) findViewById(R.id.display_results_button);
    }

    private boolean isInputValid(){
        if(mInputEditText.getText() == null || mInputEditText.getText().toString().length()==0)
            return false;
        try{
            mInput = Long.valueOf(mInputEditText.getText().toString());

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mInputEditText.getWindowToken(),0);
    }


    private void bindList(){
        mResultsList = new ArrayList<>();
        for (long i=1; i<= mInput; i++){
            if(i % 15 == 0){
                mResultsList.add("fizzbuzz");
            }else if(i%5 == 0){
                mResultsList.add("buzz");
            }else if(i%3 == 0){
                mResultsList.add("fizz");
            }else mResultsList.add(i);
        }
    }

    private void setupRecyclerView(){
        mRecyclerView.setVisibility(View.VISIBLE);
        mAdapter.setData(mResultsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }
}
