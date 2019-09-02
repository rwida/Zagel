package com.app.zagel_;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.util.ArrayList;
import java.util.Date;

public class dbAdapter extends RecyclerView.Adapter<dbAdapter.DbViewHolder> {


    ArrayList<DBmodel> objectModelArraylist;
    Context mContext;


    public dbAdapter(ArrayList<DBmodel> objectModelArraylist, Context mContext) {
        this.objectModelArraylist = objectModelArraylist;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public DbViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View singleRow = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerow,viewGroup,false);


        return new DbViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final DbViewHolder dbViewHolder, final int position) {
        final DBmodel objectModel = objectModelArraylist.get(position);
        dbViewHolder.imageView.setImageBitmap(objectModel.getOurImage());
        dbViewHolder.imgDes.setText(objectModel.getImgDes());

        dbViewHolder.imageView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        dbViewHolder.cardView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));


        Typeface type = Typeface.createFromAsset(mContext.getAssets(),"fonts/Changa-Regular.ttf");
        dbViewHolder.imgDes.setTypeface(type);

        dbViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Uri uri = Uri.parse(objectModel.getLink());
                    Intent intent = new Intent(Intent.ACTION_VIEW , uri);
                    mContext.startActivity(intent);

                } catch (Exception e){
                    Toast.makeText(mContext , "No Data is retrieved ..." , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return objectModelArraylist.size();
    }

    public static class DbViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView imgDes;
        LinearLayout linearLayout;
        public DbViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linear);
            imageView = itemView.findViewById(R.id.a5barimg);
            imgDes = itemView.findViewById(R.id.tvdescribe);
            cardView = itemView.findViewById(R.id.card);
        }

    }
}
