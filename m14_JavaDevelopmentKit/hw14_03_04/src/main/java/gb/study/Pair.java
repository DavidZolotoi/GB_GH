package gb.study;

class Pair<T, U> {
    private T first;
    private U second;

    /**
     * Создает "кортеж" из двух переменных
     * @param first первая переменная
     * @param second вторая переменная
     */
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }

    @Override public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
