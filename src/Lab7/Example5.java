package Lab7;

public class Example5 {
    public static class Parent {
        private String text;
        public Parent(String text) { this.text = text; }
        public void show() { System.out.println("Parent: text='" + text + "'"); }
        public String getText() { return text; }
    }

    public static class ChildOne extends Parent {
        protected int number;
        public ChildOne(int number, String text) { super(text); this.number = number; }
        @Override public void show() { System.out.println("ChildOne: number=" + number + ", text='" + getText() + "'"); }
    }

    public static class ChildTwo extends Parent {
        protected char ch;
        public ChildTwo(char ch, String text) { super(text); this.ch = ch; }
        @Override public void show() { System.out.println("ChildTwo: ch='" + ch + "', text='" + getText() + "'"); }
    }

    public static void main(String[] args) {
        Parent p = new Parent("base");
        ChildOne c1 = new ChildOne(7, "seven");
        ChildTwo c2 = new ChildTwo('q', "letter");

        p.show();
        c1.show();
        c2.show();

        Parent ref;
        ref = c1; ref.show();
        ref = c2; ref.show();
    }
}
