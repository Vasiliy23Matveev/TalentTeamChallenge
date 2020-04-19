package TTC;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File input = new File(scanner.nextLine());
        Document parsedInput = null;

        try {
            parsedInput = Jsoup.parse(input, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements tagsInformation = parsedInput.select(".full_name");

        List<List<String>> allTags = new ArrayList<>();
        for (Element elem : tagsInformation) {
            String spliter = " ";
            List<String> substr = Arrays.asList(elem.text().split(spliter));
            allTags.add(substr);
        }

        for (List<String> element : allTags) {
            String surname = null;
            String name = null;
            String patronymic = null;
            if (element.size() >= 1) surname = element.get(0);
            if (element.size() >= 2) name = element.get(1);
            if (element.size() >= 3) patronymic = element.get(2);
            if (element.size() > 3) {
                System.out.println("Ой! это что-то сложное и непонятное :(");
                break;
            }
            if (patronymic != null && name != null && surname != null) {
                System.out.println("Ура! Мы нашли фамилию: " + surname + ", имя: " + name + ", отчество: " + patronymic + "!");
            }
            else if (name != null && surname != null) {
                System.out.println("Ура! Мы нашли фамилию: " + surname + ", имя: " + name + "!");
            }
            else if (surname != null) {
                System.out.println("Ура! Мы нашли фамилию: " + surname + "!");
            }
        }


    }
}
