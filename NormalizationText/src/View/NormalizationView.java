package View;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class NormalizationView {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void loadData(String filePath) {
        try {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                sb.append(scanner.next()).append(" ");
            }
            text = sb.toString().trim();
        } catch (FileNotFoundException e) {
            System.out.println("File Error !!!");
        }
    }

    public void writeStringToFile(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            writer.flush();
            System.out.println("Write Successfully");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public String nomarlizeSpace(String input) {
        String[] s = input.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < s.length; i++) {
            for (int k = 0; k < s[i].toCharArray().length; k++) {
                char c = s[i].charAt(k);
                if (c == ',' || c == ':') {
                    if (sb.charAt(sb.length() - 1) == ' ')
                        sb.deleteCharAt(sb.length() - 1);
                    sb.append(c);
                    sb.append(' ');
                    continue;
                } else if (c == '.') {
                    if (sb.charAt(sb.length() - 1) == ' ')
                        sb.deleteCharAt(sb.length() - 1);
                    sb.append(c);
                    sb.append(' ');
                    flag = 1;
                    continue;
                }
                if (c == '\"') {
                    sb.append(' ');
                    sb.append(c);
                    continue;
                }
                if (flag == 1) {
                    sb.append(Character.toUpperCase(c));
                    flag = 0;
                    if (k == s[i].toCharArray().length - 1) {
                        sb.append(' ');
                    }
                    continue;
                }
                sb.append(c);
                if (k == s[i].toCharArray().length - 1) {
                    sb.append(' ');
                }
            }
        }
        if(!sb.isEmpty()){
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }
        String normalizedText = sb.toString().trim();
        if (!normalizedText.isEmpty() && !normalizedText.endsWith(".")) {
            normalizedText = normalizedText + ".";
        }
        return normalizedText;
    }

    public void display(String data) {
        System.out.println("Your Data: ");
        System.out.print(nomarlizeSpace(data));
        System.out.println();
    }
}
