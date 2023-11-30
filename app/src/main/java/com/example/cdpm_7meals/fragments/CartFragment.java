package com.example.cdpm_7meals.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.activities.PaymentActivity;
import com.example.cdpm_7meals.activities.ViewHistory;
import com.example.cdpm_7meals.adapters.CartAdapter;
import com.example.cdpm_7meals.components.ButtonComponent;
import com.example.cdpm_7meals.components.ListViewComponent;
import com.example.cdpm_7meals.data.TestData;
import com.example.cdpm_7meals.models.CartItem;
import com.example.cdpm_7meals.models.Currency;
import com.example.cdpm_7meals.models.ItemCart;
import com.example.cdpm_7meals.models.ShoppingCart;
import com.example.cdpm_7meals.models.ShoppingCartSingleton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.util.List;

public class CartFragment extends Fragment {

    private ListViewComponent listViewProduct;
    private TextView selectedItemTextView, deliveryFeeTextView, totalPriceTextView, subtotalPriceTextView;
    private ButtonComponent checkoutButton;
    private CartAdapter cartAdapter;
    private ImageButton btnHistory;
    ShoppingCart shoppingCart;
    View view;
    double tongtien;
    public CartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);

        listViewProduct = view.findViewById(R.id.cartItems);
        selectedItemTextView = view.findViewById(R.id.selectedItems);
        deliveryFeeTextView = view.findViewById(R.id.deliveryFee);
        totalPriceTextView = view.findViewById(R.id.totalPrice);
        subtotalPriceTextView = view.findViewById(R.id.subtotalPrice);
        checkoutButton = view.findViewById(R.id.cartCheckoutBtn);
        btnHistory = view.findViewById(R.id.btn_history);
        shoppingCart = ShoppingCartSingleton.getInstance().getShoppingCart();
        tongtien = shoppingCart.getCountItemCart();
        TextView txttongtien = view.findViewById(R.id.totalPrice);
        TextView subTotal = view.findViewById(R.id.subtotalPrice);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien));
        subTotal.setText(decimalFormat.format(tongtien));
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
//        cartAdapter.setOnItemChangedListener(new CartAdapter.OnItemChangedListener() {
//            @Override
//            public void onItemChanged(int position) {
////                Toast.makeText(getContext(),"UPDATED", Toast.LENGTH_SHORT).show();
//                prepareCheckout();
//            }
//        });
//
//        prepareCheckout();
//
        return view;
    }



//    private void prepareCheckout() {
//        int selectedItems = 0;
//        double deliveryFee = 0;
//        double totalPrice = 0;
//
//        if (cartAdapter != null && cartAdapter.getCount() > 0) {
//            for (CartItem item : cartAdapter.getCartItems()) {
//                selectedItems += item.getQuantity();
//                totalPrice += item.getQuantity() * item.getPrice();
//                deliveryFee += item.getQuantity();
//            }
//            checkoutButton.setEnabled(true);
//        } else {
//            checkoutButton.setEnabled(false);
//        }
//
//        selectedItemTextView.setText("Selected items (" + String.valueOf(selectedItems) + ")");
//        deliveryFeeTextView.setText(Currency.format(deliveryFee));
//        totalPriceTextView.setText(Currency.format(totalPrice));
//        subtotalPriceTextView.setText(Currency.format(deliveryFee + totalPrice));
//    }

    private void initListView() {
        List<ItemCart> arrayList = shoppingCart.getCartItems();
        cartAdapter = new CartAdapter(getActivity(),arrayList);
        listViewProduct.setAdapter(cartAdapter);
        listViewProduct.setFullHeight();
        cartAdapter.notifyDataSetChanged();
    }
    private void changeToPayment() {
        checkoutButton.setOnClickListener(v -> {
            List<ItemCart> arrayList = shoppingCart.getCartItems();
            Intent paymentIntent = new Intent(getContext(), PaymentActivity.class);
            paymentIntent.putExtra("TOTAL_PRICE", subtotalPriceTextView.getText().toString());
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Cart");
            myRef.setValue(arrayList, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    Toast.makeText(getActivity(), "Push data success", Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(paymentIntent);
        });
    }
}