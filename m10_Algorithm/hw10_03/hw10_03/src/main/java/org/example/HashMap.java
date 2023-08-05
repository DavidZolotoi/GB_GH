package org.example;

import java.util.Iterator;

public class HashMap<K, V> implements Iterable{

    /**
     * Емкость словаря (количество BUCKET) по умолчанию
     */
    private static final int INIT_BUCKET_COUNT = 16;
    /**
     * Коэффициент - отношение количества элементов (узлов) к емкости, при котором необходимо увеличение емкости словаря
     */
    private static final double LOAD_FACTOR = 0.5;

    /**
     * Количество элементов (узлов) словаря
     */
    private int size;

    /**
     * Геттер
     * @return количество элементов (узлов) словаря
     */
    public int getSize() {
        return size;
    }

    /**
     * Массив buckets, в котором содержится весь словарь
     */
    private Bucket[] buckets;

    /**
     * Переопределенный метод интерфейса Iterable
     * @return объект-итератор (со всеми его методами "под капотом") словаря
     */
    @Override
    public Iterator iterator() {
        return new HashMapIterator();
    }

    /**
     * Класс для имплементирования итератора словаря
     */
    class HashMapIterator implements Iterator<Bucket> {

        /**
         * Индекс текущего bucket словаря
         */
        private int currentIndexBucket = 0;
        /**
         * Текущий ключ элемента (узла)
         */
        private K currentNodeKey;

        /**
         * Переопределенный метод итератора
         * @return информацию о существовании следующего bucket словаря
         */
        @Override
        public boolean hasNext() {

            /* 0. НАЙДЕМ ПЕРВЫЙ БАКЕТ, В КОТОРОМ ЕСТЬ ЗНАЧЕНИЯ */
            Bucket.Node nodeBuf;
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] == null) continue;
                nodeBuf = buckets[i].head;
                if (nodeBuf != null) {
                    currentIndexBucket = i;
                    currentNodeKey = (K)nodeBuf.value.key;
                }
            }

            Bucket bucket = null;
            Bucket.Node node = null;
            /* 1. НАЙДЕМ ТЕКУЩИЙ БАКЕТ */
            boolean isFindCurrentBucket = false;
            if (currentIndexBucket < buckets.length){
                bucket = buckets[currentIndexBucket];
                isFindCurrentBucket = true;
            }

            /* 2. НАЙДЕМ ТЕКУЩИЙ ЭЛЕМЕНТ (УЗЕЛ) ВНУТРИ ТЕКУЩЕГО БАКЕТА */
            boolean isFindCurrentNode = false;
            if (bucket != null) node = bucket.head;
            // до тех пор, пока не дойдем до null в связном списке
            while(node != null) {
                // проверять ключ ноды с текущим ключом
                if (node.value.key.equals(currentNodeKey)) {
                    isFindCurrentNode = true;
                    break;
                }
                // и двигаться вперед по связному списку внутри текущего бакета
                node = node.next;
            }

            if (!(isFindCurrentBucket && isFindCurrentNode))
                System.out.println("Что-то пошло не так. isFindCurrentBucket && isFindCurrentNode == false");

            //* 3. ПРОВЕРИМ НАЛИЧИЕ СЛЕДУЮЩЕГО ЭЛЕМЕНТА (УЗЛА) */
            // Если есть ссылка на следующий элемент, то
            if (node.next != null) return true;
            // Отсюда и ниже подразумевается, что node.next == null. Тут возможны 2 варианта:
            // Если это последний бакет => значит это финиш
            if (currentIndexBucket == buckets.length-1) return false;
            // Отсюда и ниже подразумевается, что бакет не последний,
            // а это значит элементы (узлы) еще могут быть в других бакетах
            // Поэтому надо проверить остальные бакеты - достаточно пройтись по головам
            boolean isNodeExist = false;
            Bucket.Node nodeTmp;
            for (int i = currentIndexBucket + 1; i < buckets.length; i++) {
                nodeTmp = bucket.head;
                isNodeExist = isNodeExist || (nodeTmp != null);
            }
            return isNodeExist;
        }

        /**
         * Переопределенный метод итератора
         *
         * @return следующий элемент (узел)
         */
        @Override
        public Bucket next() {
            var bucket = buckets[currentIndexBucket];
            if (currentIndexBucket <= buckets.length-2) currentIndexBucket++;
            return bucket;
        }
    }

    /**
     * Пара "ключ-значение"
     */
    class Entity{
        K key;
        V value;
    }

    /**
     * Buckets массива
     * @param <K> ключ в словаре
     * @param <V> значение в словаре
     */
    class Bucket<K, V>{

        /**
         * 1-ый элемент (узел) связного списка внутри bucket массива
         */
        Node head;

        /**
         * Элемент (узел) связного списка внутри bucket массива
         */
        class Node{
            Node next;
            Entity value;
        }

        /**
         * Метод добавления пары "ключ-значение" в bucket словаря
         * @param entity пара "ключ-значение" для добавления в bucket словаря
         * @return null - если такого ключа нет; старое значение V - если ключ был, а значит значение было перезаписано
         */
        public V add(Entity entity){
            Node node = new Node();
            node.value = entity;

            if (head == null){
                head = node;
                return null;
            }

            Node currentNode = head;
            while (true){
                if (currentNode.value.key.equals(entity.key)){
                    V buf = (V)currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }
                if (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                else {
                    currentNode.next = node;
                    return null;
                }
            }
        }

        /**
         * Метод возврата значения V, соответствующего ключу K в bucket словаря
         * @param key ключ, по которому будет произведен поиск значения V
         * @return значение V, соответствующее ключу K
         */
        public V get(K key){
            Node node = head;
            while (node != null){
                if (node.value.key.equals(key)){
                    return (V)node.value.value;
                }
                node = node.next;
            }
            return null;
        }

        /**
         * Метод удаления элемента (узла) по ключу
         * @param key ключ
         * @return объект или null
         */
        public V remove(K key){
            if (head == null)
                return null;
            if (head.value.key.equals(key)){
                V buf = (V)head.value.value;
                head = head.next;
                return buf;
            }
            else{
                Node node = head;
                while (node.next != null){
                    if (node.next.value.key.equals(key)){
                        V buf = (V)node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
        }

//        public String toString() {
//            return (head.value.key + " " + head.value.value);
//        }
    }

    /**
     * Метод расчета индекса bucket
     * @param key ключ
     * @return индекс bucket
     */
    private int calculateBucketIndex(K key)
    {
        return Math.abs(key.hashCode()) % buckets.length;
    }


    /**
     * Метод анализа и расширения массива bucket
     */
    private void recalculate(){
        size = 0;
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++){
            Bucket<K, V> bucket = old[i];
            if (bucket != null){
                Bucket.Node node = bucket.head;
                while (node != null){
                    put((K)node.value.key, (V)node.value.value);
                    node = node.next;
                }
            }
            old[i] = null;
        }
    }

    /**
     * Метод добавления/перезаписи новой пары "Ключ-Значение"
     * @param key ключ
     * @param value значение
     * @return null - если такого ключа нет; старое значение V - если ключ был, а значит значение было перезаписано
     */
    public V put(K key, V value){

        if (buckets.length * LOAD_FACTOR <= size){
            recalculate();
        }

        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null){
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        V res = (V)bucket.add(entity);
        if (res == null){
            size++;
        }
        return res;
    }

    /**
     * Метод возврата значения V по ключу K
     * @param key ключ
     * @return значение
     */
    public V get(K key){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V)bucket.get(key);
    }

    /**
     * Метод удаления пары "Ключ-Значение" по ключу
     * @param key ключ
     * @return объект или null
     */
    public V remove(K key){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        V res = (V)bucket.remove(key);
        if (res != null){
            size--;
        }
        return res;
    }

    /**
     * Конструктор по умолчанию (создаст 16 bucket)
     */
    public HashMap(){
        buckets = new Bucket[INIT_BUCKET_COUNT];
    }

    /**
     * Конструктор HashMap с определенной емкостью initCount
     * @param initCount начальная заданная емкость
     */
    public HashMap(int initCount){
        buckets = new Bucket[initCount];
    }

}
