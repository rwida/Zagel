package com.app.zagel_;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;


public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private int mCount;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {


            /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
                }
            });*/


        switch (position) {

            case 0:
                viewHolder.textViewDescription.setText(R.string.amircawoman);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.old)
                        .into(viewHolder.imageViewBackground);
                break;

            case 1:
                viewHolder.textViewDescription.setText(R.string.sudia);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.sudia)
                        .into(viewHolder.imageViewBackground);
                break;

            case 2:
                viewHolder.textViewDescription.setText(R.string.cotinio);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.cotinio)
                        .into(viewHolder.imageViewBackground);
                break;

            case 3:
                viewHolder.textViewDescription.setText(R.string.sick);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.sick)
                        .into(viewHolder.imageViewBackground);
                break;


            case 4:
                viewHolder.textViewDescription.setText(R.string.space);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.space)
                        .into(viewHolder.imageViewBackground);
                break;

            case 5:
                viewHolder.textViewDescription.setText(R.string.fat);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.fat)
                        .into(viewHolder.imageViewBackground);
                break;

            case 6:
                viewHolder.textViewDescription.setText(R.string.ellisa);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.ellisa)
                        .into(viewHolder.imageViewBackground);
                break;

            case 7:
                viewHolder.textViewDescription.setText(R.string.project);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.project)
                        .into(viewHolder.imageViewBackground);
                break;

            case 8:
                viewHolder.textViewDescription.setText(R.string.sheren);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.sheren)
                        .into(viewHolder.imageViewBackground);
                break;

            case 9:
                viewHolder.textViewDescription.setText(R.string.airplane);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.airplane)
                        .into(viewHolder.imageViewBackground);
                break;

            default:
                viewHolder.textViewDescription.setText(R.string.dwayn);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setBackgroundColor(99141414);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.rock)
                        .into(viewHolder.imageViewBackground);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mCount;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
