package ipReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadIPFromFile {

    public void checkIp(String ipForCheck) {
        if (checkFormatIP(ipForCheck)) {
            String[] blackIP = getFromFile("IP_BLACKLIST.txt").trim().split("\r\\n");
            if (Arrays.asList(blackIP).contains(ipForCheck)) {
                System.out.println("IP in BLACK LIST!");
                return;
            }
            System.out.println("IP in WHITE LIST!");
            return;
        }
        System.out.println("WRONG FORMAT IP");
    }

    private boolean checkFormatIP(String ip) {
        String emailRegex = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public String getFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename), "Windows-1251");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        while (true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        scanner.close();
        return sb.toString().trim();
    }
}