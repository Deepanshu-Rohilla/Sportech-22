package com.sportech20.iitd;


public class TeamListData {
    String MembName,MembPost,MembContact,MembFaceURL,MembLinkURL,MembEmail,MembInsta;
    int MembPhoto;

    TeamListData(String MembName,String MembPost,String MembContact,String MembFaceURL,String MembLinkURL,String MembEmail,String MembInsta,int membPhotoInt)

    {
        this.MembName=MembName;
        this.MembEmail=MembEmail;
        this.MembFaceURL=MembFaceURL;
        this.MembLinkURL=MembLinkURL;
        this.MembPost=MembPost;
        this.MembContact=MembContact;
        this.MembPhoto=membPhotoInt;
        this.MembInsta=MembInsta;

    }
}

