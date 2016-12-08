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




class Messageradapter extends RecyclerView.Adapter<Messageradapter.MessageViewHolder> {
    String messagelistings;
    ArrayList<MessageList> messagelisting =new JsonConverter<MessageList>().toArrayList(messagelistings, MessageList.class);
    Context ctx;
    final String TAG = this.getClass().getSimpleName();
    public Messageradapter(ArrayList<MessageList> messagelisting, Context ctx) {
        this.messagelisting = messagelisting;
        this.ctx =ctx;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messaginglist, parent, false);
        MessageViewHolder holder = new MessageViewHolder(view,ctx, messagelisting) {


        };
        return  holder;}

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        ArrayList<MessageList>messagelisting = new ArrayList<MessageList>();
        MessageList messageList2 = messagelisting.get(position);
        Uri uri  = Uri.parse(String.valueOf(messageList2.messageimage));
        Context context =  holder.person_img.getContext();
        Picasso.with(context).load(uri).into(holder.person_img);
        holder.person_name.setText(messageList2.messagelist);

        holder.person_number.setText(messageList2.messagenumbers);





    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public  static  class  MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private final String TAG = this.getClass().getSimpleName();
        ImageView person_img;
        TextView person_name, person_number;

        String messagelistings2;
        ArrayList<MessageList>messagelisting = new JsonConverter<MessageList>().toArrayList(messagelistings2,MessageList.class);
        Context ctx;

        public MessageViewHolder(View itemView,Context ctx, ArrayList<MessageList>messagelisting) {

            super(itemView);
            String messagelisting3 = null;
                 messagelistings2 = messagelisting3;
            this.messagelisting = messagelisting;
            this.ctx = ctx;
            Log.d(TAG,messagelisting3);
            person_img= (ImageView) itemView.findViewById(R.id.person_img);
            person_name = (TextView) itemView.findViewById(R.id.person_name);
            person_number = (TextView) itemView.findViewById(R.id.person_number);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            MessageList messageList =this.messagelisting.get(position);
            Intent intent =new Intent(this.ctx, MessageDetails.class);
            intent.putExtra("img_id", messageList.messagelist_id);
            intent.putExtra("person_image", messageList.messageimage);
            intent.putExtra("person_name", messageList.messagelist);
            intent.putExtra("person_mobile",messageList.messagenumbers);
            this.ctx.startActivity(intent);
        }}


}



