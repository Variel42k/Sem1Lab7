package Lab7;

public class Example3 {
    public static class A {
        public int i;
        public A(int i) { this.i = i; }
        public void set(int i) { this.i = i; }
        @Override public String toString() { return "A{i=" + i + "}"; }
    }

    public static class B extends A {
        public char c;
        public B(int i, char c) { super(i); this.c = c; }
        public void set(int i, char c) { super.set(i); this.c = c; }
        @Override public String toString() { return "B{i=" + i + ", c='" + c + "'}"; }
    }

    public static class C extends B {
        public String s;
        public C(int i, char c, String s) { super(i, c); this.s = s; }
        public void set(int i, char c, String s) { super.set(i, c); this.s = s; }
        @Override public String toString() { return "C{i=" + i + ", c='" + c + "', s='" + s + "'}"; }
    }

    public static void main(String[] args) {
        C obj = new C(1, 'x', "str");
        System.out.println(obj);
        obj.set(2, 'y', "new");
        System.out.println(obj);
    }
}

