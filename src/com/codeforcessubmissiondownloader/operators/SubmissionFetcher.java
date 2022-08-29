package com.codeforcessubmissiondownloader.operators;

import com.codeforcessubmissiondownloader.app.CodeForcesSubmissionDownloader;
import com.codeforcessubmissiondownloader.entities.Submission;
import java.awt.Font;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SubmissionFetcher extends Thread {

    @Override
    public void run() {
        fetch();
    }

    public boolean fetch() {
        String username = CodeForcesSubmissionDownloader.username;
        String path = CodeForcesSubmissionDownloader.path;
        try {
            URL url = new URL("https://codeforces.com/api/user.status?handle=" + username + "&from=1&count=100000");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == 200) {
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    String resultFromAPI = scan.nextLine();

                    JSONParser parser = new JSONParser();
                    JSONObject json = (JSONObject) parser.parse(resultFromAPI);

                    String status = (String) json.get("status");
                    if (status.equals("FAILED")) {
                        JOptionPane optionPane = new JOptionPane("invalid username");
                        JDialog dialog = optionPane.createDialog(null, "Error");

                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                        return false;
                    }

                    JSONArray resultArray = (JSONArray) json.get("result");

                    for (int i = 0; i < resultArray.size(); i++) {
                        JSONObject resultObject = (JSONObject) resultArray.get(i);

                        long id = (long) resultObject.get("id");
                        long contestId = (long) resultObject.get("contestId");
                        String verdict = (String) resultObject.get("verdict");
                        String programmingLanguage = (String) resultObject.get("programmingLanguage");

                        JSONObject problemObject = (JSONObject) resultObject.get("problem");
                        String index = (String) problemObject.get("index");
                        String name = (String) problemObject.get("name");

                        Submission submission = new Submission(id, contestId, verdict, index, name, programmingLanguage);

                        SubmittedCodeFetcher.fetchCode(submission, path);

                    }

                    JOptionPane optionPane = new JOptionPane("Download done!!!");
                    JDialog dialog = optionPane.createDialog(null, "done");

                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
             
                }
                return true;
            } else {

                JOptionPane optionPane = new JOptionPane("invalid handle");
                JDialog dialog = optionPane.createDialog(null, "Error");

                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                return false;
            }
        } catch (Exception e) {

            JOptionPane optionPane = new JOptionPane(e.toString() + ",Please check your network connection.");
            JDialog dialog = optionPane.createDialog(null, "Error");

            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return false;
        }
    }
}
