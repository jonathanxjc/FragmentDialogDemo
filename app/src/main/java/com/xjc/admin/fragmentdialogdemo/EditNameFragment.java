package com.xjc.admin.fragmentdialogdemo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by admin on 2015/8/19.
 */
public class EditNameFragment extends DialogFragment implements TextView.OnEditorActionListener{

    public interface EditNameDialogListener{
        void onFinishEditDialog(String text);
    }

    private EditText mEditText;

    public EditNameFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_name, container, false);
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        getDialog().setTitle("Hello");

        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
        mEditText.setOnEditorActionListener(this);
        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (EditorInfo.IME_ACTION_DONE == actionId){
            EditNameDialogListener activty = (EditNameDialogListener) getActivity();
            activty.onFinishEditDialog(mEditText.getText().toString());
            this.dismiss();
            return true;
        }


        return false;
    }
}
