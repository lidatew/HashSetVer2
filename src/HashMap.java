import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;


public class HashMap<K, V> {
    //колиство бакетов, по умолчанию 16, но здесь 5 чтобы нагляднее было
    private int sizeArr = 5;
    //количество элементов
    private int countElements = 0;
    // Entry контейнер для пары ключ значение (класс реализован ниже здесь же)
    private ArrayList<Entry<K, V>>[] buckets;

    //геттеры сеттеры
    public int getSizeArr() {
        return sizeArr;
    }

    public int getCountElements() {
        return countElements;
    }

    public void setSizeArr(int sizeArr) {
        this.sizeArr = sizeArr;
    }

    public void setCountElements(int countElements) {
        this.countElements = countElements;
    }

    //заполнение пустыми листами
    public HashMap() {
        this.buckets = new ArrayList[sizeArr];
        for (int i = 0; i < sizeArr; i++) {
            ArrayList<Entry<K, V>> list = new ArrayList<>();
            buckets[i] = list;
        }
    }

    //налие ключа в хелмап
    public boolean containsKey(K key) {
        int index = key.hashCode() % sizeArr;
        ArrayList<Entry<K, V>> list = buckets[index];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    //добавление
    public void put(K key, V value) {
        //проверяем наличие
        if (!containsKey(key)) {
            // если количество бакетов такое же что и кол-во элементов
            // то создаем новый массив в два раза больше
            if (sizeArr == countElements) {
                sizeArr = sizeArr * 2;
                ArrayList<Entry<K, V>>[] newArr = new ArrayList[sizeArr];
                //заполняем листами
                for (int i = 0; i < sizeArr; i++) {
                    ArrayList<Entry<K, V>> list = new ArrayList<>();
                    newArr[i] = list;
                }
                //переопрделяем индексы
                for (ArrayList<Entry<K, V>> list : buckets) {
                    for (Entry<K, V> entry : list) {
                        int index = entry.getKey().hashCode() % sizeArr;
                        ArrayList<Entry<K, V>> listCur = newArr[index];
                        listCur.add(entry);
                    }
                }
                buckets = newArr;
                // добавляем новый элемент
                int index = key.hashCode() % sizeArr;
                ArrayList<Entry<K, V>> list = buckets[index];
                list.add(new Entry<>(key, value));
                countElements++;
            } else {
                // добавляем новый элемент
                int index = key.hashCode() % sizeArr;
                ArrayList<Entry<K, V>> list = buckets[index];
                list.add(new Entry<>(key, value));
                countElements++;
            }
        }
    }

    //удаление ключа
    public void remove(K key) {
        int index = key.hashCode() % sizeArr;
        ArrayList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                countElements--;
                return;
            }
        }
    }

    //Полностью очищает словарь
    public void clear() {
        if (countElements == 0) {
            return;
        }
        for (ArrayList<Entry<K, V>> list : buckets) {
            list.clear();
        }
        countElements = 0;
    }

    //Возвращает элемент с ключом key
    public V get(K key) {
        int index = key.hashCode() % sizeArr;
        ArrayList<Entry<K, V>> list = buckets[index];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    //Возвращает список всех ключей из словаря
    public ArrayList<K> keySet() {
        ArrayList<K> listForKeys = new ArrayList<>();
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> node : bucket) {
                listForKeys.add(node.getKey());
            }
        }
        return listForKeys;
    }

    //Возвращает список всех значений из словаря
    public ArrayList<V> values() {
        ArrayList<V> listForValues = new ArrayList<>();
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> node : bucket) {
                listForValues.add(node.getValue());
            }
        }
        return listForValues;
    }

    //Возвращает список пар «ключ — значение»
    public ArrayList<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> listForValuesAndKeys = new ArrayList<>();
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> node : bucket) {
                listForValuesAndKeys.add(node);
            }
        }
        return listForValuesAndKeys;
    }

    //Возвращает размер словаря
    public int size() {
        return sizeArr;
    }

    //Проверяет, пуст ли словарь
    public boolean isEmpty() {
        return countElements == 0;
    }


    // вывод. toString не работает потому что выводятся ссылки на элементы, а не элементы
    public StringBuilder printAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("sizeArr=" + sizeArr +
                ", countElements=" + countElements + ", ");
        sb.append("[");
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            sb.append("[");
            for (Entry<K, V> node : bucket) {
                sb.append("\s" + node.getKey() + "\s");
            }
            sb.append("]");
        }
        sb.append("]");
        return sb;
    }


    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

