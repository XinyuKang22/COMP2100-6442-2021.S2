public class MarkCalculator14 implements MarkCalculator {

    public MarkGrade calculateMark(int lab, int assignment1, int assignment2,
                                   int finalExam, boolean attendedFinal, boolean allRedeemableOnFinal)
            throws ComponentOutOfRangeException {

        if (!(0 <= lab && lab <= 10 && 0 <= assignment1 && assignment1 <= 10
                && 0 <= assignment2 && assignment2 <= 10 && 0 <= finalExam && finalExam <= 100))
            throw new ComponentOutOfRangeException();

        if (!attendedFinal)
            return new MarkGrade(null,Grade.NCN);

        int raw =  Math.floorDiv(assignment1, 15)*10 + Math.floorDiv(assignment2, 15)*10 + Math.floorDiv(lab, 10)*10
                + Math.floorDiv(finalExam, 100)*60;

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
