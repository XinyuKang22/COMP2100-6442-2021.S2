public class MarkCalculator11 implements MarkCalculator {

    public MarkGrade calculateMark(int lab, int assignment1, int assignment2,
                                   int finalExam, boolean attendedFinal, boolean allRedeemableOnFinal)
            throws ComponentOutOfRangeException {

        if (!(0 <= lab && lab <= 10 && 0 <= assignment1 && assignment1 <= 10
                && 0 <= assignment2 && assignment2 <= 10 && 0 <= finalExam && finalExam <= 100))
            throw new ComponentOutOfRangeException();

        if (!attendedFinal)
            return new MarkGrade(null,Grade.NCN);

        int raw = Math.round((100*lab + 150*assignment1 + 150*assignment2 + 600*finalExam)/640f);

        if (allRedeemableOnFinal)
            raw = Math.max(raw, finalExam);

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
