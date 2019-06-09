package controller;

import controller.state.FindOutWords;
import modell.PhotoService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    private static List<ImageIcon> pictureList;


    static {

        pictureList = new ArrayList<>();
        try {
            makePictureList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }


    }

    private static void makePictureList() throws Exception {

        try {
            for (String s : PhotoService.getFilelistPath()) {
                pictureList.add(new ImageIcon(s));
            }
        } catch (Exception e) {
            throw new Exception();

        }
    }


    public static String addStarsString(FindOutWords fou) {
        String result = "";

        int wordLength = fou.getWord().length();
        for (int i = 0; i < wordLength; i++) {
            if (fou.getWord().charAt(i) == ' ')
                result += " ";
            else
                result += "*";
        }

        return result;
    }

    public static List<ImageIcon> getPictureList() {
        return pictureList;
    }
}
