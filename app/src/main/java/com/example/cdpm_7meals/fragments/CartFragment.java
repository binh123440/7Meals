package com.example.cdpm_7meals.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.activities.PaymentActivity;
import com.example.cdpm_7meals.activities.ViewHistory;
import com.example.cdpm_7meals.adapters.CartAdapter;
import com.example.cdpm_7meals.components.ButtonComponent;
import com.example.cdpm_7meals.components.ListViewComponent;
import com.example.cdpm_7meals.data.TestData;
import com.example.cdpm_7meals.models.CartItem;
import com.example.cdpm_7meals.models.Currency;

public class CartFragment extends Fragment {

    private ListViewComponent listViewProduct;
    private TextView selectedItemTextView, deliveryFeeTextView, totalPriceTextView, subtotalPriceTextView;
    private ButtonComponent checkoutButton;
    private CartAdapter cartAdapter;
    private ImageButton btnHistory;

    public CartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        listViewProduct = view.findViewById(R.id.cartItems);
        selectedItemTextView = view.findViewById(R.id.selectedItems);
        deliveryFeeTextView = view.findViewById(R.id.deliveryFee);
        totalPriceTextView = view.findViewById(R.id.totalPrice);
        subtotalPriceTextView = view.findViewById(R.id.subtotalPrice);
        checkoutButton = view.findViewById(R.id.cartCheckoutBtn);
        btnHistory = view.findViewById(R.id.btn_history);

        // go to History page
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ViewHistory.class));
            }
        });

        initListView();

        changeToPayment();

        /* update ui when change quantity or delete */
        cartAdapter.setOnItemChangedListener(new CartAdapter.OnItemChangedListener() {
            @Override
            public void onItemChanged(int position) {
//                Toast.makeText(getContext(),"UPDATED", Toast.LENGTH_SHORT).show();
                prepareCheckout();
            }
        });

        prepareCheckout();

        return view;
    }

    private void changeToPayment() {
        checkoutButton.setOnClickListener(v -> {
            Intent paymentIntent = new Intent(getContext(), PaymentActivity.class);
            paymentIntent.putExtra("TOTAL_PRICE", subtotalPriceTextView.getText().toString());
            startActivity(paymentIntent);
        });
    }

    private void prepareCheckout() {
        int selectedItems = 0;
        double deliveryFee = 0;
        double totalPrice = 0;

        if (cartAdapter != null && cartAdapter.getCount() > 0) {
            for (CartItem item : cartAdapter.getCartItems()) {
                selectedItems += item.getQuantity();
                totalPrice += item.getQuantity() * item.getPrice();
                deliveryFee += item.getQuantity();
            }
            checkoutButton.setEnabled(true);
        } else {
            checkoutButton.setEnabled(false);
        }

        selectedItemTextView.setText("Selected items (" + String.valueOf(selectedItems) + ")");
        deliveryFeeTextView.setText(Currency.format(deliveryFee));
        totalPriceTextView.setText(Currency.format(totalPrice));
        subtotalPriceTextView.setText(Currency.format(deliveryFee + totalPrice));
    }

    private void initListView() {
        cartAdapter = new CartAdapter(getContext(), TestData.getCartItems());
        listViewProduct.setAdapter(cartAdapter);
        listViewProduct.setFullHeight();
    }
}