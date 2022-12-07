package java8.enums;

import java.util.Comparator;

public enum Gender implements CharSequence {
    FEMALE,
    MALE;

    public boolean compareTo() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
    public static final Comparator<Gender>sortGender=new Comparator<Gender>() {
        @Override
        public int compare(Gender o1, Gender o2) {
            return o1.compareTo(o2);
        }
    };
}
