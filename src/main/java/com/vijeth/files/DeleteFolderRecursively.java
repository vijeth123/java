package com.vijeth.files;

import java.io.File;

public class DeleteFolderRecursively {
    public static void main(String[] args) {
        String folder = "D:\\Test";
        recursiveDelete(new File(folder));
    }

    public static void recursiveDelete(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f: files){
                recursiveDelete(f);
            }
        }
        file.delete();
        System.out.println(file.getAbsolutePath()+" has been deleted.");
    }
}
