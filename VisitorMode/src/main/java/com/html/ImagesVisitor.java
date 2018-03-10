package com.html;

import org.jsoup.nodes.Node;
import org.jsoup.select.NodeVisitor;

import java.util.LinkedList;
import java.util.List;

public class ImagesVisitor implements NodeVisitor{
    private List<String> images = new LinkedList<>();
    @Override
    public void head(Node node, int i) {
        if(node.nodeName().equalsIgnoreCase("img"))
        {
            images.add(node.attr("src"));
        }

    }

    @Override
    public void tail(Node node, int i) {

    }

    public String[] getImageUrls()
    {
        return images.toArray(new String[images.size()]);
    }
}
