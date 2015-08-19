package com.xjc.admin.fragmentdialogdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements EditNameFragment.EditNameDialogListener {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.lbl_txt);

        showEditDialog();
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        EditNameFragment editNameFragment = new EditNameFragment();
        editNameFragment.show(fm, "fragment_edit_name");
    }

    @Override
    public void onFinishEditDialog(String text) {
        Toast.makeText(this, "Hi, " + text, Toast.LENGTH_LONG).show();
        mTextView.setText(text);
    }
}
