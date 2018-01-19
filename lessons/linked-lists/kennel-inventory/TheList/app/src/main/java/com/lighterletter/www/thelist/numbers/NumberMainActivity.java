package com.lighterletter.www.thelist.numbers;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lighterletter.www.thelist.R;
import com.lighterletter.www.thelist.databinding.ActivityNumberBinding;
import com.lighterletter.www.thelist.numbers.list.NumberLinkedList;

/**
 * This class uses data-binding to access references to its layout
 * <p>
 * To access data-binding capabilities in the IDE you must enable them in app:gradle and surround your main layout with <layout></layout>
 * When you sync the project android studio will auto-generate the a binding class based on your layout name which will give you access to your views.
 * <p>
 * This class does not make full use of binding as to not confuse new readers.
 * For more reading go to: https://developer.android.com/topic/libraries/data-binding/index.html
 * <p>
 * This project has already enabled data-binding.
 * <p>
 * This Activity uses the NumberLinkedList to add and remove numbers from a list shown to the user.
 */

public class NumberMainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityNumberBinding bind;
    private NumberLinkedList list = new NumberLinkedList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_number);
        initViews();
    }

    private void initViews() {
        bind.insertBeginningBtn.setOnClickListener(this);
        bind.insertEndBtn.setOnClickListener(this);
        bind.insertPositionBtn.setOnClickListener(this);
        bind.deletePositionBtn.setOnClickListener(this);
        bind.isEmptyBtn.setOnClickListener(this);
        bind.getSizeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert_beginning_btn:
                list.insertAtStart(getNumberFromEditText(bind.insertBeginningValue));
                break;
            case R.id.insert_end_btn:
                list.insertAtEnd(getNumberFromEditText(bind.insertEndVal));
                break;
            case R.id.insert_position_btn:
                int num = getNumberFromEditText(bind.insertPositionValue);
                int pos = getNumberFromEditText(bind.insertPositionPosition);
                if (pos <= 1 || pos > list.getSize()) {
                    makeToast("Invalid position\n");
                } else {
                    list.insertAtPos(num, pos);
                }
                break;
            case R.id.delete_position_btn:
                int p = getNumberFromEditText(bind.deletePositionPosition);
                if (p < 1 || p > list.getSize())
                    makeToast("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case R.id.is_empty_btn:
                setTextToTexView(bind.isEmptyTxtView, "Empty status = " + list.isEmpty());
                break;
            case R.id.get_size_btn:
                setTextToTexView(bind.getSizeTxtView, "Size = " + list.getSize() + " \n");
                break;
            default:
                makeToast("Wrong Entry \n ");
                break;
        }
                    /*  Display List  */
        String listString = list.display();
        setTextToTexView(bind.linkedList, listString);
    }

    private void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setTextToTexView(TextView editText, String message) {
        editText.setText(message);
    }

    @NonNull
    private int getNumberFromEditText(EditText editText) {
        return Integer.parseInt(editText.getText().toString());
    }

}
