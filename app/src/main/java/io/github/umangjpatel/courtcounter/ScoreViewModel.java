package io.github.umangjpatel.courtcounter;

import android.arch.lifecycle.ViewModel;

import java.util.Locale;

public class ScoreViewModel extends ViewModel {

    private int mTeamAScore = 0, mTeamBScore = 0;

    public String getTeamAScoreString() {
        return String.format(Locale.getDefault(), "%d", mTeamAScore);
    }

    public String getTeamBScoreString() {
        return String.format(Locale.getDefault(), "%d", mTeamBScore);
    }

    public void addTeamAPoints(int points) {
        mTeamAScore += points;
    }

    public void addTeamBPoints(int points) {
        mTeamBScore += points;
    }

    public void resetScores() {
        mTeamAScore = mTeamBScore = 0;
    }
}
