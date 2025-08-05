package test.java.voting;

import main.java.voting.PoliticalSpectrum;
import main.java.voting.SpectrumUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpectrumUtilTest {

    @Test
    void getScore() {
        assertEquals(-3, SpectrumUtil.getScore(PoliticalSpectrum.FAR_LEFT));
        assertEquals(0, SpectrumUtil.getScore(PoliticalSpectrum.CENTRE));
        assertEquals(3, SpectrumUtil.getScore(PoliticalSpectrum.FAR_RIGHT));
        assertEquals(0, SpectrumUtil.getScore(PoliticalSpectrum.UNKNOWN));
    }

    @Test
    void calculateDistance() {
        assertEquals(0, SpectrumUtil.calculateDistance(PoliticalSpectrum.LEFT, PoliticalSpectrum.LEFT));
        assertEquals(6, SpectrumUtil.calculateDistance(PoliticalSpectrum.FAR_LEFT, PoliticalSpectrum.FAR_RIGHT));
        assertEquals(3, SpectrumUtil.calculateDistance(PoliticalSpectrum.CENTRE_LEFT, PoliticalSpectrum.RIGHT));
        assertEquals(2, SpectrumUtil.calculateDistance(PoliticalSpectrum.UNKNOWN, PoliticalSpectrum.LEFT));
    }
}