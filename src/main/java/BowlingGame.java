public class BowlingGame {
    public int getScore(int[] downSituation) throws Exception {
        if (downSituation.length < 11) {
            throw new Exception();
        }
        for (int i = 0; i < downSituation.length; i++) {
            if (downSituation[i] > 10 || downSituation[i]<0) {
                throw new Exception();
            }
        }
        int index = 0;
        int[] scoreArray = new int[24];
        for (int i = 0; i < scoreArray.length; i++) {
            scoreArray[i] = 0;
        }
        for (int i = 0; i < downSituation.length; i++) {
            index = saveSore(scoreArray, downSituation[i], index);
        }
        int totalScore = getRoundScore(scoreArray);

        return totalScore;
    }

    public int saveSore(int[] scoreArray, int score, int index) {
        scoreArray[index] = score;
        ++index;
        if (score == 10) {
            ++index;
        }
        return index;
    }

    public int getEachRoundScore(int[] scoreArray, int round) {
        int eachRoundScore = 0;
        int roundIndex = 2 * (round - 1);
        if (scoreArray[roundIndex] == 10) {
            eachRoundScore = scoreArray[roundIndex] + scoreArray[roundIndex += 2];
            //judge round 10 the second is 10 or not when the first is strike
            if (scoreArray[roundIndex] == 10) {
                eachRoundScore += scoreArray[roundIndex += 2];
            } else {
                eachRoundScore += scoreArray[++roundIndex];
            }
        } else {
            eachRoundScore = scoreArray[roundIndex] + scoreArray[++roundIndex];
            if (eachRoundScore == 10) {
                eachRoundScore += scoreArray[++roundIndex];
            }
        }
        return eachRoundScore;
    }

    public int getRoundScore(int[] scoreArray) {
        int roundScore = 0;
        int rounds = 10;
        for (int i = 1; i <= rounds; i++) {
            roundScore += getEachRoundScore(scoreArray, i);
        }
        return roundScore;
    }
}
