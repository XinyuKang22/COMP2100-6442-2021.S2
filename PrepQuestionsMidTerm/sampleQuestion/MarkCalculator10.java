public class MarkCalculator10 implements MarkCalculator {

    public MarkGrade calculateMark(int lab, int assignment1, int assignment2,
                                   int finalExam, boolean attendedFinal, boolean allRedeemableOnFinal)
            throws ComponentOutOfRangeException {

        if (!attendedFinal)
            return new MarkGrade(null,Grade.NCN);

        int raw = Math.round(( (assignment1/10.0f) * 15.0f + (assignment2/10.0f) * 15.0f + (lab/10.0f) * 10.0f + (finalExam/100.0f) * 60.0f) );

        if (allRedeemableOnFinal)
            raw = Math.min(raw, finalExam);

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
