public class MarkCalculator12 implements MarkCalculator {

    public MarkGrade calculateMark(int lab, int assignment1, int assignment2,
                                   int finalExam, boolean attendedFinal, boolean allRedeemableOnFinal)
            throws ComponentOutOfRangeException {

        if (!(0 <= lab && lab <= 10 && 0 <= assignment1 && assignment1 <= 10
                && 0 <= assignment2 && assignment2 <= 10 && 0 <= finalExam && finalExam <= 100))
            throw new ComponentOutOfRangeException();

        if (!attendedFinal)
            return new MarkGrade(null,Grade.NCN);

        int sum = 0;
        // Take note: how to not to write a summation.
        while (lab > 0 || assignment1 > 0 || assignment2 > 0 || finalExam > 0) {
            if (lab > 0) {
                sum += lab*100;
                lab = 0;
            } else if (assignment1 > 0) {
                sum += assignment1*150;
                assignment1 = 0;
            } else if (assignment2 > 0) {
                sum += assignment2*150;
                assignment2 = 0;
            } else if (finalExam > 0) {
                sum += finalExam*60;
                finalExam = 0;
            } else {
                break;
            }
        }
        int raw = (sum % 100 < 50? sum/100 : sum / 100 + 1);

        if (raw < 45)
            return new MarkGrade(raw, Grade.N);
        else if (raw < 50)
            return new MarkGrade(raw, Grade.PX);
        else if (raw < 60)
            return new MarkGrade(raw, Grade.P);
        else if (raw < 70)
            return new MarkGrade(raw, Grade.C);
        else if (raw < 80)
            return new MarkGrade(raw, Grade.D);
        else
            return new MarkGrade(raw, Grade.HD);
    }
}
