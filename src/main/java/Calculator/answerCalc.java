package Calculator; 

import dao.Dao;

import java.util.ArrayList;
import java.util.Collections;

public class answerCalc {
	public Dao dao;
	public ArrayList<Float> matchCandidates(ArrayList<Integer> answers) {
		dao = new Dao();
		dao.getConnection();
		int ehdokasMaara = dao.countEhdokkaat();
		float score = 0;
		ArrayList <Float> scoreList = new ArrayList<Float>();
		ArrayList <Integer> userAnswers = answers;
	//	ArrayList <Integer> bestMatches = new ArrayList <Integer>();
		int counted = 0;

		for (int i = 1; i <= ehdokasMaara; i++) {
			ArrayList <Integer> candAnswers = dao.lueVastaukset(i);

			score = 0;
			for (int y = 0; y < candAnswers.size(); y++) {
				if (userAnswers.get(y)!= 3 && candAnswers.get(y)!= 3)
					counted++;
				score += Math.abs(userAnswers.get(y) - candAnswers.get(y));
			}
			score = score / counted;
			scoreList.add(score);
		}

		scoreList.indexOf(Collections.min(scoreList));

		return scoreList;




	}
}
