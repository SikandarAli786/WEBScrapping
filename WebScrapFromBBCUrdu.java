/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraping;

/**
 *
 * @author fragrance
 */
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class WebScrapFromBBCUrdu {
    String text = "Strory,Label\n";
    public void scrap(String url,String label){
        try{
            Document doc = Jsoup.connect(url).get();
            String html = doc.html();
            parse(html,"qa-heading-link",label);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public void parse(String html, String id,String label){
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        Elements e = body.getElementsByClass(id);
        for(Element x:e){
            text += x.text() +","+label+"\n";          
        }
        System.out.println(text);
    }
    public void write(){
        try {
            //FileWriter fw = new FileWriter("src/BBCHeadline.csv");
            //fw.write(text);
            //fw.close();
//            System.out.println(text);
        }catch (Exception e){}
    }

    public static void main(String[] args) {
        WebScrapFromBBCUrdu c = new WebScrapFromBBCUrdu();
        for(int i=1;i<=1;i++) {
            c.scrap("https://www.bbc.com/urdu/topics/cjgn7n9zzq7t/page/"+i,"pakistan");
//            System.out.println("Done");
        }
       for(int i=1;i<=1;i++){
           c.scrap("https://www.bbc.com/urdu/topics/cw57v2pmll9t/page/"+i,"world");
       }
       for(int i=1;i<=1;i++){
           c.scrap("https://www.bbc.com/urdu/topics/c340q0p2585t/page/"+i,"khel");
       }
       for(int i=1;i<=1;i++){
           c.scrap("https://www.bbc.com/urdu/topics/ckdxnx900n5t/page/"+i,"Fun Fankar");
       }
       for(int i=1;i<=1;i++){
           c.scrap("https://www.bbc.com/urdu/topics/c40379e2ymxt/page/"+i,"science");
       }
        c.write();
    }
}
