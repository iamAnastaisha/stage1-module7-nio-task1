package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            profile.setName(strings.get(0).substring(strings.get(0).indexOf(':') + 2));
            String age = strings.get(1).substring(strings.get(1).indexOf(':') + 2);
            if (!age.equals("")) {
                profile.setAge(Integer.parseInt(age));
            }
            profile.setEmail(strings.get(2).substring(strings.get(2).indexOf(':') + 2));
            String phone = strings.get(3).substring(strings.get(3).indexOf(':') + 2);
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
