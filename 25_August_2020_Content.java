import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args){
        int contentId;
        String content;
        String category;
        int likes;
        int dislikes;
        int shares;
        Content[] c = new Content[4];
        Scanner s = new Scanner(System.in);
        for(int i=0; i<c.length; i++){
            contentId = s.nextInt();s.nextLine();
            content = s.nextLine();
            category = s.nextLine();
            likes = s.nextInt();
            dislikes = s.nextInt();
            shares = s.nextInt();
            c[i] = new Content(contentId, content, category, likes, dislikes, shares);
        }
        s.nextLine();
        String requiredCategory = s.nextLine();
        s.close();
        Content newContent = getMaxSharedContent(c);
        String newString = findContentByCategory(c, requiredCategory);
        
        if(newContent == null)
            System.out.println("No content Shared");
        else
            System.out.println("Maximum shared content:"+newContent.getContent());
        
        if(newString == null)
            System.out.println("Content not available for the category");
        else
            System.out.println("Content Details:"+newString);
    }
    public static Content getMaxSharedContent(Content[] contentArray){
        Content c = null;
        int maxShare = 0;
        for(int i=0;i<contentArray.length;i++){
            if(contentArray[i].getShares() > maxShare){
                maxShare = contentArray[i].getShares();
                c = contentArray[i];
            }
        }
        return c;
    }
    public static String findContentByCategory(Content[] contentArray, String category){
        String newString;
        for(int i=0; i<contentArray.length; i++){
            if(category.equalsIgnoreCase(contentArray[i].getCategory()) && contentArray[i].getDislikes() == 0){
                newString = contentArray[i].getContentId()+"#"+contentArray[i].getContent()+"#"+contentArray[i].getCategory();
                return newString;
            }
        }
        return null;
    }
}
class Content{
    int contentId;
    String content;
    String category;
    int likes;
    int dislikes;
    int shares;
    Content(){}
    Content(int contentId, String content, String category, int likes, int dislikes, int shares){
        this.contentId = contentId;
        this.content = content;
        this.category = category;
        this.likes = likes;
        this.dislikes = dislikes;
        this.shares = shares;
    }
    int getContentId(){
        return contentId;
    }
    String getContent(){
        return content;
    }
    String getCategory(){
        return category;
    }
    int getLikes(){
        return likes;
    }
    int getDislikes(){
        return dislikes;
    }
    int getShares(){
        return shares;
    }
}
