package com.lordblack.SuperBank.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lordblack.SuperBank.BankingTransactions;
import com.lordblack.SuperBank.MainActivity;
import com.lordblack.SuperBank.R;


public class Home extends Fragment
{
    int balance;
    String displayBalance;

    CardView FundTransfer;
    CardView transactionHistory;
    CardView billPayment;


    TextView AvailableBalance;
    BankingTransactions bankingTransactions;

    DatabaseReference databaseAmount;

    Fragment fragment;
    android.support.v4.app.FragmentManager fragmentManager;

    public Home()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getActivity().setTitle("Home");

        fragment = null;
        fragmentManager = getActivity().getSupportFragmentManager();;

        bankingTransactions = new BankingTransactions();

        FundTransfer = view.findViewById(R.id.fund_transfer);
        FundTransfer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                fragment = new FundTransfer();
                fragmentManager.beginTransaction().replace(R.id.mainContent,fragment).addToBackStack(fragment.getClass().getName()).commit();
            }
        });

        transactionHistory = view.findViewById(R.id.transactionHistoryCard);
        transactionHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                fragment = new TransactionHistory();
                fragmentManager.beginTransaction().replace(R.id.mainContent,fragment).addToBackStack(fragment.getClass().getName()).commit();
            }
        });



        billPayment = view.findViewById(R.id.billPaymentCard);
        billPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                fragment = new BillPayment();
                fragmentManager.beginTransaction().replace(R.id.mainContent,fragment).addToBackStack(fragment.getClass().getName()).commit();
            }
        });



        AvailableBalance = view.findViewById(R.id.currentBalance);

        databaseAmount = FirebaseDatabase.getInstance().getReference("Amount");

        databaseAmount.child(((MainActivity)getActivity()).UserID).child("amount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null)
                {
                    balance = (int) (long) dataSnapshot.getValue();
                    displayBalance = Integer.toString(balance);

                    AvailableBalance.setText("$"+displayBalance);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

}
