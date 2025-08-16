package main.java.voting;

import java.util.*;

public class Voter {
    private final List<Party> preferences;
    private Party tacticalVote;
    private int spectrumScore;

    public Voter(int spectrumScore, List<Party> preferences, double baseTacticalChance) {
        this.spectrumScore =spectrumScore;
        this.preferences = SpectrumUtil.rankPartiesByDistance(spectrumScore, preferences);
    }

    // --- core getters & mutators ---

    public int getSpectrumScore() {
        return spectrumScore;
    }

    private void setSpectrumScore(int spectrumScore) {
        // Private for now, perhaps external factors can nudge a voter's score, but that will need to be done elsewhere?
        this.spectrumScore = spectrumScore;
    }

    public String getCurrentLeaning() {
        return SpectrumUtil.getLabel(spectrumScore);
    }

    public Party getTopChoice() {
        return preferences.getFirst();
    }

    public List<Party> getPartyPreferences() {
        return preferences;
    }

    // ----  Voter Behaviour, to be implemented later ----

//     Perhaps the logic for casting a vote should belong
//     to each voter. Then it can be called from within
//     the election engin logic
    public double calculateTacticalVoteChance(double baseTacticalChance) {
        //TODO
        // Assumption is that base tactical is 25%
        return baseTacticalChance;
    }

    public void castVote() {
        //TODO
        // The voter needs to assess the odds of their top candidate winning
        // - is my candidate a major party (for now)?
        // The voter must decide if this will make them vote tactically for the closest major party
    }

    @Override
    public String toString() {
        return "Voter{" +
                "spectrumScore=" + spectrumScore +
                ", currentSpectrum=" + getCurrentLeaning() +
                ", topChoice=" + getTopChoice() +
                '}';
    }
}
