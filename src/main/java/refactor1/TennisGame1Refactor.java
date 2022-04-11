package refactor1;

public class TennisGame1Refactor implements TennisGameRefactor {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1Refactor(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    @Override
    public String getScore() {
        if( areScoresEqual()){
            return calculateWhenEquals();
        };
        if( anyScoreGreaterThan4()){
            return calculateWhenGreaterThan4();
        }
        return calculateComparingResult();
    }

    private String calculateComparingResult() {
        String score = "";
        int temporaryScore = 0 ;//getTemporaryScore();
        for(int i = 1; i < 3; i++){
            score = addStringToScore(i, score);
            temporaryScore = getTemporaryScore(i);
            switch (temporaryScore){
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }

    private int getTemporaryScore(int i) {
        if (i == 1) return m_score1;
        return m_score2;
    }

    private String addStringToScore(int i, String score) {
        String score1 = score;
        if (i == 2){
            return score1 += "-";
        }
        return score1;
    }

    private String calculateWhenGreaterThan4() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private boolean anyScoreGreaterThan4() {
        return m_score1 >=4 || m_score2 >= 4 ;
    }

    private String calculateWhenEquals() {
        String score = "";
        switch (m_score1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private boolean areScoresEqual() {
        return m_score1 == m_score2;
    }
}
