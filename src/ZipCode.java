import java.io.*;
import java.util.Scanner;

public class ZipCode {
    public static void main(String[] args) throws IOException {
        int zipCode;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Introduzcq el codigo postal: ");
        zipCode = inputScanner.nextInt();
        String s = getText(zipCode);
        System.out.println(s);

    }

    public static String getText(int zipCode) throws IOException {
        BufferedReader input = null;
        String s = "";
        try {
            input = new BufferedReader(new FileReader("municipios-calles.txt"));
            String line;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(";");
                int zipCodeItem = Integer.parseInt(items[3]);
                if (zipCodeItem == zipCode) {
                    s += "codProvince: " + items[0] + "\n";
                    if (items[2].toLowerCase().equals("true")) {
                        s += "City: " + items[1] + "\n";
                        s += "First street: " + items[4] + "\n";

                    } else {
                        s += "Province: " + items[1] + "\n";
                        s += "City: " + items[4] + "\n";
                    }
                    s += "Zip Code: " + items[3] + "\n";
                    break;
                }
            }
            return s;
        }finally {
            if (input != null) {
                input.close();
            }
        }
    }
}

