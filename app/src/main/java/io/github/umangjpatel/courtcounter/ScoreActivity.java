package io.github.umangjpatel.courtcounter;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

public class ScoreActivity extends AppCompatActivity {

    private ScoreViewModel mScoreViewModel;

    private AppCompatTextView mTeamAScoreTextView, mTeamBScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mScoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        wireUpWidgets();
        updateUI();
    }

    private void updateUI() {
        updateTeamAScore();
        updateTeamBScore();
    }

    private void updateTeamBScore() {
        mTeamBScoreTextView.setText(mScoreViewModel.getTeamBScoreString());
    }

    private void updateTeamAScore() {
        mTeamAScoreTextView.setText(mScoreViewModel.getTeamAScoreString());
    }

    private void wireUpWidgets() {
        mTeamAScoreTextView = findViewById(R.id.team_a_score_text_view);
        mTeamBScoreTextView = findViewById(R.id.team_b_score_text_view);
    }

    public void addThreePoints(View view) {
        if (view.getId() == R.id.team_a_three_points_button)
            addTeamAThreePoints();
        else
            addTeamBThreePoints();
    }

    private void addTeamAThreePoints() {
        mScoreViewModel.addTeamAPoints(3);
        updateTeamAScore();
    }

    private void addTeamBThreePoints() {
        mScoreViewModel.addTeamBPoints(3);
        updateTeamBScore();
    }

    public void addTwoPoints(View view) {
        if (view.getId() == R.id.team_a_two_points_button)
            addTeamATwoPoints();
        else
            addTeamBTwoPoints();
    }

    private void addTeamATwoPoints() {
        mScoreViewModel.addTeamAPoints(2);
        updateTeamAScore();
    }

    private void addTeamBTwoPoints() {
        mScoreViewModel.addTeamBPoints(2);
        updateTeamBScore();
    }

    public void addFreeThrow(View view) {
        if (view.getId() == R.id.team_a_free_throw_button)
            addTeamAOnePoint();
        else
            addTeamBOnePoint();
    }

    private void addTeamAOnePoint() {
        mScoreViewModel.addTeamAPoints(1);
        updateTeamAScore();
    }

    private void addTeamBOnePoint() {
        mScoreViewModel.addTeamBPoints(1);
        updateTeamBScore();
    }

    public void resetScores(View view) {
        mScoreViewModel.resetScores();
        updateUI();
    }
}
