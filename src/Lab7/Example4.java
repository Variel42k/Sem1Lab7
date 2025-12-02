package Lab7;

public class Example4 {
    public static class P1 {
        public char ch;
        public P1(char ch) { this.ch = ch; }
        public P1(P1 other) { this.ch = other.ch; }
        @Override public String toString() { return "P1{ch='" + ch + "'}"; }
    }

    public static class P2 extends P1 {
        public String text;
        public P2(char ch, String text) { super(ch); this.text = text; }
        public P2(P2 other) { super(other); this.text = other.text; }
        @Override public String toString() { return "P2{ch='" + ch + "', text='" + text + "'}"; }
    }

    public static class P3 extends P2 {
        public int num;
        public P3(char ch, String text, int num) { super(ch, text); this.num = num; }
        public P3(P3 other) { super(other); this.num = other.num; }
        @Override public String toString() { return "P3{ch='" + ch + "', text='" + text + "', num=" + num + "}"; }
    }

    public static void main(String[] args) {
        P3 a = new P3('z', "hello", 100);
        P3 b = new P3(a);
        System.out.println(a);
        System.out.println(b);
    }
}

