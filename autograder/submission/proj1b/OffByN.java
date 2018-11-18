public class OffByN implements CharacterComparator {
    private int offset;

    public OffByN(int N) {
        this.offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == -this.offset || diff == this.offset) {
            return true;
        }
        return false;
    }
}
