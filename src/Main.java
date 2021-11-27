import ipReader.ReadIPFromFile;

import java.util.Scanner;

public class Main {
    public static ReadIPFromFile readIPFromFile = new ReadIPFromFile();

    public static void main(String[] args) {
        Scanner scanIp = new Scanner(System.in);
        while (true) {
            String ip = scanIp.nextLine();
            readIPFromFile.checkIp(ip);
        }
    }
}
