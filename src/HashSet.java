import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

// Общая реализация хешсет. в хешсет по умолчанию массив на 5 бакетов(структура - лист), а уже в них элементы(по подробнее написано в тетради)
public class HashSet<T> {
    //кол-во бакетов(корзин)
    private int sizeArr = 5;
    //количество элементов
    private int countElements = 0;
    //массив бакетов
    private ArrayList<T>[] buckets;

    //заполняем массив пустыми листами
    public HashSet() {
        ArrayList<T>[] arr = new ArrayList[sizeArr];
        this.buckets = arr;
        for (int i = 0; i < sizeArr; i++) {
            buckets[i] = new ArrayList<T>();
        }
    }

    //геттеры и сеттеры
    public void setSizeArr(int sizeArr) {
        this.sizeArr = sizeArr;
    }

    public void setCountElements(int countElements) {
        this.countElements = countElements;
    }

    public int getSizeArr() {
        return sizeArr;
    }

    public int getCountElements() {
        return countElements;
    }


    @Override
    public String toString() {
        return "HashSet{" +
                "sizeArr=" + sizeArr +
                ", countElements=" + countElements +
                ", buckets=" + Arrays.toString(buckets) +
                '}';
    }

    public boolean isEmpty() {
        return (countElements == 0);
    }

    public void clear() {
        if (countElements == 0) {
            return;
        }
        for (ArrayList<T> list : buckets) {
           list.clear();
        }
        countElements = 0;
    }

    //проверяет наличие(во второй реализации написано по-правильнее)
    public boolean contains(T object) {
        int index = object.hashCode() % sizeArr;
        ArrayList<T> list = buckets[index];
        if (list == null) {
            return false;
        }
        return list.contains(object);
    }

    //удаление элемента
    public void remove(T object) {
        int index = object.hashCode() % sizeArr;
        buckets[index].remove(object);
        countElements--;
    }

    //добавление
    public void add(T object) {
        //проверяем содержится ли
        if (!contains(object)) {
            //проверяем равенство элементов и бакетов
            if (sizeArr == countElements) {
                //если равны создаем новый массив в два раза больше копируем в него старый и заменяем старый

                ArrayList<T>[] arrayNew = new ArrayList[sizeArr * 2];
                for (int i = 0; i < sizeArr * 2; i++) {
                    arrayNew[i] = new ArrayList<T>();
                }

                for (ArrayList<T> list : buckets) {
                    ListIterator<T> itr = list.listIterator();
                    while (itr.hasNext()) {
                        T curEl = itr.next();
                        int index = curEl.hashCode() % (sizeArr * 2);
                        ArrayList<T> listCur = arrayNew[index];
                        listCur.add(curEl);
                    }

                }
                sizeArr = sizeArr * 2;
                buckets = arrayNew;
                int index = object.hashCode() % (sizeArr);
                ArrayList<T> list = buckets[index];
                list.add(object);
                countElements++;
            } else {
                int index = object.hashCode() % sizeArr;
                ArrayList<T> list = buckets[index];
                list.add(object);
                countElements++;
            }
        }
    }


}
