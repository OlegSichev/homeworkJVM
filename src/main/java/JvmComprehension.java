public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1 Поле прописывает в Metaspace т.к. тут int, а не Integer
        Object o = new Object();        // 2 В куче создает новый объект, в стэке прописывается ссылка на него
        Integer ii = 2;                 // 3 В куче создает целочисленное значение, в стэке прописывает ссылку на него
        printAll(o, i, ii);             // 4 Метод прописывается в Metaspace
        System.out.println("finished"); // 7 Метод прописывается в Metaspace
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В куче создает целочисленное значение, в стэке прописывает
        // ссылку на него т.к. тут Integer, а не int
        System.out.println(o.toString() + i + ii);  // 6 Метод прописывается в Metaspace
        // Объекты и поля в данном примере создаются и используются один раз, поэтому сборщик мусора удалит их всех
        // после первой проверки
        // Bootstrap ClassLoader будет загружать все упомянутые выше классы т.к. они являются базовыми
        // классами java из java.lang
    }
}