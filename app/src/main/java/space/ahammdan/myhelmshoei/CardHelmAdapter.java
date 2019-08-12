package space.ahammdan.myhelmshoei;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardHelmAdapter extends RecyclerView.Adapter<CardHelmAdapter.CardViewHolder> {

    private ArrayList<HelmShoei> listHelm;
    public CardHelmAdapter(ArrayList<HelmShoei> list) {
        this.listHelm = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_helm, viewGroup, false);
        return new CardHelmAdapter.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder cardViewHolder, int i) {
        final HelmShoei helmShoei = listHelm.get(i);
        Glide.with(cardViewHolder.itemView.getContext()).load(helmShoei.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(cardViewHolder.img_helm);

        cardViewHolder.name_helm.setText(helmShoei.getName());
        cardViewHolder.feature_helm.setText(helmShoei.getFeature());
        cardViewHolder.price_helm.setText(String.valueOf(helmShoei.getPrice()));

        cardViewHolder.btn_set_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cardViewHolder.itemView.getContext(), "Favorite "+helmShoei.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        cardViewHolder.btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cardViewHolder.itemView.getContext(), "Helm "+helmShoei.getName()+" buy!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHelm.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView img_helm;
        TextView name_helm, feature_helm, price_helm;
        Button btn_set_favorite,btn_buy;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            img_helm = itemView.findViewById(R.id.img_helm);
            name_helm = itemView.findViewById(R.id.name_helm);
            feature_helm = itemView.findViewById(R.id.feature_helm);
            price_helm = itemView.findViewById(R.id.price_helm);
        }
    }
}
