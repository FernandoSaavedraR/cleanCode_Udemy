package com.b.simple.design.business.student;

public class StudentHelper {

    /* PROBLEM 1 */
 /*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
     */
    private static final int GRADE_B_UPPER_LIMIT = 80;
    private static final int GRADE_B_LOWER_LIMIT = 50;
    private static final int GRADE_A_LOWER_LIMIT = 90;
    private static final int EXTRA_LIMIT_GRADE_MATH = 5;
    private static final int EXTRA_LIMIT_FOR_MATH = 10;
    private static final int QUIZ_YES_LOWER_LIMIT = 80;
    private static final int QUIZ_NO_LOWER_LIMIT = 20;

    public boolean isGradeB(int marks, boolean isMaths) {
        int extraLimit = isMaths ? EXTRA_LIMIT_FOR_MATH : 0;
        int UpperLimit = GRADE_B_UPPER_LIMIT + extraLimit;
        return marks > GRADE_B_LOWER_LIMIT && marks <= UpperLimit;
    }


    /* PROBLEM 2 */
 /*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
     */
    public String getGrade(int mark, boolean isMaths) {

        int extraLimit = isMaths ? EXTRA_LIMIT_GRADE_MATH : 0;

        if (mark > GRADE_A_LOWER_LIMIT + extraLimit) {
            return "A";
        }
        if (mark > GRADE_B_LOWER_LIMIT + extraLimit) {
            return "B";
        }
        return "C";
    }

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
     */
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {

        int extraLimit = isMaths ? EXTRA_LIMIT_GRADE_MATH : 0;
        int lowerNoLimit = QUIZ_NO_LOWER_LIMIT + extraLimit;
        int lowerYesLimit = QUIZ_YES_LOWER_LIMIT + extraLimit;
        if (isNotGood(marks1, lowerNoLimit)
                || isNotGood(marks2, lowerNoLimit)) {
            return "NO";
        }
        if (isGood(marks1, lowerYesLimit)
                || isGood(marks2, lowerYesLimit)) {
            return "YES";
        }
        return "MAYBE";
    }

    public boolean isNotGood(int mark, int limit) {
        return mark <= limit;
    }

    public boolean isGood(int mark, int limit) {
        return mark >= limit;
    }

}
