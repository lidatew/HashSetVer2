import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        System.out.println("------------------Реализация без хешмап(общая)------------------");
        testForNum("1(1).txt");
        testForNum("1.txt");
        testForLetters("2.txt");
        testForLetters("2(1).txt");
        System.out.println("------------------Реализация c хешмап(как в джаве)------------------");
        test2ForNum("1(1).txt");
        test2ForNum("1.txt");
        test2ForLetters("2.txt");
        test2ForLetters("2(1).txt");

    }


    public static void testForNum(String file) {
        HashSet<Object> set = new HashSet<>();
        System.out.println("Метод add");
        addElementsFromFile(file, set);
        System.out.println(set.toString());

        System.out.println("Метод remove, удаляем 1");
        set.remove("1");
        System.out.println(set.toString());

        System.out.println("Метод contains содержится ли 2");
        System.out.println(set.contains("2"));
        System.out.println("Метод contains содержится ли 1");
        System.out.println(set.contains("1"));

        System.out.println("Метод isEmpty");
        System.out.println(set.isEmpty());

        System.out.println("Метод clear и проверим isEmpty");
        set.clear();
        System.out.println(set.toString());
        System.out.println(set.isEmpty() + "\n"+"\n");
    }


    public static void testForLetters(String file) {
        HashSet<Object> set = new HashSet<>();
        System.out.println("Метод add");
        addElementsFromFile(file, set);
        System.out.println(set.toString());

        System.out.println("Метод remove, удаляем a");
        set.remove("a");
        System.out.println(set.toString());

        System.out.println("Метод contains содержится ли def");
        System.out.println(set.contains("def"));
        System.out.println("Метод contains содержится ли a");
        System.out.println(set.contains("a"));

        System.out.println("Метод isEmpty");
        System.out.println(set.isEmpty());

        System.out.println("Метод clear и проверим isEmpty");
        set.clear();
        System.out.println(set.toString());
        System.out.println(set.isEmpty() + "\n"+"\n");
    }


    public static void test2ForNum(String file) {
        HashsetBasedOnHashMap<Object> set = new HashsetBasedOnHashMap<>();
        System.out.println("Метод add");
        addElementsFromFile(file, set);
        System.out.println(set.print());

        System.out.println("Метод remove, удаляем 4");
        set.remove("4");
        System.out.println(set.print());

        System.out.println("Метод contains содержится ли 0");
        System.out.println(set.contains("0"));
        System.out.println("Метод contains содержится ли 9");
        System.out.println(set.contains("9"));

        System.out.println("Метод isEmpty");
        System.out.println(set.isEmpty());

        System.out.println("Метод clear и проверим isEmpty");
        set.clear();
        System.out.println(set.print());
        System.out.println(set.isEmpty() + "\n"+"\n");


    }


    public static void test2ForLetters(String file) {
        HashsetBasedOnHashMap<Object> set = new HashsetBasedOnHashMap<>();
        System.out.println("Метод add");
        addElementsFromFile(file, set);
        System.out.println(set.print());

        System.out.println("Метод remove, удаляем bc");
        set.remove("bc");
        System.out.println(set.print());

        System.out.println("Метод contains содержится ли yz");
        System.out.println(set.contains("yz"));
        System.out.println("Метод contains содержится ли bc");
        System.out.println(set.contains("bc"));

        System.out.println("Метод isEmpty");
        System.out.println(set.isEmpty());

        System.out.println("Метод clear и проверим isEmpty");
        set.clear();
        System.out.println(set.print());
        System.out.println(set.isEmpty() + "\n"+"\n");


    }


    // для второй реализации
    public static void test2(String file) {
        HashsetBasedOnHashMap<Object> set = new HashsetBasedOnHashMap<Object>();
        addElementsFromFile(file, set);
        System.out.println(set.print());
    }


    public static void addElementsFromFile(String fileName, HashSet<Object> set) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Object[] elements = line.split("\\s");

                for (Object cur : elements) {
                    set.add(cur);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void addElementsFromFile(String fileName, HashsetBasedOnHashMap<Object> set) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Object[] elements = line.split("\\s");

                for (Object cur : elements) {
                    set.add(cur);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}