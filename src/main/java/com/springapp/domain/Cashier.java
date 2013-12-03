package com.springapp.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;

public class Cashier{

    private String name;
    private String path;
    private BufferedWriter writer;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    @PostConstruct
    public void openFile() throws FileNotFoundException {
        File logFile = new File(path, name + ".txt");
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile,true)));
    }
    @PreDestroy
    public void closeFile() throws IOException {
        writer.close();
    }

    public void checkout(ShoppingCart shoppingCart) throws IOException {
        double total = 0;
        for(Product product : shoppingCart.getProductList()){
            total += product.getPrice();
        }
        writer.write(new Date() + "\t" + total + "\r\n");
        writer.flush();

    }

}
