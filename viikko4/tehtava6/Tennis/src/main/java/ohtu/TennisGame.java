package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private String equalScores() {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private String endGameScore() {
        String score;
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            score = "Advantage player1";
        } else if (scoreDifference == -1) {
            score = "Advantage player2";
        } else if (scoreDifference >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }

        return score;
    }

    private String nonEndGameScore() {
        int tempScore;
        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    public String getScore() {
        String score;
        if (player1Score == player2Score) {
            score = equalScores();
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = endGameScore();
        } else {
            score = nonEndGameScore();
        }
        return score;
    }
}
