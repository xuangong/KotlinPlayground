public class LazyThreadSafeDoubleCheckJava {
    private static volatile LazyThreadSafeDoubleCheckJava INSTANCE;

    private LazyThreadSafeDoubleCheckJava() {}

    public static LazyThreadSafeDoubleCheckJava getInstance() {
        if (INSTANCE == null) {
            synchronized(LazyThreadSafeDoubleCheckJava.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyThreadSafeDoubleCheckJava();
                }
            }
        }

        return INSTANCE;
    }

    public static void Main(String[] args) {
        LazyThreadSafeDoubleCheckJava singleton = LazyThreadSafeDoubleCheckJava.getInstance();
    }
}