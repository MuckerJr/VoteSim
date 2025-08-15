package main.java.voting;

public enum PoliticalSpectrum {
    FAR_LEFT(-200, -141),
    LEFT(-140, -61),
    CENTRE_LEFT(-60, -21),
    CENTRE(-20, 20),
    CENTRE_RIGHT(21, 60),
    RIGHT(61, 140),
    FAR_RIGHT(141, 200),
    UNKNOWN(Integer.MIN_VALUE, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    PoliticalSpectrum(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() { return max; }

    public boolean contains(int value) {
        return value >= min && value <= max;
    }

    public static PoliticalSpectrum fromValue(int value) {
        for (PoliticalSpectrum ps: values()) {
            if (ps.contains(value)) {
                return ps;
            }
        }
        return UNKNOWN;
    }
}
