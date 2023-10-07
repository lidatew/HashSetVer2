import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//реализация как в джаве на основе хешмап(см. другой класс)
//по сути то же самое что и хешмап, но заполняются только ключи, а значение какая-то константа(заглушка)
public class HashsetBasedOnHashMap<T> {
    private HashMap<T,Object> map;
    //заглушка
    private final int mapValue = 0;

    public HashsetBasedOnHashMap() {
        map = new HashMap<>();
    }

    public boolean contains(T o) {
        return map.containsKey(o);
    }

    public void clear(){
        map.clear();
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public void add(T o){
        map.put(o, mapValue);
    }

    public void remove (T o){
        map.remove(o);
    }

    public StringBuilder print() {
        return map.printAll();
    }


}
