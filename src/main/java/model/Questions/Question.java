package model.Questions;

import java.util.List;

public class Question {

    protected String text;
    protected int idx;
    protected List<String> oportunities;

    public int getPoint() {
        return point;
    }

    /**
     *
     * @param point
     */
    public void setPoint(int point) {
        this.point = point;
    }

    protected int point;

    public String getText() {
        return text;
    }

    public int getIdx() {
        return idx;
    }

    public List<String> getOportunities() {
        return oportunities;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void addOportunity(String oportunity) {
        oportunities.add(oportunity);
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", idx=" + idx +
                ", oportunities=" + oportunities +
                '}';
    }
}
