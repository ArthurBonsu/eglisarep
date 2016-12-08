package com.gmail.peeman34.eglisaofficial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kosalgeek.android.json.JsonConverter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;




class GROUPCHATADAPTER extends RecyclerView.Adapter<GROUPCHATADAPTER.GroupChatViewHolder> {
    String groupchatlistings;
    ArrayList<GroupChatList> groupchatlisting =new JsonConverter<GroupChatList>().toArrayList(groupchatlistings, GroupChatList.class);
    Context ctx;
    final String TAG = this.getClass().getSimpleName();
    public GROUPCHATADAPTER(ArrayList<GroupChatList> groupchatlisting, Context ctx) {
        this.groupchatlisting = groupchatlisting;
        this.ctx =ctx;
    }

    @Override
    public GroupChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.groupchatroom,parent,false);
        GroupChatViewHolder holder = new GroupChatViewHolder(view,ctx, groupchatlisting) {


        };
        return  holder;}

    @Override
    public void onBindViewHolder(GroupChatViewHolder holder, int position) {


        ArrayList<GroupChatList>groupchatlisting = new JsonConverter<GroupChatList>().toArrayList(groupchatlistings,GroupChatList.class) ;
        GroupChatList groupChatList2 = groupchatlisting.get(position);
        Uri uri  = Uri.parse(String.valueOf(groupChatList2.groupimage));
        Context context =  holder.personpic.getContext();
        Picasso.with(context).load(uri).into(holder.personpic);
        holder.person_name.setText(groupChatList2.sendername);

        GroupChatList groupChatList4 = groupchatlisting.get(position);
        Uri uri2  = Uri.parse(String.valueOf(groupChatList2.groupimage));
        Context context2 =  holder.grouppicsent.getContext();
        Picasso.with(context2).load(uri2).into(holder.grouppicsent);


         holder.textsent.setText(groupChatList2.groupmessage);



    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public  static  class  GroupChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private final String TAG = this.getClass().getSimpleName();
        ImageView grouppicsent; ImageView personpic;
        TextView textsent, person_name;

        String groupchatlistings2;
        ArrayList<GroupChatList>groupchatlisting = new JsonConverter<GroupChatList>().toArrayList(groupchatlistings2,GroupChatList.class);
        Context ctx;

        public GroupChatViewHolder(View itemView, Context ctx, ArrayList<GroupChatList> messagelisting) {

            super(itemView);
            String groupchatlisting3 = null;
            groupchatlistings2 = groupchatlisting3;
            this.groupchatlisting = messagelisting;
            this.ctx = ctx;
            Log.d(TAG,groupchatlisting3);


            grouppicsent= (ImageView) itemView.findViewById(R.id.grouppicsent);
            textsent = (TextView) itemView.findViewById(R.id.textsent);
            person_name = (TextView) itemView.findViewById(R.id.person_name);
            personpic = (ImageView) itemView.findViewById(R.id.profilepicture);
            grouppicsent = (ImageView) itemView.findViewById(R.id.grouppicsent);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            GroupChatList groupChatList =this.groupchatlisting.get(position);
            Intent intent =new Intent(this.ctx, MessageDetails.class);
            intent.putExtra("img_id", groupChatList.groupchat_id);
            intent.putExtra("person_image", groupChatList.groupimage);
            intent.putExtra("person_name", groupChatList.sendername);

            intent.putExtra("person_mobile",groupChatList.groupcontact);
            this.ctx.startActivity(intent);
        }}


}