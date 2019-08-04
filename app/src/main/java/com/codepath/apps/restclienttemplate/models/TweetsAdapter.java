package com.codepath.apps.restclienttemplate.models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.R;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.viewHolder> {
    private Context context;
    private List<Tweet> tweets;




    // pass in context and list of tweets


    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // for each row inflate the layout
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, viewGroup, false);
        return new viewHolder(view);
    }




    // bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Tweet tweet  = tweets.get(i);
        viewHolder.tvBody.setText(tweet.body);
        viewHolder.tvScreenName.setText(tweet.user.screenName);
        Glide.with(context).load(tweet.user.profileImageUrl).into(viewHolder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public  void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addTweets(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    // define the viewholder
    public class viewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvBody = itemView.findViewById(R.id.tvBody);


        }
    }
}
