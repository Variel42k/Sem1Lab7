package Lab7;

public class Example2 {
    public static class BaseAssign {
        private String text;

        public BaseAssign(String text) { this.text = text; }

        public void set(String text) { this.text = text; }

        public int length() { return text == null ? 0 : text.length(); }

        public String getText() { return text; }

        @Override
        public String toString() { return "BaseAssign{text='" + text + "'}"; }
    }

    public static class DerivedAssign extends BaseAssign {
        public int number; // публичное поле

        public DerivedAssign(int number, String text) {
            super(text);
            this.number = number;
        }

        public void set() { set(0, ""); }

        public void set(int number) { this.number = number; }

        // перекрываем set(String) — вызывает суперкласс
        public void set(String text) { super.set(text); }

        public void set(int number, String text) {
            this.number = number;
            super.set(text);
        }

        @Override
        public String toString() {
            return "DerivedAssign{number=" + number + ", text='" + getText() + "'}";
        }
    }

    public static void main(String[] args) {
        DerivedAssign d = new DerivedAssign(5, "start");
        System.out.println(d); // number=5, text='start'
        d.set();               // number=0, text=''
        System.out.println(d);
        d.set("hello");
        d.set(42);
        System.out.println(d);
        d.set(7, "world");
        System.out.println(d + " length=" + d.length());
    }
}

