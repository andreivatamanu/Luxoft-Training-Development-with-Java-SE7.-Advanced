package com.luxoft.jva008.module08;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FirstLambda {

	/**
	 * Rewrite this class to use lambda expression to find
	 * @throws IOException 
	 */
    public static void main(String[] args) {
        
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        
        File dir = new File("./src/com/luxoft/jva008/module08");
        
        File[] files = dir.listFiles(filter);
        
        for (File f : files) {
            System.out.println(f);
        }
    }
}
