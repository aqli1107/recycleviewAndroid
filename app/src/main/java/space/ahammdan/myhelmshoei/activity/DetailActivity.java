package space.ahammdan.myhelmshoei.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import space.ahammdan.myhelmshoei.R;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_FEATURE = "extra_feature";

    ImageView img_helm;
    TextView name_helm, price_helm, feature_helm;
    Button btn_buy, btn_cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final String photo = getString(EXTRA_PHOTO);
        final String name = getString(EXTRA_NAME);
        final String price = getString(EXTRA_PRICE);
        final String feature = getString(EXTRA_FEATURE);

        img_helm = findViewById(R.id.img_helm);
        name_helm = findViewById(R.id.name_helm);
        price_helm = findViewById(R.id.price_helm);
        feature_helm = findViewById(R.id.feature_helm);
        btn_cart = findViewById(R.id.btn_cart);
        btn_buy = findViewById(R.id.btn_buy);



        Glide.with(this).load(photo)
                .apply(new RequestOptions().override(550,550))
                .into(img_helm);
        name_helm.setText(name);
        price_helm.setText(price);
        feature_helm.setText(feature);

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this,CheckoutActivity.class);
                i.putExtra(CheckoutActivity.EXTRA_PHOTO, photo);
                i.putExtra(CheckoutActivity.EXTRA_NAME, name);
                i.putExtra(CheckoutActivity.EXTRA_PRICE, price);
                i.putExtra(CheckoutActivity.EXTRA_FEATURE, feature);
                startActivity(i);
            }
        });

    }

    private String getString(String s) { return getIntent().getStringExtra(s);}
}
