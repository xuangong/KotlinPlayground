public class LazyThreadSafeStaticInnerClassJava {

    // 静态内部类的加载不需要依附外部类，在使用时才加载
    private static class Holder {
        private static LazyThreadSafeStaticInnerClassJava INSTANCE = new LazyThreadSafeStaticInnerClassJava();
    }

    private LazyThreadSafeStaticInnerClassJava() {}

    public static LazyThreadSafeStaticInnerClassJava getInstance() {
        return Holder.INSTANCE;
    }
}