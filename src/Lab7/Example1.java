package Lab7;

public class Example1 {
    // Суперкласс
    public static class SuperText {
        private String text;

        public SuperText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "SuperText{text='" + text + "'}";
        }

        public String getText() { return text; }
    }

    // Подкласс
    public static class SubText extends SuperText {
        private String extra;

        public SubText(String text) {
            super(text);
            this.extra = null;
        }

        public SubText(String text, String extra) {
            super(text);
            this.extra = extra;
        }

        @Override
        public String toString() {
            return "SubText{text='" + getText() + "', extra='" + extra + "'}";
        }
    }

    // main для демонстрации
    public static void main(String[] args) {
        SuperText s1 = new SuperText("Привет Мир");
        SubText s2 = new SubText("Слово2");
        SubText s3 = new SubText("Слова2", "Слово3");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
