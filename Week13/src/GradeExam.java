
public class GradeExam {

	public static void main(String[] args) {
		
		char key[] = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
		char answers[][] = { {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}, 
							 {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'}, 
							 {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'}, 
							 {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'}, 
							 {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}, 
							 {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}, 
							 {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}, 
							 {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'} };
		int grades[] = getGrades(key, answers);
		outputGrades(grades);
		
	}
	
	public static int[] getGrades(char key[], char answers[][]) {
		int grades[] = new int[answers.length];
		for (int i = 0; i < answers.length; i++) {
			int tempGrade = 0;
			for (int j = 0; j < answers[0].length; j++) {
				if (key[j] == answers[i][j])
					tempGrade += 1;
			}
			grades[i] = tempGrade;
		}
		
		return grades;
	}
	
	public static void outputGrades(int grades[]) {
		for (int i = 0; i < grades.length; i++) {
			System.out.println("Student " + i + "'s correct count is " + grades[i]);
		}
	}

}
