package com.gmail.peeman34.eglisaofficial;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pee on 9/1/2016.
 */

public class GroupChatList {

    @SerializedName("groupchat_id")


    public int groupchat_id;

    @SerializedName("groupmessage")


    public String groupmessage;

    @SerializedName("profilepicture")
    public  String profilepicture;

    @SerializedName("groupimage")

    public String groupimage;

    @SerializedName("sendername")
    public String sendername;



    @SerializedName("groupcontact")
    public String groupcontact;

    @SerializedName("groupdocument")

    public String groupdocument;

    @SerializedName("groupvideo")

    public String groupvideo;

    @SerializedName("groupaudio")

    public String groupaudio;

}
