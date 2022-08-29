package com.codeforcessubmissiondownloader.operators;

import com.codeforcessubmissiondownloader.entities.Submission;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.select.Elements;

public class SubmittedCodeFetcher {

    static public boolean fetchCode(Submission submission, String path) {
        String codeUrl = "https://codeforces.com/contest/" + submission.getContestId() + "/submission/" + submission.getId();

        try {

            Document doc = Jsoup.connect(codeUrl).timeout(20000).get();

            doc.outputSettings().escapeMode(EscapeMode.xhtml);

            Elements elem = doc.select("pre.program-source");
            String code = elem.text();

            return SaveToFile.save(submission, code, path);

        } catch (IOException e) {

            JOptionPane optionPane = new JOptionPane(e.toString());
            JDialog dialog = optionPane.createDialog(null, "Error");

            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return false;
        }
    }
}
