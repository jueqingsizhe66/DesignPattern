package com.html;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.NodeTraversor;

import java.io.*;
import java.net.URL;

public class HtmlTest {

    /*

   	JSoup还可以提取链接、提取纯文本等，做网页爬虫可以用。
     */
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new URL("http://www.rupeng.com"),10000);

        ImagesVisitor visitor = new ImagesVisitor();
        NodeTraversor.traverse(visitor, doc);
        int i = 0;
        for(String imgUrl:visitor.getImageUrls())
        {
       //     System.out.println(url);
            URL url = new URL(imgUrl);
            try(InputStream instream = url.openStream();
                OutputStream os= new FileOutputStream(new File("d:\\aaa\\img\\"+(i++)+".png"));
                ){
                //need improve
                IOUtils.copy(instream,os);
            }
        }

    }

}
