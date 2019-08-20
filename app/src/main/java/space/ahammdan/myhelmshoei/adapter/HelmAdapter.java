package space.ahammdan.myhelmshoei.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import space.ahammdan.myhelmshoei.R;
import space.ahammdan.myhelmshoei.activity.DetailActivity;
import space.ahammdan.myhelmshoei.model.HelmShoei;

public class HelmAdapter extends RecyclerView.Adapter<HelmAdapter.ViewHolder> {

    private ArrayList<HelmShoei> listHelm;

    private Context context;

    public HelmAdapter(ArrayList<HelmShoei> list, Context context)
    {
        this.listHelm = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_helm, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        HelmShoei helmShoei = listHelm.get(i);
        Glide.with(viewHolder.itemView.getContext()).load(helmShoei.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(viewHolder.img_helm);

        viewHolder.name_helm.setText(helmShoei.getName());
        viewHolder.feature_helm.setText(helmShoei.getFeature());
        viewHolder.price_helm.setText(String.valueOf(helmShoei.getPrice()));
        viewHolder.tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveintent = new Intent(context, DetailActivity.class);
                context.startActivity(moveintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listHelm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_helm;
        TextView name_helm, feature_helm, price_helm;
        RelativeLayout tap;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_helm = itemView.findViewById(R.id.img_helm);
            name_helm = itemView.findViewById(R.id.name_helm);
            feature_helm = itemView.findViewById(R.id.feature_helm);
            price_helm = itemView.findViewById(R.id.price_helm);
            tap = itemView.findViewById(R.id.tap);
        }
    }
}
