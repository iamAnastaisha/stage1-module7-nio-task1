package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        String str = "";
        try (FileInputStream in = new FileInputStream(file)){
            if(!Files.exists(file.toPath())) {
                throw new IOException("File not found");
            }
            int c;
            while ((c = in.read()) != -1) {
                str = str.concat(Character.toString(c));
            }
            String[] strings = str.split("\n");
            profile.setName(strings[0].substring(strings[0].indexOf(':') + 2));
            String age = strings[1].substring(strings[1].indexOf(':') + 2);
            if (!age.equals("")) {
                profile.setAge(Integer.parseInt(age));
            }
            profile.setEmail(strings[2].substring(strings[2].indexOf(':') + 2));
            String phone = strings[3].substring(strings[3].indexOf(':') + 2);
            if (!phone.equals("")) {
                profile.setPhone(Long.parseLong(phone));
            }
        } catch (IOException ex) {
            Logger logger = Logger.getLogger(
                    FileReader.class.getName());
            logger.log(Level.WARNING, ex.toString());
        }
        return profile;
    }
}
