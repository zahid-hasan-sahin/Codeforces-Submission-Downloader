package com.codeforcessubmissiondownloader.operators;

import com.codeforcessubmissiondownloader.entities.Submission;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class SaveToFile {

    static HashMap<String, Integer> ac = new HashMap<String, Integer>();
    static HashMap<String, Integer> wa = new HashMap<String, Integer>();
    static HashMap<String, Integer> tle = new HashMap<String, Integer>();
    static HashMap<String, Integer> mle = new HashMap<String, Integer>();
    static HashMap<String, Integer> re = new HashMap<String, Integer>();
    static boolean isCreated = false;

    public static boolean save(Submission submission, String code, String path) {
        path += "\\";

        if (!isCreated) {
            File acFile = new File(path + "\\Accepted");
            File waFile = new File(path + "\\Wrong answer");
            File tleFile = new File(path + "\\Time limit exceeded");
            File mleFile = new File(path + "\\Memory limit exceeded");
            File reFile = new File(path + "\\Runtime error");
            acFile.mkdir();
            waFile.mkdir();
            tleFile.mkdir();
            mleFile.mkdir();
            reFile.mkdir();

            isCreated = true;
        }
        String fileName = submission.getContestId() + submission.getIndex() + "-"
                + submission.getName();

        fileName = fileName.replaceAll("[^a-zA-Z0-9]", " ");
        int total = 0;
        String tempFileName = fileName;

        String ext = ProgrammingLanguageToFileExtention.getExtention(submission.getProgrammingLanguage());

        //writing accepted code
        if (submission.getVerdict().equals("OK")) {

            if (ac.containsKey(fileName)) {
                total = ac.get(fileName);
                fileName = fileName + "~(" + (total) + "_submission)";

            }
            ac.put(tempFileName, total + 1);

            String acPath = path + "\\Accepted\\" + fileName + "." + ext;
            FileWriter f;
            try {
                f = new FileWriter(acPath);
                f.write(code);
                f.close();
            } catch (IOException ex) {

                JOptionPane optionPane = new JOptionPane(ex.toString());
                JDialog dialog = optionPane.createDialog(null, "Error");

                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }

            //writing Wrong answer code
        } else if (submission.getVerdict().equals("WRONG_ANSWER")) {

            if (wa.containsKey(fileName)) {
                total = wa.get(fileName);
                fileName = fileName + "~(" + (total) + "_submission)";

            }
            wa.put(tempFileName, total + 1);

            String acPath = path + "\\Wrong answer\\" + fileName + "." + ext;
            FileWriter f;
            try {
                f = new FileWriter(acPath);
                f.write(code);
                f.close();
            } catch (IOException ex) {
                JOptionPane optionPane = new JOptionPane(ex.toString());
                JDialog dialog = optionPane.createDialog(null, "Error");

                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }

            //writing Time limit exceeded code
        } else if (submission.getVerdict().equals("TIME_LIMIT_EXCEEDED")) {

            if (tle.containsKey(fileName)) {
                total = tle.get(fileName);
                fileName = fileName + "~(" + (total) + "_submission)";

            }
            tle.put(tempFileName, total + 1);

            String acPath = path + "\\Time limit exceeded\\" + fileName + "." + ext;
            FileWriter f;
            try {
                f = new FileWriter(acPath);
                f.write(code);
                f.close();
            } catch (IOException ex) {
                JOptionPane optionPane = new JOptionPane(ex.toString());
                JDialog dialog = optionPane.createDialog(null, "Error");

                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
            //writing Memory limit exceeded code
        } else if (submission.getVerdict().equals("MEMORY_LIMIT_EXCEEDED")) {

            if (mle.containsKey(fileName)) {
                total = mle.get(fileName);
                fileName = fileName + "~(" + (total) + "_submission)";

            }
            mle.put(tempFileName, total + 1);

            String acPath = path + "\\Memory limit exceeded\\" + fileName + "." + ext;
            FileWriter f;
            try {
                f = new FileWriter(acPath);
                f.write(code);
                f.close();
            } catch (IOException ex) {
                JOptionPane optionPane = new JOptionPane(ex.toString());
                JDialog dialog = optionPane.createDialog(null, "Error");

                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
            //writing RUNTIME_ERROR code
        } else if (submission.getVerdict().equals("RUNTIME_ERROR")) {

            if (re.containsKey(fileName)) {
                total = re.get(fileName);
                fileName = fileName + "~(" + (total) + "_submission)";

            }
            re.put(tempFileName, total + 1);

            String acPath = path + "\\Runtime error\\" + fileName + "." + ext;
            FileWriter f;
            try {
                f = new FileWriter(acPath);
                f.write(code);
                f.close();
            } catch (IOException ex) {
                JOptionPane optionPane = new JOptionPane(ex.toString());
                JDialog dialog = optionPane.createDialog(null, "Error");

                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }

        }
        return true;

    }
}
